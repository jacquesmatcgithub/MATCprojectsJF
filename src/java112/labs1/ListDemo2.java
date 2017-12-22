package java112.labs1;
import java.util.*;
/**
 * @author Jacques Fourie
 * class ListDemo2
 */
public class ListDemo2 {
    
    
    /**
     * Run the lab
     */
    public void run() {
        List<String> list = new ArrayList();
        
        list.add("one");
        list.add("three");
        list.add("six");
        list.add("five");
        
        System.out.println();
        System.out.println(list);
    }
    
    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        ListDemo2 demo = new ListDemo2();
        demo.run();
    }
    
}
