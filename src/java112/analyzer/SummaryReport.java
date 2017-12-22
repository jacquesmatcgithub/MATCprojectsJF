package java112.analyzer;

import java.io.*;
import java.util.*;
import java.text.*;

/**
  * The SummaryReport class is used to keep track of the number of
  * tokens on a file, and to produce a summary report containing details
  * about the author and input file.
  * @author Jacques Fourie
  * class SummaryReport
  */
public class SummaryReport implements Analyzer {

    private Properties properties;
    private int totalTokensCount;

    /**
     * No-argument default Constructor for the SummaryReport class.
     */
    public SummaryReport() {
    }

    /**
     * Single-argument constructor for the SummaryReport class.
     * It assigns the properties instance variable to what was passed
     * into the SummaryReport object.
     * @param properties properties used by class
     */
    public SummaryReport(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
      * The getTotalTokensCount method returns the total number of tokens
      * @return totalTokensCount
      */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }


    /**
      * The processToken method keeps a count of the number of tokens.
      * @param token A string containing a single token.
      */
    public void processToken(String token) {
        totalTokensCount += 1;
    }


    /**
      * The writeOutputFile method opens the summary file for output.
      * @param inputFilePath The filepath of the input file
      */
    public void writeOutputFile(String inputFilePath) {
        String outputFilePath = properties.getProperty("output.dir") +
            properties.getProperty("output.file.summary");

        try (
            PrintWriter outputSummaryFile = new PrintWriter (
                new BufferedWriter(new FileWriter(outputFilePath)));
            )
        {

            writeSummaryReport(inputFilePath, outputSummaryFile);

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * The writeSummaryReport method writes the summary report to the
     * output file.
     * @param inputFilePath The file path of the token file that was
     * analyzed.
     * @param outputSummaryFile The output file that will contain the
     * summary report
     */
    public void writeSummaryReport(String inputFilePath,
            PrintWriter outputSummaryFile) {

        outputSummaryFile.print("Application: ");
        outputSummaryFile.println(properties.getProperty("application.name"));

        outputSummaryFile.print("Author: ");
        outputSummaryFile.println(properties.getProperty("author"));

        outputSummaryFile.print("email: ");
        outputSummaryFile.println(properties.getProperty("author.email.address"));

        outputSummaryFile.print("Input file: ");
        outputSummaryFile.println(inputFilePath);

        outputSummaryFile.print("Analyzed on: ");
        outputSummaryFile.println(new Date());

        outputSummaryFile.print("Total token count: ");
        outputSummaryFile.println(getTotalTokensCount());
    }
}