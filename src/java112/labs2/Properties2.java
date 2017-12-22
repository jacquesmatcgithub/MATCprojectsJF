package java112.labs2;
import java.util.*;
import java.io.*;

import java112.utilities.*;

/**
 * @author Eric Knapp
 * class Properties2
 */
public class Properties2 implements PropertiesLoaderInterface {

    private Properties properties;

    /**
     * Run the demo
     */
    public void run() {
        properties = loadProperties("/lab2-3.properties");

        String author = properties.getProperty("author");
        System.out.println("author: " + author);

        String email = properties.getProperty("email");
        System.out.println("email: " + email);

        String motorcycle = properties.getProperty("motorcycle");
        System.out.println("motorcycle: " + motorcycle);

        String cat = properties.getProperty("cat");
        System.out.println("cat: " + cat);
}

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        Properties2 demo = new Properties2();
        demo.run();
    }

}
