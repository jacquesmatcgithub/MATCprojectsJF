package java112.project3;

import java.util.*;


/**
 * @author Jacques Fourie
 * class HttpRequestData
 */
public class HttpRequestData {

    private String remoteComputer;
    private String remoteComputerAddress;
    private String httpMethod;
    private String requestURI;
    private StringBuffer requestURL;
    private String requestProtocol;
    private String serverName;
    private int serverPortNumber;
    private Locale currentLocale;
    private String queryString;
    private String queryParameterValue;
    private String requestHeaderUserAgent;


    /**
     * Constructor for HttpRequestData
     */
    public HttpRequestData() {

    }


    /**
     * Returns the value of remoteComputer.
     * @return remoteComputer
     */
    public String getRemoteComputer() {
        return remoteComputer;
    }


    /**
     * Sets the value of remoteComputer.
     * @param remoteComputer The value to assign remoteComputer.
     */
    public void setRemoteComputer(String remoteComputer) {
        this.remoteComputer = remoteComputer;
    }


    /**
     * Returns the value of remoteComputerAddress.
     * @return remoteComputerAddress
     */
    public String getRemoteComputerAddress() {
        return remoteComputerAddress;
    }


    /**
     * Sets the value of remoteComputerAddress.
     * @param remoteComputerAddress The value to assign remoteComputerAddress.
     */
    public void setRemoteComputerAddress(String remoteComputerAddress) {
        this.remoteComputerAddress = remoteComputerAddress;
    }


    /**
     * Returns the value of httpMethod.
     * @return httpMethod
     */
    public String getHttpMethod() {
        return httpMethod;
    }


    /**
     * Sets the value of httpMethod.
     * @param httpMethod The value to assign httpMethod.
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }


    /**
     * Returns the value of requestURI.
     * @return requestURI
     */
    public String getRequestURI() {
        return requestURI;
    }


    /**
     * Sets the value of requestURI.
     * @param requestURI The value to assign requestURI.
     */
    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }


    /**
     * Returns the value of requestURL.
     * @return requestURL
     */
    public StringBuffer getRequestURL() {
        return requestURL;
    }


    /**
     * Sets the value of requestURL.
     * @param requestURL The value to assign requestURL.
     */
    public void setRequestURL(StringBuffer requestURL) {
        this.requestURL = requestURL;
    }


    /**
     * Returns the value of reuestProtocol.
     * @return reuestProtocol
     */
    public String getRequestProtocol() {
        return requestProtocol;
    }


    /**
     * Sets the value of requestProtocol.
     * @param requestProtocol The value to assign requestProtocol.
     */
    public void setRequestProtocol(String requestProtocol) {
        this.requestProtocol = requestProtocol;
    }


    /**
     * Returns the value of serverName.
     * @return serverName
     */
    public String getServerName() {
        return serverName;
    }


    /**
     * Sets the value of serverName.
     * @param serverName The value to assign serverName.
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }


    /**
     * Returns the value of serverPortNumber.
     * @return serverPortNumber
     */
    public int getServerPortNumber() {
        return serverPortNumber;
    }


    /**
     * Sets the value of serverPortNumber.
     * @param serverPortNumber The value to assign serverPortNumber.
     */
    public void setServerPortNumber(int serverPortNumber) {
        this.serverPortNumber = serverPortNumber;
    }


    /**
     * Returns the value of currentLocale.
     * @return currentLocale
     */
    public Locale getCurrentLocale() {
        return currentLocale;
    }


    /**
     * Sets the value of currentLocale.
     * @param currentLocale The value to assign currentLocale.
     */
    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }


    /**
     * Returns the value of queryString.
     * @return queryString
     */
    public String getQueryString() {
        return queryString;
    }


    /**
     * Sets the value of queryString.
     * @param queryString The value to assign queryString.
     */
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }


    /**
     * Returns the value of queryParameterValue.
     * @return queryParameterValue
     */
    public String getQueryParameterValue() {
        return queryParameterValue;
    }


    /**
     * Sets the value of queryParameterValue.
     * @param queryParameterValue The value to assign queryParameterValue.
     */
    public void setQueryParameterValue(String queryParameterValue) {
        this.queryParameterValue = queryParameterValue;
    }


    /**
     * Returns the value of requestHeaderUserAgent.
     * @return requestHeaderUserAgent
     */
    public String getRequestHeaderUserAgent() {
        return requestHeaderUserAgent;
    }


    /**
     * Sets the value of requestHeaderUserAgent.
     * @param requestHeaderUserAgent The value to assign requestHeaderUserAgent.
     */
    public void setRequestHeaderUserAgent(String requestHeaderUserAgent) {
        this.requestHeaderUserAgent = requestHeaderUserAgent;
}






}