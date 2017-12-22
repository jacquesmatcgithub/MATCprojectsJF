package java112.labs2;

import java.util.*;
import java.io.*;

/**
 * @author Eric Knapp
 * class MapDemo2
 */
public class MapDemo2 {


    /**
     * Run the lab
     */
    public void run() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("one", new Integer(1));
        map.put("three", new Integer(3));
        map.put("two", new Integer(2));
        map.put("seven", new Integer(7));
        map.put("five", new Integer(5));

        Integer six = 6;    // AutoBoxing - compiler does the new Integer(6)
        Integer seven = 7;  // AutoBoxing

        int total = six + seven;   // AutoUnboxing
        Integer total2 = six + seven;  // AutoUnboxing

        System.out.println("total:" + total);
        System.out.println("total:" + total2);

        System.out.println();
        System.out.println(map);
    }

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        MapDemo2 lab = new MapDemo2();
        lab.run();
    }

}
