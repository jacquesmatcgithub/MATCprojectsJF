package java112.analyzer;

import java.io.*;
import java.util.*;

import java112.utilities.*;

/**
 * The TokenCountAnalyzer class receives a single token from the
 * AnalyzeFile class. It then builds a TreeSet of all the tokens
 * passed to it in order to then eventually write out the TreeSet
 * to an output file.
 *
 * @author Jacques Fourie
 * class UniqueTokenAnalyzer
 */
public class TokenCountAnalyzer implements Analyzer {

    private Properties properties;
    private Map<String, Counter> tokenCounts;


    /**
     * No-argument default Constructor for the TokenCountAnalyzer class.
     * It instantiates the tokenCounts TreeMap that will hold the unique
     * tokens and the number of times they occur in the input file.
     */
    public TokenCountAnalyzer() {
        tokenCounts = new TreeMap<String, Counter>();
    }


    /**
     * Single-argument constructor for the TokenCountAnalyzer class.
     * It assigns the properties instance variable to what was passed
     * into the UniqueTokenAnalyzer object.
     * @param properties properties used by class
     */
    public TokenCountAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * The getUniqueTokensList method returns the set of unique
     * tokens to the caller.
     * @return Set The set of unique tokens.
     */
    public Map getTokenCounts() {
        return tokenCounts;
    }


    /**
     * The processToken method looks to see if the token already exists in
     * the set. If it does, the count is incremented by one. If it does not
     * it is added with a count of 1.
     * @param token A single token to be added to the set.
     */
    public void processToken(String token) {
        if (tokenCounts.containsKey(token)) {
            tokenCounts.get(token).increment();
        } else {
            tokenCounts.put(token, new Counter());
        }
    }


    /**
     * The writeOutput method writes out the set of unique tokens
     * to a file.
     * @param inputFilePath The inputFilePath is not used by this
     * method.
     */
    public void writeOutputFile(String inputFilePath) {
        String outputFilePath = properties.getProperty("output.dir") +
            properties.getProperty("output.file.token.count");

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
     * The writeOutputRecords method iterates thru the tokenCounts
     * TreeSet to write out each occurance to the output file.
     * @param outputTokenFile The file where the list of tokens are
     * written to.
     */
    public void writeOutputRecords(PrintWriter outputTokenFile) {
        for (Map.Entry<String, Counter> entry : tokenCounts.entrySet()) {
            outputTokenFile.print(entry.getKey());
            outputTokenFile.print("\t");
            outputTokenFile.println(entry.getValue().getCounter());
        }
    }
}