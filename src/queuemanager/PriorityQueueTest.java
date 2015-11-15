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
 * @param <T>

 */
public abstract class PriorityQueueTest<T> {
    /* @param item
      * @param priority
   */
    public PriorityQueue<T> instance;

    public PriorityQueueTest() {
    }
    @Before
    public abstract void setUp() throws Exception;




}
