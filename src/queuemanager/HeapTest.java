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
public class HeapTest extends PriorityQueueTest{

    public HeapTest() {
    }


    @Before
    @Override
    public void setUp() throws Exception {
        instance = new Heap<>(8);



    }

    public void addData() throws Exception{
        System.out.println("Adding Prerequisite Data");
        Object item = new Person("Tom");
        int priority = 5;
        instance.add(item,priority);

        item = new Person ("Bill");
        priority = 2;
        instance.add(item,priority);

        item = new Person ("Sarah");
        priority = 7;
        instance.add(item,priority);

        item = new Person ("John");
        priority = 1;
        instance.add(item,priority);

        item = new Person ("Ben");
        priority = 3;
        instance.add(item,priority);

        System.out.println(instance.toString()); //Print out each time we add so we know that the array is being sorted properly

    }
    @Test
    public void testAdd() throws Exception {
        System.out.println("Testing Add Method of HeapPriorityQueue");
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
        System.out.println("Testing Head method of HeapPriorityQueue");
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
        System.out.println("Testing toString method of HeapPriorityQueue");
        addData();
        String expResult = "(Sarah, 7), (Tom, 5), (Ben, 3), ";
        String result = instance.toString();
        System.out.println("Expected: "+expResult);
        System.out.println("Found: "+result);
        assertEquals(expResult, result);
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();

    }
    @Test
    public void testRemove() throws Exception{
        System.out.println("Testing Remove method of HeapPriorityQueue");
        System.out.println();

        System.out.println();
        addData();

        System.out.println("Removing two entries");
        instance.remove();
        instance.remove();
        String expResult = "(Ben, 3), (Bill, 2), ";
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
    public void testParent() throws Exception{
        System.out.println("Testing internal code of heap.");
        System.out.println("Test 1: hasParent()");
        addData();
        System.out.println();

    }

    @Test
    public void testResize() throws Exception{
        System.out.println("----------------------------------------------------------------");
        System.out.println("Testing resize");
        addData();
        Object item = new Person("Tomm");
        int priority = 15;
        instance.add(item,priority);
        System.out.println(instance.toString());
        item = new Person ("Benny");
        priority = 11;
        instance.add(item, priority);
        item = new Person ("Pam");
        priority = 13;
        instance.add(item,priority);
        item = new Person ("Angela");
        priority = 9;
        instance.add(item,priority);
        System.out.println(instance.toString());
    }
    @Test
    public void testCapacity() throws Exception{ //Tests capacity of 5000, if this works then we know that the hole class works fine when it comes to add,resizing.
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
