package queuemanager;

/**
 * Created by Tom on 12/11/2015.
 */
public class Heap<T> implements PriorityQueue<T> {
    private static final int default_max_size = 10;
    protected int size;
    private Object[] heap;

    @SuppressWarnings("unchecked")
    public Heap(int s) {

        heap = new Object[s];
        size = 0;
    }

    @Override
    public boolean isEmpty(){
        return size <= -1;
    }

    @Override
    public T head() throws QueueUnderflowException {
        return null;
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        size++;
        int index = size;
        heap[index] = new Wrapper<>(item, priority);;
    }


    @Override
    public void remove() throws QueueUnderflowException {

    }



    @Override
    public String toString() {
        return null;
    }
}
