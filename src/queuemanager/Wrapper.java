package queuemanager;

/**
 * A wrapper for bundling up an item and its integer priority.
 * 
 * @param <T>
 */
public class Wrapper<T> {

    private final T item;
    private final int priority;

    public Wrapper(T item, int priority) {
        this.item = item;
        this.priority = priority;
    }

    public T getItem() {
        return item;
    }


    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "(" + getItem() + ", " + getPriority() + ")";
    }
}
