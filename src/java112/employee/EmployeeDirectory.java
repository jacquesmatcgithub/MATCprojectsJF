package java112.employee;

import java112.utilities.*;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * The EmployeeDirectory class is used to add employee records to the
 * database. It also lets the caller search the employee database
 * by employee id, emaployee last name or employee first name.
 *
 * @author Jacques Fourie
 * class EmployeeDirectory
 */
public class EmployeeDirectory implements PropertiesLoaderInterface {

    private static final String SQL_INSERT =
        "INSERT INTO employees (first_name, last_name, ssn, " +
        "dept, room, phone) VALUES (?,?,?,?,?,?)";
    private static final String COMMON_SELECT_SQL_SNIPPET =
        "SELECT emp_id, first_name, last_name, ssn, dept, room, phone " +
        "FROM employees WHERE ";

    private static final String SEARCH_BY_ID = "ID";
    private static final String SEARCH_BY_LAST_NAME = "LASTNAME";
    private static final String SEARCH_BY_FIRST_NAME = "FIRSTNAME";

    private Properties properties;


    /**
     * Constructor for EmployeeDirectory
     */
    public EmployeeDirectory() {
    }


    /**
     * Constructor for EmployeeDirectory
     * @param properties The project properties.
     */
    public EmployeeDirectory(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * The connectToDB method establishes a connection to the database.
     * @return Connection The database connection.
     */
    private Connection connectToDB() {
        Connection connection = null;

        try {
            Class.forName(properties.getProperty("driver"));

            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));

        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            return connection;
        }
    }


    /**
     * The addEmployee method adds an employee to the database.
     * @param firstName Employee first name
     * @param lastName Employee last name
     * @param socialSecurityNumber Employee social securiry number
     * @param department Department where employee works
     * @param roomNumber Room where employee is located
     * @param phoneNumber Employee phone number
     * @return String Message if the employee was added or not.
     */
    public String addEmployee(String firstName,
                            String lastName,
                            String socialSecurityNumber,
                            String department,
                            String roomNumber,
                            String phoneNumber) {

        String message = "Database Error";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectToDB();

            preparedStatement = connection.prepareStatement(SQL_INSERT);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, socialSecurityNumber);
            preparedStatement.setString(4, department);
            preparedStatement.setString(5, roomNumber);
            preparedStatement.setString(6, phoneNumber);

            preparedStatement.execute();

            message = "Employee " + firstName + " " + lastName + " added successfully";

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return message;
    }


    /**
     * The searchEmployee method searches the employee database for either
     * the employee ID, first name or last name. Which is determined by the
     * searct type.
     * @param searchTerm What the employee database is to be searched for.
     * @param searchType How the employee database is to be searched.
     * @return Search The results of the search.
     */
    public Search searchEmployee(String searchTerm, String searchType) {
        Search search = new Search();
        search.setSearchTerm(searchTerm);
        search.setSearchType(searchType);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            switch (searchType) {
                case SEARCH_BY_ID :
                    search = searchByEmployeeID(search, connection,
                                                preparedStatement, resultSet);
                    break;

                case SEARCH_BY_LAST_NAME :
                    search = searchByLastName(search, connection,
                                              preparedStatement, resultSet);
                    break;

                case SEARCH_BY_FIRST_NAME :
                    search = searchByFirstName(search, connection,
                                               preparedStatement, resultSet);
                    break;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            return search;
        }
    }


    /**
     * The searchByEmployeeID method searches the employees database by emp_id.
     * @param search The Search object before the database search.
     * @return Search The Search object after the database search.
     */
    private Search searchByEmployeeID(Search search, Connection connection,
            PreparedStatement preparedStatement, ResultSet resultSet)
            throws SQLException {

        connection = connectToDB();

        preparedStatement =
            connection.prepareStatement(COMMON_SELECT_SQL_SNIPPET + "emp_id = ?");

        preparedStatement.setString(1, search.getSearchTerm());

        search = getData(preparedStatement, resultSet, search);

        return search;
    }


    /**
     * The searchByLastName method searches the employees database by last_name.
     * @param search The Search object before the database search.
     * @return Search The Search object after the database search.
     */
    private Search searchByLastName(Search search, Connection connection,
            PreparedStatement preparedStatement, ResultSet resultSet)
            throws SQLException {

        connection = connectToDB();

        preparedStatement =
            connection.prepareStatement(COMMON_SELECT_SQL_SNIPPET +
            "last_name LIKE ?");

        preparedStatement.setString(1, search.getSearchTerm() + "%");

        search = getData(preparedStatement, resultSet, search);

        return search;
    }


    /**
     * The searchByFirstName method searches the employees database by first_name.
     * @param search The Search object before the database search.
     * @return Search The Search object after the database search.
     */
    private Search searchByFirstName(Search search, Connection connection,
            PreparedStatement preparedStatement, ResultSet resultSet)
            throws SQLException {

        connection = connectToDB();

        preparedStatement =
            connection.prepareStatement(COMMON_SELECT_SQL_SNIPPET +
            "first_name LIKE ?");

        preparedStatement.setString(1, search.getSearchTerm() + "%");

        search = getData(preparedStatement, resultSet, search);

        return search;
    }


    /**
     * The getData method executes the database query and returns the results
     * if any to the caller.
     * @param preparedStatement The PreparedStatement object.
     * @param resultSet The ResultSet object.
     * @param search The Search object.
     */
    private Search getData(PreparedStatement preparedStatement,
                          ResultSet resultSet,
                          Search search) throws SQLException {

        resultSet = preparedStatement.executeQuery();

        search.setEmployeeFound(false);

        while (resultSet.next()) {

            Employee employee = new Employee();

            employee.setEmployeeId(resultSet.getString("emp_id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setSsn(resultSet.getString("ssn"));
            employee.setDepartment(resultSet.getString("dept"));
            employee.setRoom(resultSet.getString("room"));
            employee.setPhone(resultSet.getString("phone"));

            search.addFoundEmployee(employee);

        }

        return search;
    }
}