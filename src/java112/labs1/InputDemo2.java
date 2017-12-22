package java112.labs1;
import java.io.*;

/**
 * @author Jacques Fourie
 * class InputDemo2
 */
public class InputDemo2 {
    private static final int VALID_ARGUMENT_COUNT = 1;

    public void run(String input) {
        BufferedReader inputReader = null;
        
        try {
            inputReader = new BufferedReader(new FileReader(input));

            String line = null;

            while (inputReader.ready()) {
                line = inputReader.readLine();

                System.out.println(line);
            }
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } 
        finally {
            try {
                if (inputReader != null) {
                    inputReader.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }  
    }
 
    
    public static void main(String[] arguments) {
        if (!(arguments.length == VALID_ARGUMENT_COUNT)) {
            System.out.println("Please enter one argument on the command line");
            return;
        }

        InputDemo2 inputDemo2 = new InputDemo2();
        inputDemo2.run(arguments[0]);
        

    }
}
