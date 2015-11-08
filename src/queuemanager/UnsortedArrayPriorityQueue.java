package queuemanager;

/**
 * Created by Tom on 08/11/2015.
 */

/**
 * Implementation of the PriorityQueue ADT using an unsorted array for storage.
 *
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {
    private final Object[] storage;

    /**
     * The size of the storage array.
     */
    private final int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;

    /**
     * Create a new empty queue of the given size.
     *
     * @param size
     */
    public UnsortedArrayPriorityQueue(int size) {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }


    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (tailIndex == capacity - 1) {
            /* No resizing implemented, but that would be a good enhancement.S */
            throw new QueueOverflowException();
        } else {
            tailIndex = tailIndex + 1;
            storage[tailIndex] = new Wrapper<>(item, priority);
        }
    }
    @Override
    public T head() throws QueueUnderflowException{
        int i = tailIndex;

        Wrapper<T> max = ((Wrapper<T>) storage[0]);
        while(i >= 0){

            if (((Wrapper<T>) storage[i]).getPriority() > max.getPriority()) {
                max = ((Wrapper<T>) storage[i]);

            }
            i--;
        }


        return max.getItem();
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            /* No resizing implemented, but that would be a good enhancement.S */
            throw new QueueUnderflowException();
        } else {

            int place = 0;
            int i = tailIndex;
            Wrapper<T> max = ((Wrapper<T>) storage[place]);
            while(i > -1){

                if (((Wrapper<T>) storage[i]).getPriority() > max.getPriority()) {
                    max = ((Wrapper<T>) storage[i]);
                    place = i;
                }
                i--;
            }

            System.out.println("Max is: "+ max.getItem());
            storage[place] = null;

            for (int x = place; x <= tailIndex; x ++){
                storage[x] = storage[x+1];
            }
            tailIndex = tailIndex -1 ;
        }
    }


    @Override
    public boolean isEmpty()
    {
        return tailIndex <= -1;
    }



    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
}

