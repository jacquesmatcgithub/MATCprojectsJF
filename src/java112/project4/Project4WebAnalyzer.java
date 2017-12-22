package java112.project4;

import java112.analyzer.*;
import java112.utilities.*;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.net.*;

@WebServlet(
    name = "Project4WebAnalyzer",
    urlPatterns = { "/project4WebAnalyzer" }
)

@MultipartConfig(
)

/**
 * The Project4WebAnalyzer class allows the user to upload a token and
 * keyword file and then activate the Analyzer class on those files.
 *
 *@author    Jacques Fourie
 */
public class Project4WebAnalyzer extends HttpServlet
    implements PropertiesLoaderInterface {

    private Properties properties;
    private String pathToUpload;
    private String thisPathWorked;

    private final static String WEB_PROPERTIES_FILE = "/web_analyzer.properties";
    private final static String UPLOAD_PATH = "/tmp";
    private final static String TOKEN_FILE_FROM_FORM = "tokenFile";
    private final static String KEYWORD_FILE_FROM_FORM = "keywordFile";
    private final static String UPLOAD_FOLDER = "upload";
    private final static String OUTPUT_FOLDER = "output";

    private final static String ERR_ENTER_BOTH = "Please select both a token " +
            "and a keyword file to upload.";

    private final static Logger LOGGER =
        Logger.getLogger(Project4WebAnalyzer.class.getCanonicalName());


    /**
     * The init method creates a properties object from the
     * webAnalyzerProperties servlet context attribute. This
     * properties object is used in varioius places in the
     * Project4WebAnalyzer servlet.
     */
    @Override
    public void init()throws ServletException{
        ServletContext servletContext = getServletContext();
        properties = (Properties)servletContext.getAttribute("webAnalyzerProperties");
    }


    /**
     * The doPost metod will call methods to upload a file to the
     * server and to execute the analyzer app.
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String url;

        if (formPassedValidation(request)) {
            String tokenFilePath = uploadFiles(request, response);
            executeAnalyzers(request, tokenFilePath);

            url = "/jsp/webAnalyzer-output.jsp";
        } else {
            url = "/jsp/webAnalyzer.jsp";
        }

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    /**
     * The formPassedValidation method validates that the user selected
     * both a token file and a keyword file to upload.
     * @param  request the HttpRequest.
     * @return boolean Whether or not the form passed all validations.
     */
    public boolean formPassedValidation(HttpServletRequest request) {
        Part filePart;
        boolean passValidation = false;

        try {
            filePart = request.getPart("tokenFile");
            String tokenFileName = getFileName(filePart);

            filePart = request.getPart("keywordFile");
            String keywordFileName = getFileName(filePart);

            if (tokenFileName.equals("") || keywordFileName.equals("")) {
                passValidation = false;

                HttpSession session = request.getSession();
                session.setAttribute("webAnalyzerMessage", ERR_ENTER_BOTH);
            } else {
                passValidation = true;
            }
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } finally {
            return passValidation;
        }
    }

    /**
     * The executeAnalyzer method will instantiate an object from the
     * AnalyzeFile class in order to execute the Analyzer application.
     * @param request the HttpRequest
     * @param tokenFilePath The upload file path.
     * @exception ServletException if there is a general servlet exception
     * @exception IOException if there is a general I/O exception
     */
    public void executeAnalyzers(HttpServletRequest request, String tokenFilePath)
            throws ServletException, IOException {
        String[] analyzerArguments = new String[2];

        analyzerArguments[0] = tokenFilePath;
        analyzerArguments[1] = WEB_PROPERTIES_FILE;

        AnalyzeFile analyzer = new AnalyzeFile();
        analyzer.runAnalysis(analyzerArguments);
    }


    /**
     * The uploadFiles calles methods to upload the token file and the
     * keyword file.
     * @param request the HttpRequest
     * @param response the HttpResponse
     * @return String The filepath of the file that was uploaded.
     * @exception ServletException if there is a general servlet exception
     * @exception IOException if there is a general I/O exception
     */
    public String uploadFiles(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String uploadPath = UPLOAD_PATH;
        String outputPath;

        String[] filePath = createFileDestinations(uploadPath, request);

        uploadPath = filePath[0];
        outputPath = filePath[1];

        String tokenFileName = uploadFileToServer(request, response,
                uploadPath, TOKEN_FILE_FROM_FORM);
        String keywordFileName = uploadFileToServer(request, response,
                uploadPath, KEYWORD_FILE_FROM_FORM);

        updatePropertyFile(uploadPath + keywordFileName, outputPath);

        return uploadPath + tokenFileName;
    }


    /**
     * The uploadFileToServer metod will upload a file the user selects to the
     * server.
     * @param request The HttpRequest.
     * @param response The HttpResponse.
     * @param path The upload path to use.
     * @param fileToUpload The variable from the form containing
     * the file name to upload.
     * @return String The name fo the uploaded file.
     * @exception ServletException if there is a general servlet exception.
     * @exception IOException if there is a general I/O exception.
     */
    protected String uploadFileToServer(HttpServletRequest request,
            HttpServletResponse response, String path, String fileToUpload)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        final Part filePart = request.getPart(fileToUpload);
        final String fileName = getFileName(filePart);

        OutputStream outputStream = null;
        InputStream filecontent = null;

        try {
            outputStream = new FileOutputStream(
                    new File(path + File.separator + fileName));

            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }

            return fileName;
        }
    }


    /**
     * The getFileName method retrieves the file name from the
     * multipart/form-data POST request.
     * @param part The getPart for <i>file</i> from HttpServletRequest.
     * @return String The name of the file that was selected for upload.
     */
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");

        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }


    /**
     * The createFileDestinations method will create the file upload
     * destination if it doesn't exist already. The upload destination
     * is in the format of /tmp/{application name}/
     * It will also create the output destination where the analyzer
     * output files will reside and set the upload.dir and output.dir
     * properties wiht the fill file paths for those destinations.
     * @param path The basic file path.
     * @param request The HttpRequest
     * @return String[] The path names of the upload and output paths.
     *                  The [0] return string contains the full upload path.
     *                  The [1] return string contains the full output path.
     */
    public String[] createFileDestinations(String path, HttpServletRequest request) {

        String applicationName = properties.getProperty("application.name");

        String uploadPath = buildFilePath(path, applicationName, UPLOAD_FOLDER);

        createDirectory(uploadPath);

        String outputPath = buildFilePath(path, applicationName, OUTPUT_FOLDER);

        createDirectory(outputPath);

        HttpSession session = request.getSession();
        session.setAttribute("outputPath", outputPath);

        return new String[] {uploadPath, outputPath};
    }


    /**
     * The buildFilePath concatenates the various parts of the file path.
     * @param path The basic file path.
     * @param applicationName The application.name property value.
     * @param pathTail The last qualifier in the file path.
     * @return String The fully built file path.
     */
    public String buildFilePath(String path, String applicationName, String pathTail) {

        File file = new File(path);

        return path + file.separator + applicationName + file.separator +
               pathTail + file.separator;
    }


    /**
     * The createDirectory method will create the directory specified in
     * in the <i>path</i> parameter if it doesn't exist already.
     * @param path The directory file path to be created if it doesn't
     * exist already.
     */
    public void createDirectory(String path) {

        File uploadDirectory = new File(path);

        if(!uploadDirectory.exists()){
            uploadDirectory.mkdirs();
        }
    }


    /**
     * The updateKeywordsProperty method updates the file.path.keywords
     * property on the web_analyzer.properties file.
     * @param keywordFilePath The filepath of the keyword file uploaded
     * @param outputPath The filepath of where the analyzer output will reside.
     * by the user.
     */
    public void updatePropertyFile(String keywordFilePath, String outputPath) {

        FileOutputStream fileOutputStream = null;

        Properties newProperties = loadProperties(WEB_PROPERTIES_FILE);

        try {
            URL url = this.getClass().getResource(WEB_PROPERTIES_FILE);

            fileOutputStream = new FileOutputStream(new File(url.toURI()));

            newProperties.setProperty("file.path.keywords", keywordFilePath);
            newProperties.setProperty("output.dir", outputPath);

            newProperties.store(fileOutputStream, null);

        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();

        } catch (URISyntaxException uriSyntaxException) {
            uriSyntaxException.printStackTrace();

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();

        } catch (IOException ioException) {
            ioException.printStackTrace();

        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}