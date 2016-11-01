/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testAssignment4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import  java.util.*;
import java.io.*;
import java.lang.System;
import kiss.API.Close;
import org.junit.Rule;
/**
 *
 * @author deser
 */
public class TestAssignment4 {
    
    public TestAssignment4() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
     void testHashSetPairsUnique(){
        String test_left1 = "rachel";
        String test_right1 = "tim";
        String test_left2 = "sam";
        String test_right2 = "dee";
        
        HashSet<String> pairs = new HashSet<String>();
        try(Close out = outExpect( "[(sam, dee),(rachel, tim)]")){
            pairs.add("(" + test_left1 + ", " + test_right1 + ")");
            pairs.add("(" + test_left2 + ", " + test_right2 + ")");
            System.out.println(pairs);
        }
    }
    @Test
    void testHashSetPairsDuplicate(){
        String test_left1 = "lily";
        String test_right1 = "alex";
        String test_left2 = "drake";
        String test_right2 = "frank";
        
        HashSet<String> pairs = new HashSet<String>();
        try(Close out = outExpect( "[(lily, alex),(drake, frank)]")){
            pairs.add("(" + test_left1 + ", " + test_right1 + ")");
            pairs.add("(" + test_left2 + ", " + test_right2 + ")");
            pairs.add("(" + test_left2 + ", " + test_right2 + ")");
            System.out.println(pairs);
        }
    }
    
    @Test
    void testHashSetRemovePair(){
        String test_left1 = "cleo";
        String test_right1 = "peter";
        String test_left2 = "pat";
        String test_right2 = "fire";
        
        HashSet<String> pairs = new HashSet<String>();
       
            pairs.add("(" + test_left1 + ", " + test_right1 + ")");
            pairs.add("(" + test_left2 + ", " + test_right2 + ")");
            pairs.add("(" + test_left2 + ", " + test_right2 + ")");
            assertTrue(pairs.contains("(cleo, peter)"));
            assertTrue(pairs.contains("(pat, fire)"));
        
        String newPair = "(sherlock, john)";
        pairs.add(newPair);
       
        assertTrue(pairs.contains("(cleo, peter)"));
        assertTrue(pairs.contains("(pat, fire)"));
        assertTrue(pairs.contains("sherlock, john"));
        pairs.remove("(pat, fire)");
        assertTrue(pairs.contains("(cleo, peter)"));
        assertFalse(pairs.contains("(pat, fire)"));
        assertTrue(pairs.contains("sherlock, john"));
    }
    
    @Test    
    void testHashSetContains(){
        String pair1 = "(cleo, peter)";
        String pair2 = "(dee, eve)";
        String pair3 = "(jenkins, phil)";
        String pair4 = "(lily, katie)";
        HashSet<String> pairs = new HashSet<String>();
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
        pairs.add(pair4);
        
        assertTrue(pairs.contains(pair1));
        assertFalse(pairs.contains("(jeremey, david"));
        assertTrue(pairs.contains(pair4) );
        assertTrue(pairs.contains(pair3));
        
        pairs.remove(pair3);
        assertFalse(pairs.contains(pair3));

    }
    
    @Test
    void testTreeSetAddPairs(){
        TreeSet<String> pairs = new TreeSet<String>();
        String pair1 = "(cleo, peter)";
        String pair2 = "(dee, eve)";
        String pair3 = "(jenkins, phil)";
        String pair4 = "(lily, katie)";
        String pairNew = "(ashley, drake)";
        
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
        pairs.add(pair4);
        
        assertTrue(pairs.contains(pair1));
        assertTrue(pairs.contains(pair2));
        assertTrue(pairs.contains(pair3));
        assertTrue(pairs.contains(pair4));
        assertFalse(pairs.contains(pairNew));
        
        pairs.add(pairNew);
        assertTrue(pairs.contains(pair1));
        assertTrue(pairs.contains(pair2));
        assertTrue(pairs.contains(pair3));
        assertTrue(pairs.contains(pair4));
        assertTrue(pairs.contains(pairNew));
        
    }
    @Test
     void testTreeSetRemovePairs(){
        TreeSet<String> pairs = new TreeSet<String>();
        String pair1 = "(cleo, peter)";
        String pair2 = "(dee, eve)";
        String pair3 = "(jenkins, phil)";
        String pair4 = "(lily, katie)";
        String pair5 = "(ashley, drake)";
        
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
        pairs.add(pair4);
       
        assertTrue(pairs.contains(pair1));
        assertTrue(pairs.contains(pair2));
        assertTrue(pairs.contains(pair3));
        assertTrue(pairs.contains(pair4));
        assertFalse(pairs.contains(pair5));
        
        pairs.add(pair5);
        assertTrue(pairs.contains(pair1));
        assertTrue(pairs.contains(pair2));
        assertTrue(pairs.contains(pair3));
        assertTrue(pairs.contains(pair4));
        assertTrue(pairs.contains(pair5));
       
        pairs.remove(pair1);
        pairs.remove(pair3);
        
        assertFalse(pairs.contains(pair1));
        assertTrue(pairs.contains(pair2));
        assertFalse(pairs.contains(pair3));
        assertTrue(pairs.contains(pair4));
        assertTrue(pairs.contains(pair5));
       
       
    }
    
    @Test
     void testTreeSetContains(){
        TreeSet<String> pairs = new TreeSet<String>();
        String pair1 = "(cleo, peter)";
        String pair2 = "(dee, eve)";
        String pair3 = "(jenkins, phil)";
        String pair4 = "(lily, katie)";
        String pair5 = "(ashley, drake)";
        
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
        pairs.add(pair4);
        
        assertFalse (pairs.contains(pair5));
        pairs.add(pair5);
        assertTrue( pairs.contains(pair5));
        
        
           
        assertTrue( pairs.contains(pair2));
        assertTrue(pairs.contains(pair1));
        assertTrue( pairs.contains(pair3));
        assertTrue( pairs.contains(pair4));
         
        pairs.remove(pair1);
        pairs.remove(pair3);
      
        assertFalse( pairs.contains(pair1));
        assertFalse(pairs.contains(pair3));
    }
}
