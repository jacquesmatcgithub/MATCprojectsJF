package java112.project4;

import java112.employee.*;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * The EmployeeSearch servlet receives the form data from the web page,
 * validates the data and uses the EmployeeDirectory class to search
 * the employee database for the data entered on the web page.
 *
 *@author    Jacques Fourie
 */
@WebServlet(
    name = "employeeSearch",
    urlPatterns = { "/Project4Search" }
)

public class EmployeeSearch extends HttpServlet {

    private static final String SEARCH_BY_ID = "ID";

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

        HttpSession session = request.getSession();

        ServletContext servletContext = getServletContext();

        Properties properties = (Properties)servletContext.getAttribute("project4Properties");

        EmployeeDirectory employeeDirectory = (EmployeeDirectory)servletContext.getAttribute("employeeDirectory");

        String searchTerm = request.getParameter("searchTerm").trim();
        String searchType = request.getParameter("searchType");

        String returnMessage = validateForm(searchTerm, properties);

        if (!returnMessage.equals("")) {
            session.setAttribute("searchmessage",returnMessage);
            forwardToEmployeeSearchPage(request, response);
            return;
        }

        Search search = new Search();
        search = employeeDirectory.searchEmployee(searchTerm, searchType);

        if (!search.getEmployeeFound()) {
            session.setAttribute("searchmessage", properties.getProperty("msg.employee.not.found"));
            forwardToEmployeeSearchPage(request, response);
            return;
        }

        session.setAttribute("searchmessage","");

        List<Employee> results = new ArrayList<Employee>();
        results = search.getResults();

        servletContext.setAttribute("searchResults", results);

        if (searchType.equals(SEARCH_BY_ID)) {
            forwardToEmployeeUpdatePage(request, response);
        } else {
            forwardToEmployeeSearchPage(request, response);
        }
    }


    /**
     * The validateForm method validates the fields on the form.
     * @param searchTerm The saechTerm from the form
     * @param properties The application properties
     * @return String The return message passed back to the caller
     */
    public String validateForm(String searchTerm, Properties properties) {
        if (searchTerm == null || searchTerm.equals("")) {
            return properties.getProperty("msg.no.search.criteria");
        } else {
            return "";
        }
    }


    /**
     * The forwardToEmployeeSearchPage method forwards control to the
     * employee search page.
     * @param  request               the HttpRequest
     * @param  response              the HttpResponse
     * @exception  ServletException  if there is a general servlet exception
     * @exception  IOException       if there is a general I/O exception
     */
    public void forwardToEmployeeSearchPage(HttpServletRequest request,
                                            HttpServletResponse response)
        throws ServletException, IOException {

        String url = "/jsp/employee-search-results.jsp";

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    /**
     * The forwardToEmployeeUpdatePage method forwards control to the
     * employee update page.
     * @param  request               the HttpRequest
     * @param  response              the HttpResponse
     * @exception  ServletException  if there is a general servlet exception
     * @exception  IOException       if there is a general I/O exception
     */
    public void forwardToEmployeeUpdatePage(HttpServletRequest request,
                                            HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/jsp/employee-update.jsp";

        RequestDispatcher  dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}