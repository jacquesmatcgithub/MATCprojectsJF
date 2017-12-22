package java112.employee;

import java.io.*;
import java.util.*;

/**
 * @author Jacques Fourie
 * class Search
 */
public class Search {

    private String searchType;
    private String searchTerm;
    private ArrayList<Employee> results;
    private boolean employeeFound;

    /**
     * Constructor for Search
     */
    public Search() {
        results = new ArrayList<Employee>();
    }

    /**
     * Returns the value of searchType.
     * @return searchType The string that holds the entered search type.
     */
    public String getSearchType() {
        return searchType;
    }


    /**
     * Sets the value of searchType.
     * @param searchType The value to assign searchType.
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }


    /**
     * Returns the value of searchTerm.
     * @return searchTerm The string that holds the search term.
     */
    public String getSearchTerm() {
        return searchTerm;
    }


    /**
     * Sets the value of searchTerm.
     * @param searchTerm The value to assign searchTerm.
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }


    /**
     * Returns the value of results.
     * @return results The results from the database queery.
     */
    public ArrayList<Employee> getResults() {
        return results;
    }


    /**
     * Sets the value of results.
     * @param results The value to assign results.
     */
    public void setResults(ArrayList<Employee> results) {
        this.results = results;
    }


    /**
     * Returns the value of employeesFound.
     * @return employeeFound Indicates whether or not an employee record
     * was found.
     */
    public boolean getEmployeeFound() {
        return employeeFound;
    }


    /**
     * Sets the value of employeesFound.
     * @param employeeFound The value to assign employeeFound.
     */
    public void setEmployeeFound(boolean employeeFound) {
        this.employeeFound = employeeFound;
    }

    /**
     * Adds an employee to the employee javabean.
     * @param employee The Employee javabean.
     */
    public void addFoundEmployee(Employee employee) {
        this.setEmployeeFound(true);

        results.add(employee);
    }


}