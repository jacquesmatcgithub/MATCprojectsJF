package java112.project4;

import java112.utilities.*;
import java112.employee.*;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * The ApplicationStartup class loads the project 4 properties as an
 * attribute, also the web analyzer properties and EmployeeDirectory.
 *
 *@author    Jacques Fourie
 */
@WebServlet(
    name = "applicationStartup",
    urlPatterns = { "/project4-startup" },
    loadOnStartup = 1
)

public class ApplicationStartup extends HttpServlet
        implements PropertiesLoaderInterface {


    /**
     * This is the init method of the servlet. It loads the project 4
     * and web analyzer properties files, and instantiates an
     * EmployeeDirectory object as a ServletContext attribute.
     */
    public void init() throws ServletException {
        Properties properties = loadProperties("/project4.properties");

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("project4Properties", properties);

        EmployeeDirectory employeeDirectory = new EmployeeDirectory(properties);
        servletContext.setAttribute("employeeDirectory", employeeDirectory);

        Properties webProperties = loadProperties("/web_analyzer.properties");
        servletContext.setAttribute("webAnalyzerProperties", webProperties);
    }
}





