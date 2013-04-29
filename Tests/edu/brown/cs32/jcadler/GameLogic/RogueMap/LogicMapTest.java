/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.brown.cs32.jcadler.GameLogic.RogueMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.geom.Point2D;

/**
 *
 * @author john
 */
public class LogicMapTest {
    
    public LogicMapTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRandomMap method, of class LogicMap.
     */
    @Test
    public void testGetRandomMap() throws Exception 
    {
        LogicMap.getRandomMap();
    }

    /**
     * Test of isValid method, of class LogicMap.
     */
    @Test
    public void testIsValid() throws Exception
    {
        LogicMap map = LogicMap.getRandomMap();
        map.isValid(new Point2D.Double(10,10));
    }

    /**
     * Test of getRooms method, of class LogicMap.
     */
    @Test
    public void testGetRooms() {
    }

    /**
     * Test of getData method, of class LogicMap.
     */
    @Test
    public void testGetData() {
    }
}
