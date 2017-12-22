package java112.labs2;
import java.util.*;
import java.io.*;

import java112.utilities.*;

/**
 * @author Jacques Fourie
 * class LabThree
 */
public class LabThree implements PropertiesLoaderInterface {

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

        String pet = properties.getProperty("pet");
        System.out.println("pet: " + pet);

        String petName = properties.getProperty("petname");
        System.out.println("pet name: " + petName);

        System.out.println();
        System.out.print(properties.getProperty("author"));
        System.out.println(" can be reached at " + properties.getProperty("email"));
        System.out.print("He rides a " + properties.getProperty("motorcycle"));
        System.out.print(" and his " + properties.getProperty("pet"));
        System.out.print(" is called " + properties.getProperty("petname"));
        System.out.println();
    }

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        LabThree demo = new LabThree();
        demo.run();
    }

}
