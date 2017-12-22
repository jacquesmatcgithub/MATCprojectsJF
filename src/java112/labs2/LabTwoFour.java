package java112.labs2;

import java.util.*;
import java.io.*;

/**
 * @author Jacques Fourie
 * class LabTwoFour
 */
public class LabTwoFour {


    /**
     * Run the lab
     */
    public void run() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("one", new Integer(1));     // both must be objects
        map.put("three", new Integer(3));
        map.put("two", new Integer(2));
        map.put("seven", new Integer(7));
        map.put("five", new Integer(5));
        map.put("twelve", new Integer(12));
        map.put("Three", new Integer(3));
        map.put("four", new Integer(4));
        map.put("six", new Integer(6));
        map.put("eight", new Integer(8));

        System.out.println("Output from: HashMap : not ordered by the key");
        System.out.println("--------------------");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print("key = " + entry.getKey() + "  ");
            System.out.println("value = " + entry.getValue());
        }

        System.out.println();
        System.out.println(map);
        System.out.println();

        if (map.containsKey("Three")) {
            System.out.println("key value = " + map.get("Three"));
        } else {
            System.out.println("key value Three not found");
        }

        System.out.println();

        Map<String, Integer> treeMap = new TreeMap<String, Integer>(map);
        System.out.println("Output from: TreeMap : ordered by the key");
        System.out.println("--------------------");
        for (Map.Entry<String, Integer> treeEntry : treeMap.entrySet()) {
            System.out.print("key = " + treeEntry.getKey() + "  ");
            System.out.println("value = " + treeEntry.getValue());
        }
        System.out.println();
        System.out.println(treeMap);
        System.out.println();
    }

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        LabTwoFour lab = new LabTwoFour();
        lab.run();
    }

}
