package queuemanager;

/**
 * Created by Tom on 09/11/2015.
 * Used for implementing the LinkedLists
 * Each node contains a reference to the next node in the list
 */
public class Node<T> {
    private T item;
    private T value;
    private Node next;
    public Node(T item,T value, Node next){
        this.item = item;
        this.value = value;
        this.next = next;
    }
    public void printNode(){
        System.out.println(value + " ");
    }
}
