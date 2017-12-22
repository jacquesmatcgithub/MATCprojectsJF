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
    name = "requestServlet",
    urlPatterns = { "/request-servlet" }
)

public class HttpRequestServlet extends HttpServlet {

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

        HttpRequestData httpRequestData = new HttpRequestData();

        httpRequestData.setRemoteComputer(request.getRemoteHost());
        httpRequestData.setRemoteComputerAddress(request.getRemoteAddr());
        httpRequestData.setHttpMethod(request.getMethod());
        httpRequestData.setRequestURI(request.getRequestURI());
        httpRequestData.setRequestURL(request.getRequestURL());
        httpRequestData.setRequestProtocol(request.getScheme());
        httpRequestData.setServerName(request.getServerName());
        httpRequestData.setServerPortNumber(request.getServerPort());
        httpRequestData.setCurrentLocale(request.getLocale());
        httpRequestData.setQueryString(request.getQueryString());
        httpRequestData.setQueryParameterValue(
                request.getParameter("queryParameter"));
        httpRequestData.setRequestHeaderUserAgent(
                request.getHeader("User-Agent"));

        request.setAttribute("httpRequestData", httpRequestData);


        String url = "/javaBeanProperties.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}

