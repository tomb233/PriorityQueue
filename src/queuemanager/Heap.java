package queuemanager;



/**
 * Created by Tom on 12/11/2015.
 */

public class Heap<T> implements PriorityQueue<T> {
    protected int DEFAULT_CAPACITY = 8;
    protected Object[] array;
    protected int size;

    /**
     * Constructs a new BinaryHeap.
     */

    public Heap(int s) {
        array = new Object[s];
        size = 0;
        DEFAULT_CAPACITY = s;
    }

    @Override
    public boolean isEmpty(){ //Returns true only if the array is empty
        return size == 0;
    }
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return ((Wrapper<T>) array[0]).getItem();
        }
    }

    @Override
    public void remove() throws QueueUnderflowException{ //removes node
        int index2 = size - 1;
        swap(index2,0);
        array[index2] = null;
        size--;
        bubbleDown();

    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException { //adds to heap
        size++;
        System.out.println(size);
        if(size >= DEFAULT_CAPACITY){
            resize();
        }
        int index = size-1;
        array[index] = new Wrapper<>(item, priority);
        bubbleUp();

    }
    protected void swap(int index1, int index2) { //swaps two nodes
        Object tmp = array[index1];
        Object tmp2 = array[index2];
        array[index1] = tmp2;
        array[index2] = tmp;
        System.out.println("Moving " + array[index2] + " to position at " + array[index1]);
    }
    protected void resize(){

        DEFAULT_CAPACITY = DEFAULT_CAPACITY * 2;
        Object[] tempArray = new Object[DEFAULT_CAPACITY];
        System.out.println("Default capacity is now" + DEFAULT_CAPACITY);

        for ( int i = 0; i < array.length; ++i ) {
            tempArray[i] = array[i];
        }
        array = new Object[DEFAULT_CAPACITY];
        array = tempArray;
        System.out.println("Finished Resize");
    }
    public int parent(int i){ //returns parent index
        return i/2;
    }
    public int leftIndex(int i){ //returns index of a particular nodes left child
        return (i * 2)+1;
    }
    public boolean hasLeftChild(int i){ //return true if node has left child
        return leftIndex(i) <= size;
    }
    public boolean hasRightChild(int i){ //return true if node has right child
        return rightIndex(i) <= size;
    }
    public int rightIndex(int i){ //returns index of a particular nodes right child
        return (i * 2) + 2;
    }

    protected void bubbleUp(){ //Sorts out the heap starting from the most recent insert. Mainly used when inserting into the heap
        int index = size-1;
        if(size > 1){

            while(((Wrapper<T>)array[index]).getPriority() > ((Wrapper<T>)array[parent(index)]).getPriority()){
                System.out.println("Now comparing value and its parent");
                System.out.println("Index value is "+((Wrapper<T>)array[index]).getPriority());
                System.out.println("Parent index value is " + ((Wrapper<T>) array[parent(index)]).getPriority());
                swap(index, parent(index));
                System.out.println("Swapping");
                index = parent(index);
            }
        }
    }


    protected void bubbleDown() { //Sorts out heap starting from root. Mainly used when removing the root
        int index = 0;
        while (hasLeftChild(index)) {
            if(((Wrapper<T>)array[leftIndex(index)]) == null || ((Wrapper<T>)array[rightIndex(index)]) == null) { //Error catching code, stops nullpointexceptions when working with array
                break;
            }
            int biggerChild = leftIndex(index); //Defaults largest child to left as we fill the heap left to right
            if (hasRightChild(index) && ((Wrapper<T>)array[leftIndex(index)]).getPriority() < ((Wrapper<T>)array[rightIndex(index)]).getPriority()   ) { //Changes largest child only if right child is larger than left child.
                biggerChild = rightIndex(index);
                System.out.println("right index selected");
            }
            int parent = ((Wrapper<T>)array[index]).getPriority();
            int child = ((Wrapper<T>)array[biggerChild]).getPriority();
            if (parent < child) { // Decides if child is bigger than parent, if so swaps places
                swap(index, biggerChild);
            }
            index = biggerChild;// updates index to the index of the largest child
        }
    }
    @Override
    public String toString() {



        int index = array.length - 1;
        String result = "";
        System.out.print("heapArray: ");    // array format
        for(int m=0; m<=index; m++)
            if(array[m] != null)
                System.out.print( array[m] + " ");
            else
                System.out.print( "-- ");
        System.out.println();
        for(int x = 0;x <=index;x++){
            if(hasLeftChild(x)){
                System.out.println("Index is "+x);
                System.out.print("Parent is ");
                System.out.println(array[x]);
                result += array[x]+ ", ";
                System.out.print("Left Child is ");
                System.out.println(array[leftIndex(x)]);
                if(rightIndex(x) < array.length){
                    System.out.print("Right child is ");
                    System.out.println(array[rightIndex(x)]);
                }


            }

        }
        return result;
    }





}
