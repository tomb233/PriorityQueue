/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tom
 */
public class SortedLinkedPriorityQueueTest<T> extends PriorityQueueTest {

    public SortedLinkedPriorityQueueTest() {
    }

    @Before
    @Override
    public void setUp() throws Exception {
        instance = new SortedLinkedPriorityQueue<>();



    }

    public void addData() throws Exception{
        System.out.println("Adding Prerequisite Data");
        Object item = new Person("Tom");
        int priority = 5;
        instance.add(item,priority);
        System.out.println(instance.toString()); //Print out each time we add so we know that the array is being sorted properly
        item = new Person ("Bill");
        priority = 2;
        instance.add(item,priority);
        System.out.println(instance.toString());
        item = new Person ("Sarah");
        priority = 7;
        instance.add(item,priority);
        System.out.println(instance.toString());
        item = new Person ("John");
        priority = 1;
        instance.add(item,priority);
        System.out.println(instance.toString());
        item = new Person ("Ben");
        priority = 3;
        instance.add(item,priority);
        System.out.println(instance.toString());
        item = new Person ("Charlie");
        priority = 2;
        instance.add(item,priority);

    }
    @Test
    public void testAdd() throws Exception {
        System.out.println("Testing Add Method of UnsortedPriorityQueue");
        addData(); //Adding some test data


        Object item = new Person("Thomas"); //Creates test object that holds test input
        int priority = 8; //holds test priority that's added to instance
        System.out.println("Commencing Test Add of Thomas, 8");
        instance.add(item, priority); //actually test add here
        System.out.println(instance.toString());
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();
    }
    @Test
    public void testHead() throws Exception {
        System.out.println("Testing Head method of UnsortedPriorityQueue");
        addData(); //Adding some test data

        int priority = 12;
        Object item = new Person ("Bill");
        instance.add(item, priority);
        Object expResult = new Person("Bill") ;
        expResult = expResult.toString();
        Object result = instance.head().toString();

        System.out.println("Head is " + result.toString());

        assertEquals(result, expResult);
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();
    }

    @Test
    public void testToString() throws Exception {
        System.out.println("Testing toString method of UnsortedPriorityQueue");
        addData();
        String expResult = "List: Sarah, 7 | Tom, 5 | Ben, 3 | Charlie, 2 | John, 1 | ";
        String result = instance.toString();
        System.out.println("Found: "+result);
        assertEquals(expResult, result);
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();

    }
    @Test
    public void testRemove() throws Exception{
        System.out.println("Testing Remove method of UnsortedPriorityQueue");
        System.out.println();

        System.out.println();
        addData();

        System.out.println("Removing two entries");
        instance.remove();
        instance.remove();
        String expResult = "List: Ben, 3 | Charlie, 2 | John, 1 | ";
        String result = instance.toString();
        System.out.println("Expected: "+expResult);
        System.out.println("Found: "+result);
        assertEquals(expResult, result);
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();

    }
    @Test
    public void isEmptyTest() throws Exception{


        boolean expResult = true;
        boolean result =  instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testCapacity() throws Exception{ //Tests capacity of 5000
        System.out.println("Testing capacity of queue");
        Object item = new Person("Tom");
        int priority = 0;
        instance.add(item,priority);
        for(int x=0;x<5000;x++){
            priority = x;
            instance.add(item,priority);
        }

        System.out.println(instance.toString());
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();
    }


}
