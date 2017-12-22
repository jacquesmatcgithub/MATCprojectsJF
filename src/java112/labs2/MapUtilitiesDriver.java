package java112.labs2;
import java.util.*;
import java112.utilities.*;
/**
 * @author Jacques Fourie
 * class MapUtilitiesDriver
 */
public class MapUtilitiesDriver {
    Map<String, Integer> map = new HashMap<String, Integer>();

    /**
     * Constructor for MapUtilitiesDriver
     */
    public MapUtilitiesDriver() {
    }

    /**
     * TODO: comment
     */
    public void run() {
        map.put("one", new Integer(1));
        map.put("three", new Integer(3));
        map.put("two", new Integer(2));
        map.put("seven", new Integer(7));
        map.put("five", new Integer(5));

        System.out.println("Before");
        showMap();

        map = MapUtilities.sortByValue(map);

        System.out.println("\n\nAfter");
        showMap();
    }


    /**
     * TODO: comment
     */
    public void showMap() {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print("key = " + entry.getKey() + "  ");
            System.out.println("value = " + entry.getValue());
        }
    }


    /**
     * TODO: comment
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        MapUtilitiesDriver demo = new MapUtilitiesDriver();
        demo.run();
    }
}