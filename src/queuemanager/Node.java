package queuemanager;

/**
 * Created by Tom on 09/11/2015.
 * Used for implementing the LinkedLists
 * Each node contains a reference to the next node in the list
 */
public class Node<T> {
    public final T item;
    public final int value;
    public Node next;
    public Node(T item,int value, Node next){
        this.item = item;
        this.value = value;
        this.next = next;
    }
    public void printNode(){
        System.out.println(value + " ");
    }
    public T getItem() {
        return item;
    }
    public int getPriority(){
        return value;
    }

    public Node getNext(){
        Node nextNode = next;
        return nextNode;
    }
}
