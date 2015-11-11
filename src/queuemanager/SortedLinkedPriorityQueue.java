package queuemanager;

/**
 * Created by Tom on 09/11/2015.
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
    private Node head = null;
    private int length = 0;

    @Override
    public boolean isEmpty(){
        return length <= -1;
    }
    @Override
    public T head() throws QueueUnderflowException {
            return null;
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (head == null){ //Checking to see if the list  is empty, if so add the first node
            head = new Node(item,priority, null);


        }else{

            Node nodeTemp =  new Node(item,priority,null); //Temp node
            Node nodeOld = head;
            boolean test = true;
            for (Node<T> node = head; node != null && test; node = node.next) {
                if(node.getPriority() > nodeTemp.getPriority() && node.next == null){ //reached end of list
                    nodeTemp.next = null;
                    node.next = nodeTemp;


                }else if(nodeTemp.getPriority() > head.getPriority()){


                    if(head.next == nodeTemp){
                        head.next = null;
                    }
                    nodeTemp.next = head;
                    head = nodeTemp;
                    test = false;

                }else{
                    if (node.getPriority()  > nodeTemp.getPriority()){
                        nodeOld = node;
                    }else if(node.getPriority() < nodeTemp.getPriority()){

                        nodeOld.next = nodeTemp;
                        System.out.println(nodeOld.value);
                        nodeTemp.next = node;
                        System.out.println(nodeTemp.value);
                        System.out.println(node.value);
                        System.out.println(head.value);
                        test = false;
                    }
                }
            }
        }
}


    @Override
    public void remove() throws QueueUnderflowException {

    }



    @Override
    public String toString() {
        String result = "";
        for (Node node1 = head; node1 != null; node1 = node1.next) {
            System.out.println(node1.value);
            result += node1.getPriority() + ", ";
        }
        return "List: " + result;



    }
}


