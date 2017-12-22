package java112.project3;

import java112.utilities.*;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *
 *
 *@author    Jacques Fourie
 */
@WebServlet(
    name = "project3PropertiesServlet",
    urlPatterns = { "/project3-properties" }
)

public class PropertiesServlet extends HttpServlet
        implements PropertiesLoaderInterface {

    private Properties properties;


     /**
     * TODO: comment
     */
    public void init() {
        properties = loadProperties("/project3.properties");
    }


    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general
     *                              servlet exception
     *@exception  IOException       if there is a general
     *                              I/O exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {


        request.setAttribute("project3properties", properties);

        String url = "/project3Properties.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}

