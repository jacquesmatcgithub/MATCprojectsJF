package java112.labs1;

/**
 * @author YOUR NAME HERE
 * class LabThree
 */
public class LabThree {

    private static final int VALID_ARGUMENT_COUNT = 1;

    public void run(String input) {
        System.out.println("input: " + input);
    }
    
    /**
     * TODO: comment
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        if (!(arguments.length == VALID_ARGUMENT_COUNT)) {
            System.out.println("Please enter one argument on the command line");
            return;
        }

        LabThree labThree = new LabThree();
        labThree.run(arguments[0]);
        
    }

}