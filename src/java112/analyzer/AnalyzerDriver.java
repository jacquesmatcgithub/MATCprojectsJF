package java112.analyzer;

/**
 * The AnalyzerDriver class is used to start the SuperTokenPopper
 * application from the command line.
 *
 * @author Jacques Fourie
 * class AnalyzerDriver
 */
public class AnalyzerDriver {

    /**
     * The main method of the AnalyzerDriver class instantiates an
     * object from the AnalyzeFile class. It then executes that
     * object's runAnalysis method which will start the application.
     * @param arguments Array of command line arguments
     */
    public static void main(String[] arguments) {
        AnalyzeFile analyzer = new AnalyzeFile();
        analyzer.runAnalysis(arguments);
    }
}