package java112.utilities;

/**
 * The Counter class starts a counter from 1, increasing it by 1 every time
 * the increment method is called.
 * @author Jacques Fourie
 * class Counter
 */
public class Counter {

    private int counter;
    /**
     * Constructor for Counter
     */
    public Counter() {
        counter = 1;
    }

    /**
     * The getCounter method returns the value of the counter instance
     * variable.
     * @return counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * The increment method increments the counter instance variable by 1.
     */
    public void increment() {
        counter += 1;
    }
}