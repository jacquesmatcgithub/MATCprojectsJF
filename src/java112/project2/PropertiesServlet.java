package java112.project2;

import java112.utilities.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 *  The main objective of the PropertiesServlet is to output a table
 *  containing the keys and values of the project properties file.
 *
 *@author    Jacques Fourie
 */
@WebServlet(
    name = "project2PropertiesServlet",
    urlPatterns = { "/props" }
)
public class PropertiesServlet extends HttpServlet
    implements PropertiesLoaderInterface {

    private Properties properties;

    /**
     * The initializer method loads the project properties file into a
     * properties object.
     */
    public void init() throws ServletException {
        properties = loadProperties("/project2.properties");
    }
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>PropertiesServlet Output</TITLE></HEAD>");

        out.print("<style>");
        out.print("table {font-family: arial, sans-serif;border-collapse: collapse; width: 100%;}");
        out.print("td, th {border: 1px solid #dddddd;text-align: left;padding: 8px;}");
        out.print("tr:nth-child(odd) {background-color: #dddddd;}");
        out.print("</style>");

        out.print("<BODY>");
        out.print("<h1>Properties Servlet</h1>");

        out.print("<table style=\"width:50%\">");
        out.print("<tr><th>Key</th><th>Value</th></tr>");

        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            out.print("<tr><td>" + entry.getKey() + "</td>");
            out.print("<td>" + entry.getValue() + "</td></tr>");
        }

        out.print("</table>");

        out.print("<p><a href=\"/java112\">home page</a></p>");

        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}