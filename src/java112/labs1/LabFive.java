package java112.labs1;
import java.io.*;

/**
 * @author Jacques fourie
 * class LabFive
 */
public class LabFive extends Exception {

//    private static final int VALID_ARGUMENT_COUNT = 2;

    public static void main(String[] arguments) {
        if (!(arguments.length == 2)) {
            System.out.println("Please enter two arguments on the command line, a file name and a message");
            return;
        }

        LabFive labFive = new LabFive();
        labFive.run(arguments[0], arguments[1]);
    }
    
    public void run(String inputFilePath, String message) {
        try (PrintWriter output = new PrintWriter (new BufferedWriter(new FileWriter(inputFilePath)))) {
            output.println(message);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}