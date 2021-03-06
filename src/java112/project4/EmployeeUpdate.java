package java112.project4;

import java112.employee.*;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * The EmployeeUpdate servlet receives data from the employee-search.jsp to update
 * an employee on the employee table. It also passes back a message to the
 * Project4EmployeeUpdateServlet.
 *
 *@author    Jacques Fourie
 */
@WebServlet(
        name = "employeeUpdate",
        urlPatterns = { "/Project4Update" }
)

public class EmployeeUpdate extends HttpServlet {

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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        ServletContext servletContext = getServletContext();

        Properties properties = (Properties)servletContext.getAttribute("project4Properties");

        EmployeeDirectory employeeDirectory = (EmployeeDirectory)servletContext.getAttribute("employeeDirectory");

        int empId = Integer.parseInt(request.getParameter("empId").trim());
        String firstName = request.getParameter("firstName").trim();
        String lastName = request.getParameter("lastName").trim();
        String employeeSSN = request.getParameter("employeeSSN").trim();
        String department = request.getParameter("department").trim();
        String roomNumber = request.getParameter("roomNumber").trim();
        String phoneNumber =request.getParameter("phoneNumber").trim();

        String returnMessage = validateForm(firstName, lastName, employeeSSN,
                department, roomNumber, phoneNumber, properties);

        if (!returnMessage.equals("")) {
            session.setAttribute("project4SearchMessage", returnMessage);
            redirectToEmployeeSearchPage(response);
            return;
        }

        String message = employeeDirectory.updateEmployee(empId, firstName, lastName,
                employeeSSN, department, roomNumber, phoneNumber);

        session.setAttribute("project4SearchMessage", message);

        redirectToEmployeeSearchPage(response);
    }


    /**
     * The validateForm method validates the fields on the form.
     * @param firstName The employee's first name
     * @param lastName The employee's last name
     * @param employeeSSN The employee's social security number
     * @param department The employee's department
     * @param roomNumber The employee's room number
     * @param phoneNumber The employee's phone number
     * @return String The return message passed back to the caller
     * @param properties The application properties
     */
    public String validateForm(String firstName, String lastName,
                               String employeeSSN, String department,
                               String roomNumber, String phoneNumber,
                               Properties properties) {

        if (firstName == null || lastName == null ||
                employeeSSN == null || department == null ||
                roomNumber == null || phoneNumber == null ||
                firstName.equals("") || lastName.equals("") ||
                employeeSSN.equals("") || department.equals("") ||
                roomNumber.equals("") || phoneNumber.equals("")) {
            return properties.getProperty("msg.enter.all.employee.details");
        } else {
            return "";
        }
    }


    /**
     * The redirectToEmployeeSearchPage method redirects control to the employee
     * add page.
     * @param  response              the HttpResponse
     * @throws ServletException If there is a general servlet exception.
     * @throws IOException If there is a general I/O exception.
     */
    public void redirectToEmployeeSearchPage(HttpServletResponse response)
            throws ServletException, IOException {
        String url = "Project4EmployeeSearchServlet";

        response.sendRedirect(url);

    }
}
