package queuemanager;

/**
 * Created by Tom on 08/11/2015.
 */
public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
    private Node startOfList = null;
    private Node head = null;
    private int length = -1; //length equals number of nodes -1

    @Override
    public boolean isEmpty(){
        return length <= -1;
    }
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else if(length == 0) {  //length is only one so must be head
            return ((Node<T>) startOfList).getItem();
        } else if(length ==1){  //length is two
            if(startOfList.getPriority() > startOfList.next.getPriority()){ // start is larger than start's next
                return ((Node<T>) startOfList).getItem();
            }else{
                return ((Node<T>) startOfList.next).getItem();
            }
        } else { //list is greater than 2 nodes so we require a loop to find head
            Node nodeHead = startOfList;
            for (Node<T> node = startOfList.next; node != null; node = node.next) { //Find head node here
                if(node.getPriority() > nodeHead.getPriority()){
                    nodeHead = node;
                }
            }
            return ((Node<T>) nodeHead).getItem();
        }
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (startOfList == null){ //Checking to see if the list  is empty, if so add the first node
            startOfList = new Node(item,priority, null);
            length++; //Increment the length of the list
        }else{
            Node nodeTemp =  new Node(item,priority,null); //Temp pointer to hold new data
            nodeTemp.next = startOfList; //Set the new node's next pointer to the old head  node
            startOfList = nodeTemp; //Assign the new node to the head
            length++; //Increment the length of the list

        }


    }


    @Override
    public void remove() throws QueueUnderflowException {

            boolean test = true;
            Node nodeTemp = startOfList;
            Node nodeOld = null;
        if(length == 0){ // size of list is only one so just set startOfList to null
            startOfList = null;
            length--; //decrement the length
        }else if(length == 1){ //if list only has two nodes in it
            if(startOfList.getPriority() > startOfList.next.getPriority()){ // start is larger than start's next
                startOfList = startOfList.next; //set start of list equal to the next node in the list
                length--;//decrement the length
            }else{
                startOfList.next = null; // if this is true second node but be larger so just delete
                length--;//decrement the length
            }
        } else{ // if list is larger than 2
            for (Node<T> node = startOfList.next; node != null && test; node = node.next) { //Find head node here
                if(node.getPriority() > nodeTemp.getPriority()){
                    nodeTemp = node;
                }
            }
            test = true;
            for (Node<T> node = startOfList; node != null && test; node = node.next) { //find node that points to head node here
                if(node.returnPrevious(nodeTemp)){
                    nodeOld = node;
                    test = false;
                }
            }
            if(nodeOld != null){
                nodeTemp = nodeTemp.next; //remove head node here
                nodeOld.next = nodeTemp; //reassign pointer on previous node
                length--;
            }else{
                startOfList = nodeTemp.next;
                length--;//decrement the length

            }

        }






    }



    @Override
    public String toString() {
        String result = "";
        for (Node node1 = startOfList; node1 != null; node1 = node1.next) {

            result += node1.getPriority() + ", ";
        }
        return "List: " + result;



    }
}
