package java112.project;

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
    name = "project4SessionLab",
    urlPatterns = { "/project4SessionLabServlet" }
)

public class Project4SessionLab extends HttpServlet {

    private int pageCount;  // this is threadsafe because it's a primitive (atomic) variable.
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

        pageCount += 1;  // not part of the session and so it increments
                         // the same for each page that loads the servlet

        HttpSession session = request.getSession(); // session is not created new every time
                                                    // the servlet is executed.


        Integer sessionCounter = (Integer)session.getAttribute("project4SessionCounter");

        if (sessionCounter == null) {   // first time the servlet is accessed
            session.setAttribute("project4SessionCounter", new Integer(1));
        } else {                        // subsequent accesses to the servlet
            int counter = sessionCounter.intValue();
            session.setAttribute("project4SessionCounter", new Integer(counter += 1));
        }

        session.setAttribute("pageCount", pageCount);
        session.setAttribute("sessionID", session.getId());

        String url = "/project4Session.jsp";

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}





