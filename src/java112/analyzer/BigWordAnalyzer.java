package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * The BigWordAnalyzer class receives a single token from the
 * AnalyzeFile class. It then builds a TreeSet of all the tokens
 * passed to it that is longer than the minimum length spefified
 * in the analyzer.parameters file in order to then eventually
 * write out the TreeSet to an output file.
 *
 * @author Jacques Fourie
 * class BigWordAnalyzer
 */
public class BigWordAnalyzer implements Analyzer {

    private Properties properties;
    private Set<String> bigWords;
    private int minimumWordLength;


    /**
     * No-argument default Constructor for the BigWordAnalyzer class.
     * It instantiates the bigWord TreeSet that will hold the list of
     * words that passes the minimum length check.
     */
    public BigWordAnalyzer() {
        bigWords = new TreeSet<String>();
    }

    /**
     * Single-argument constructor for the BigWordAnalyzer class.
     * It assigns the properties instance variable to what was passed
     * into the BigWordAnalyzer object. It also sets up the minimum
     * length a word can be to be added to the bigWord set.
     * @param properties properties used by class
     */
    public BigWordAnalyzer(Properties properties) {
        this();
        this.properties = properties;

        minimumWordLength = Integer.parseInt(properties.getProperty(
            "bigwords.minimum.length"));
    }


    /**
     * The processToken method adds one token to the set if it's longer
     * than the minimum specified in the analyzer.properties file.
     * @param token A single token to be added to the set.
     */
    public void processToken(String token) {
        if (token.length() >= minimumWordLength) {
            bigWords.add(token);
        }
    }


    /**
     * The writeOutputFile method writes out the set of unique big tokens
     * to a PrintWriter.
     * @param inputFilePath The inputFilePath is not used by this method.
     */
    public void writeOutputFile(String inputFilePath) {
        String outputFilePath = properties.getProperty("output.dir") +
            properties.getProperty("output.file.bigwords");

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
     * The writeOutputRecords method iterates thru the bigWords
     * TreeSet to write out each occurance to the output file.
     * @param outputTokenFile The file where the list of tokens are
     * written to.
     */
    public void writeOutputRecords(PrintWriter outputTokenFile) {
        for (String singleToken : bigWords) {
            outputTokenFile.println(singleToken);
        }
    }


    /**
     * The getBigWords method returns the set of unique big tokens to
     * the caller.
     * @return Set The set of big tokens.
     */
    public Set getBigWords() {
        return bigWords;
    }
}

