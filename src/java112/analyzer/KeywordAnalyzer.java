package java112.analyzer;

import java.io.*;
import java.util.*;

import java112.utilities.*;

/**
 * The KeywordAnalyzer class determines where keywords are in the input file.
 * It also outputs the keywords and their locations in a formatted manner.
 *
 * @author Jacques Fourie
 * class KeywordAnalyzer
 */
public class KeywordAnalyzer implements Analyzer {

    private static final int MAX_WIDTH = 80;

    private Map<String, List<Integer>> keywordMap;
    private Properties properties;
    private int tokenOccurrence;

    /**
     * No-argument default Constructor for the KeywordAnalyzer class.
     * It instantiates the tokenSizes TreeMap that will hold the unique
     * tokens and the number of times they occur in the input file.
     */
    public KeywordAnalyzer() {
        keywordMap = new TreeMap<String, List<Integer>>();
    }


    /**
     * Single-argument constructor for the KeywordAnalyzer class.
     * It assigns the properties instance variable to what was passed
     * into the KeywordAnalyzer object.
     * @param properties properties used by class
     */
    public KeywordAnalyzer(Properties properties) {
        this();
        this.properties = properties;

        processKeywordFile();
    }


    /**
     * The processToken method adds the keyword and its position
     * in the input file to the Map.
     * @param token A single token to be added to the set.
     */
    public void processToken(String token) {
        tokenOccurrence += 1;
        if (keywordMap.containsKey(token)) {
            keywordMap.get(token).add(new Integer(tokenOccurrence));
        }
    }


    /**
     * The writeOutput method writes out the set of keywords to a file.
     * @param inputFilePath The inputFilePath is not used by this
     * method.
     */
    public void writeOutputFile(String inputFilePath) {
        String outputFilePath = properties.getProperty("output.dir") +
            properties.getProperty("output.file.keyword");

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
     * The processKeywordFile method reads in the file of keywords this
     * analyzer uses to determine their location in the main input
     * file.
     */
    public void processKeywordFile() {
        String keywordFilePath = properties.getProperty("file.path.keywords");

        try (
            BufferedReader keywordFile = new BufferedReader(
                new FileReader(keywordFilePath));
        ) {
            readKeywordFile(keywordFile);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException inoutOutputException) {
            inoutOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * The readInputFile method reads the input file and calls a
     * method to parse the input record.
     * @param keywordFile File path to the file being read.
     * @throws IOException Signals that an I/O exception of some sort
     * has occurred.
     */
    public void readKeywordFile(BufferedReader keywordFile) throws IOException {
        String keyword;

        while (keywordFile.ready()) {
            keyword = keywordFile.readLine().trim();
            if (!keyword.isEmpty()) {
                keywordMap.put(keyword, new ArrayList<Integer>());
            }
        }
    }


    /**
     * This method returns the keywordMap Map.
     * @return tokenSizes Map of token length and count.
     */
    public Map<String, List<Integer>> getKeywordMap() {
        return keywordMap;
    }


    /**
     * The writeOutputRecords method iterates thru the tokenSizes
     * TreeSet to write out each occurance to the output file.
     * @param outputTokenFile The file where the list of tokens are
     * written to.
     */
    public void writeOutputRecords(PrintWriter outputTokenFile) {

        Map<String, List<Integer>> keywords = new TreeMap<String, List<Integer>>();

        keywords = getKeywordMap();

        for (Map.Entry<String, List<Integer>> entry : keywords.entrySet()) {
            outputTokenFile.print(entry.getKey());

            outputTokenFile.println(" =");

            writeKeywordPositions(outputTokenFile, entry.getValue());

            outputTokenFile.println();
        }
    }


    /**
     * The writeKeywordPositions method formats and writes out the
     * keyword locations to an output file.
     * @param outputTokenFile Output file containing the formatted
     * keyword locations.
     * @param keywordPosition A list of keyword locations.
     */
    public void writeKeywordPositions(PrintWriter outputTokenFile,
            List<Integer> keywordPosition) {

        String fullLine = "[";
        String positionSnippet;
        int positionCount = keywordPosition.size();

        if (positionCount == 0) {
            outputTokenFile.println("[]");
            return;
        }

        for (Integer position : keywordPosition) {
            positionSnippet = Integer.toString(position);

            positionCount -= 1;

            if (positionCount > 0) {
                positionSnippet = positionSnippet + ", ";
            } else {
                positionSnippet = positionSnippet + "]";
            }

            if ((fullLine.length() + positionSnippet.length() - 1) > MAX_WIDTH) {
                outputTokenFile.println(fullLine.trim());
                fullLine = "";
            }

            fullLine = fullLine + positionSnippet;
        }

        if (fullLine.length() > 0) {
            outputTokenFile.println(fullLine);
        }

    }
}