package java112.project4;

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
    name = "lab41Servlet",
    urlPatterns = { "/project4lab41Servlet" }
)

public class Lab41Servlet extends HttpServlet {

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

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");

        response.setContentType("text/html");


        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Lab41Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>First Name: " + firstName + "</h1>");
        out.print("<h1>Last Name: " + lastName + "</h1>");
        out.print("<h1>Age: " + age + "</h1>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}





