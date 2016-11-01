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
        try(Close out = outExpect( "[(cleo, peter),(pat, fire)]")){
            pairs.add("(" + test_left1 + ", " + test_right1 + ")");
            pairs.add("(" + test_left2 + ", " + test_right2 + ")");
            pairs.add("(" + test_left2 + ", " + test_right2 + ")");
            System.out.println(pairs);
        }
        String newPair = "(sherlock, john)";
        pairs.add(newPair);
        try(Close out = outExpect("[(cleo, peter),(sherlock, john),(pat, fire)]")){
                System.out.println(pairs);
        }
        pairs.remove("(pat, fire)");
        try (Close out = outExpect("[(cleo, peter),(sherlock, john)]")){
            System.out.println(pairs);
        }
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
        
        assert pairs.contains(pair1) == true;
        assert pairs.contains("(jeremey, david") == false;
        assert pairs.contains(pair4) == true;
        assert pairs.contains(pair3) == true;
        
        pairs.remove(pair3);
        assert pairs.contains(pair3) == false;

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
        
        try(Close out = outExpect("["+pair1+","+pair2+","+pair3+","+pair4+"]")) {       
            System.out.println(pairs);
        }
        pairs.add(pairNew);
        
        try(Close out = outExpect("["+pairNew+"," +pair1+","+pair2+","+pair3+","+pair4+"]")) {       
            System.out.println(pairs);
        }
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
       
        pairs.add(pair5);
        
        try(Close out = outExpect("["+pair5+"," +pair1+","+pair2+","+pair3+","+pair4+"]")) {       
            System.out.println(pairs);
        }
       
        pairs.remove(pair1);
        pairs.remove(pair3);
        try(Close out = outExpect("["+pair5+","+pair2+","+pair4+"]")){
            System.out.println(pairs);
        }
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
