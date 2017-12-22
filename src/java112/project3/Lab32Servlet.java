package java112.project3;

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
    name = "lab32Servlet",
    urlPatterns = { "/lab32servlet" }
)

public class Lab32Servlet extends HttpServlet {

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

        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();

        out.print("<HTML>");
        out.print("<HEAD><TITLE>First112Servlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Hello from Lab32Servlet</h1>");

        out.print("<ul>");
        out.print("<li>");
        out.print("Locale: ");
        out.print(request.getLocale());
        out.print("</li>");

        out.print("<li>");
        out.print("Context Path: ");
        out.print(request.getContextPath());
        out.print("</li>");

        out.print("<li>");
        out.print("Local Name: ");
        out.print(request.getLocalName());
        out.print("</li>");

        out.print("<li>");
        out.print("Scheme: ");
        out.print(request.getScheme());
        out.print("</li>");
        out.print("</ul>");
        out.print("<p><a href=\"/java112\">home page</a></p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}





