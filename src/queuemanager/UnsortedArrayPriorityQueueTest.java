package queuemanager;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tom on 09/11/2015.
 */
public class UnsortedArrayPriorityQueueTest extends TestCase {
    UnsortedArrayPriorityQueue  tester = new UnsortedArrayPriorityQueue<>(8);
    @Test
    public void testAdd() throws Exception {
        tester.add("Tom",1);
        tester.add("John",2);
        tester.add("Bethan",4);
        tester.add("Bill",3);
    }

    @Test
    public void testHead() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testToString() throws Exception {
        tester.toString();
    }
}