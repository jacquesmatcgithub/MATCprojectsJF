package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * The UniqueTokenAnalyzer class is used to build a TreeSet of tokens and
 * to output that TreeSet to a PrintWriter.
 * @author Jacques Fourie
 * class UniqueTokenAnalyzer
 */
public class UniqueTokenAnalyzer implements Analyzer {

    private Properties properties;
    private Set<String> uniqueTokensList;


    /**
     * No-argument default Constructor for the UniqueTokenAnalyzer class.
     * It instantiates the uniqueTokenList TreeSet object that holds the
     * list of unique tokens.
     */
    public UniqueTokenAnalyzer() {
        uniqueTokensList = new TreeSet<String>();
    }


    /**
     * Single-argument constructor for the UniqueTokenAnalyzer class.
     * It assigns the properties instance variable to what was passed
     * into the UniqueTokenAnalyzer object.
     * @param properties properties object that holds the various property
     * key and value pairs used by the Analyzer application.
     */
    public UniqueTokenAnalyzer(Properties properties) {
        this();
        this.properties = properties;

    }


    /**
     * The getUniqueTokensList method returns the set of unique
     * tokens to the caller.
     * @return Set The uniqueTokensList TreeSet containing the unique tokens.
     */
    public Set getUniqueTokensList() {
        return uniqueTokensList;
    }


    /**
     * The processToken method adds one token to the uniqueTokensList TreeSet.
     * @param token A single token to be added to the TreeSet.
     */
    public void processToken(String token) {
        uniqueTokensList.add(token);
    }


    /**
     * The writeOutput method writes the TreeSet of unique tokens
     * to a PrintWriter object.
     * @param inputFilePath The inputFilePath is not used by this
     * method.
     */
    public void writeOutputFile(String inputFilePath) {
        String outputFilePath = properties.getProperty("output.dir") +
            properties.getProperty("output.file.unique");

        try (
            PrintWriter outputTokenFile = new PrintWriter(new BufferedWriter(
                new FileWriter(outputFilePath)));
        )
        {
            writeOutputRecords(outputTokenFile);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * The writeOutputRecords method iterates thru the uniqueTokenList
     * TreeSet to write out each occurance to the output file.
     * @param outputTokenFile The PrintWriter where the TreeSet of tokens are
     * written to.
     */
    public void writeOutputRecords(PrintWriter outputTokenFile) {
        for (String singleToken : uniqueTokensList) {
            outputTokenFile.println(singleToken);
        }
    }
}