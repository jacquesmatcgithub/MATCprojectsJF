package java112.analyzer;

import java.io.*;
import java.util.*;
import java.util.Collections;

import java112.utilities.*;

/**
 * The TokenSizeAnalyzer class determines the size distribution of
 * the tokens in the input file. It also generates a histogram
 * of the token size distribution.
 *
 * @author Jacques Fourie
 * class TokenSizeAnalyzer
 */
public class TokenSizeAnalyzer implements Analyzer {

    private static final int HISTOGRAM_SCALE = 76;
    private static final int RULER_LINE_SIZE = 80;

    private Map<Integer, Integer> tokenSizes;
    private Properties properties;
    private int maximumSize;


    /**
     * No-argument default Constructor for the TokenSizeAnalyzer class.
     * It instantiates the tokenSizes TreeMap that will hold the unique
     * tokens and the number of times they occur in the input file.
     */
    public TokenSizeAnalyzer() {
        tokenSizes = new TreeMap<Integer, Integer>();
        maximumSize = 1;
    }


    /**
     * Single-argument constructor for the TokenSizeAnalyzer class.
     * It assigns the properties instance variable to what was passed
     * into the TokenSizeAnalyzer object.
     * @param properties properties used by class
     */
    public TokenSizeAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * This method returns the tokenSizes Map.
     * @return tokenSizes Map of token length and count.
     */
    public Map<Integer, Integer> getTokenSizes() {
        return tokenSizes;
    }



    /**
     * This method returns the maximumSize instance variable.
     * @return maximumSize The instance variable maximumSize.
     */
    public int getMaximumSize() {
        return maximumSize;
    }


    /**
     * The processToken method looks to see if the token length already
     * exists in the set. If it does, the count is incremented by one.
     * If it does not it is added with a count of 1.
     * @param token A single token to be added to the set.
     */
    public void processToken(String token) {
        int tokenLength = token.length();
        int tokenCount = 0;

        if (tokenSizes.containsKey(tokenLength)) {
            tokenCount = tokenSizes.get(tokenLength);
            tokenCount += 1;
            tokenSizes.put(tokenLength, new Integer(tokenCount));
        } else {
            tokenSizes.put(tokenLength, new Integer(1));
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
            properties.getProperty("output.file.token.size");

        try (
            PrintWriter outputTokenFile = new PrintWriter(new BufferedWriter(
                new FileWriter(outputFilePath)));
        )
        {
            writeOutputRecords(outputTokenFile);
            writeOutputHistogram(outputTokenFile);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * The writeOutputRecords method iterates thru the tokenSizes
     * TreeSet to write out each occurance to the output file.
     * @param outputTokenFile The file where the list of tokens are
     * written to.
     */
    public void writeOutputRecords(PrintWriter outputTokenFile) {
        int tokenCount = 0;

        for (Map.Entry<Integer, Integer> entry : tokenSizes.entrySet()) {
            outputTokenFile.print(entry.getKey());
            outputTokenFile.print("\t");
            outputTokenFile.println(entry.getValue());

            tokenCount = entry.getValue();
        }
    }


    /**
     * This method iterates through the tokenSizes Map to write out the
     * lengths of the tokens. It calls the drawHistogram method to
     * draw the histogram line for each of the length entries in the Map.
     * @param outputTokenFile The PrintWriter to where the histogram line
     * is written.
     */
    public void writeOutputHistogram(PrintWriter outputTokenFile) {
        double histogramFactor;

        maximumSize = Collections.max(tokenSizes.values());

//      drawRulerLine(outputTokenFile, RULER_LINE_SIZE);

        histogramFactor = HISTOGRAM_SCALE / (double)getMaximumSize();

        for (Map.Entry<Integer, Integer> entry : tokenSizes.entrySet()) {
            outputTokenFile.print(entry.getKey());
            outputTokenFile.print("\t");

            drawHistogram(outputTokenFile, entry.getValue(), histogramFactor);
        }
    }

    /**
     * This method draws a ruler line indicating every 5th position with a
     * plus symbol, and every 10th position with the value of that position
     * divided by 10. Example: ----+----1----+----2----+----3
     * @param outputTokenFile The PrintWriter to where the histogram line
     * is written.
     * @param scaleSize The size of the scale
     */
    public void drawRulerLine(PrintWriter outputTokenFile, int scaleSize) {
        int scaleIndex = 0;
        String scaleChar;

        outputTokenFile.print("\t");

        while (scaleIndex < scaleSize) {
            scaleChar = "-";

            scaleIndex += 1;

            if (scaleIndex % 5 == 0) {
                scaleChar = "+";
            }
            if (scaleIndex % 10 == 0) {
                scaleChar = Integer.toString(scaleIndex / 10);
            }
            outputTokenFile.print(scaleChar);
        }
        outputTokenFile.println("");
    }


    /**
     * This method draws the histogram for each of the entries in the
     * tokenSizes Map.
     * @param outputTokenFile The PrintWriter to where the histogram line
     * is written.
     * @param count The number of tokens for the length in the tokenSizes Map.
     * @param factor The factor to be used to determine how many asterisks
     * to use for the histogram line.
     */
    public void drawHistogram(PrintWriter outputTokenFile,
            int count, double factor) {

        double asteriskCount = (double)count * factor;

        while (asteriskCount > 0) {
            outputTokenFile.print("*");
            asteriskCount -= 1;
        }

        outputTokenFile.println("");
    }
}