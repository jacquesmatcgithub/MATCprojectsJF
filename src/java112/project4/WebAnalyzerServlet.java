package java112.project4;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * The WebAnalyzerServlet transfers control to the webAnalyzer jsp.
 *
 *@author    Jacques Fourie
 */
@WebServlet(
    name = "webAnalyzerServlet",
    urlPatterns = { "/webAnalyzerServlet" }
)

public class WebAnalyzerServlet extends HttpServlet {

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

        String url = "/jsp/webAnalyzer.jsp";

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}





