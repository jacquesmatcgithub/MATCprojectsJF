package java112.labs1;
import java.io.*;

/**
 * @author Jacques fourie
 * class LabSix
 */

public class LabSix extends Exception {

    //    private static final int VALID_ARGUMENT_COUNT = 2;

    /**
     * TODO: comment
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        if (!(arguments.length == 2)) {
            System.out.println("Please enter two arguments on the command " +
                    "line, an input file name and an output file name");
            return;
        }

        LabSix labSix = new LabSix();
        labSix.run(arguments[0], arguments[1]);
    }

    
    public void run(String inputFilePath, String outputFilePath) {

        BufferedReader inputReader = null;
        PrintWriter outputWriter = null;
        
        try {
            inputReader = new BufferedReader(new FileReader(inputFilePath));
            outputWriter = new PrintWriter(new FileWriter(outputFilePath));

            String line = null;

            while (inputReader.ready()) {
                line = inputReader.readLine();
                outputWriter.println(line);
            }
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
                if (outputWriter != null) {
                    outputWriter.close();
                }
            try {
                if (inputReader != null) {
                    inputReader.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }  
    }



/*

    public void run(String inputFilePath, String outputFilePath) {
        try (BufferedReader inputReader = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter outputWriter = new PrintWriter (new BufferedWriter(new FileWriter(outputFilePath)))) {
            String line = null;

            while (inputReader.ready()) {
                line = inputReader.readLine();
                outputWriter.println(line);
            }
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
        ioException.printStackTrace();
        } catch (Exception exception) {
        exception.printStackTrace();
        }
    }
    
    */
}