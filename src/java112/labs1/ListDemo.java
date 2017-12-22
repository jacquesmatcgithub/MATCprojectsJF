package java112.labs1;
 
import java.util.*;
 
/**
 * @author Eric Knapp
 * class ListDemo
 *
 */
public class ListDemo {
 
    public void run() {
 
        List<String> list = new ArrayList<String>();
 
        list.add("one");
        list.add("two");
 
        System.out.println(list);
        System.out.println();
 
        System.out.println("Iteration the java 1.4 way");
        for (Iterator iterator = list.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
        System.out.println();
 
        System.out.println("Iteration the java 5-8 way");
        for (String element : list){
            System.out.println(element);
        }
 
    }
 
    public static void main(String[] args) {
        ListDemo demo = new ListDemo();
        demo.run();
    }
}
