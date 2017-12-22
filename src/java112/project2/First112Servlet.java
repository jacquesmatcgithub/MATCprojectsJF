package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.utilities.*;
import java.util.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    Jacques Fourie
 */
@WebServlet(
    name = "project2First112Servlet",
    urlPatterns = { "/first112" }
)
public class First112Servlet extends HttpServlet {

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
        out.print("<HEAD><TITLE>First112Servlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Name: Jacques Fourie</h1>");
        out.print("<h1>Course: Advanced Java</h1>");
        out.print("<img src=\"images/ones-and-zeroes.jpg\" width=\"500\" height=\"300\"/>");
        out.print("<p><a href=\"/java112\">home page</a></p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}