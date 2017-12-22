package java112.labs1;
import java.io.*;
import java.util.*;

/**
 * @author Jacques Fourie
 * class LabSeven
 */
public class LabSeven {

    private static final int VALID_ARGUMENT_COUNT = 1;
    
    public void writeListToOutputFile(String outputFileName, ArrayList<String> tokenList) {
        PrintWriter printWriter = null;
        
        try {
            printWriter = new PrintWriter(new FileWriter(outputFileName));

            for (String token : tokenList) {
                printWriter.println(token);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } 
        finally {
            try {
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }  
    }

    
    public void run(String outputFileName) {
        ArrayList<String> tokenList = new ArrayList<String>();
        
        tokenList.add("one");
        tokenList.add("two");
        tokenList.add("three");
        tokenList.add("four");
        tokenList.add("five");
        tokenList.add("six");
        tokenList.add("seven");
        tokenList.add("eight");
        tokenList.add("nine");
        tokenList.add("ten");

        writeListToOutputFile(outputFileName, tokenList);
    }
    
    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        if (!(arguments.length == VALID_ARGUMENT_COUNT)) {
            System.out.println("Please enter one argument on the command line, an output file name");
            return;
        }

        LabSeven lab = new LabSeven();
        lab.run(arguments[0]);
    }
    
}
