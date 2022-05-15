package game.logic;

/**
 * This class defines a new object - Counter , which contains an integer value.
 * @author Erez Gilat
 */
public class Counter {
    private int count = 0;
    /**
     * Adding number to current count.
     * @param number .
     */
    public void increase(final int number) {
        this.count += number;
    }
    /**
     * subtract number from current count.
     * @param number .
     */
    public void decrease(int number) {
        this.count -= number;
    }
    /**
     * @return the count value.
     */
    public int getValue() {
        return this.count;
    }
}