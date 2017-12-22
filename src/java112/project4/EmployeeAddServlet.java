package java112.project4;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * The EmployeeAddServlet servlet forwards the request to the
 * employee-add.jsp.
 *
 *@author    Jacques Fourie
 */
@WebServlet(
    name = "employeeAddServlet",
    urlPatterns = { "/Project4EmployeeAddServlet" }
)

public class EmployeeAddServlet extends HttpServlet {

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

        String url = "/jsp/employee-add.jsp";

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}





