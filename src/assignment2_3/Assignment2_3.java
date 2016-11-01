/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_3;

/**
 *
 * @author deser
 */
import java.util.*;
import static kiss.API.*;


public class Assignment2_3 {
    /* 
    collections test homewroks, with extra tests added  (coppied from former repo and added to.)
    */
    
    /*
    Problem on hakerRank
    https://www.hackerrank.com/challenges/java-hashset
    plus some more things to make it more interesting
    */
    
    void testHashSetPairsUnique(){
        String test_left1 = "rachel";
        String test_right1 = "tim";
        String test_left2 = "sam";
        String test_right2 = "dee";
        
        HashSet<String> pairs = new HashSet<String>();
        try(Close out = outExpect( "[(sam, dee),(rachel, tim)]")){
            pairs.add("(" + test_left1 + ", " + test_right1 + ")");
            pairs.add("(" + test_left2 + ", " + test_right2 + ")");
            println(pairs);
        }
    }
    
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
            println(pairs);
        }
    }
    
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
            println(pairs);
        }
        String newPair = "(sherlock, john)";
        pairs.add(newPair);
        try(Close out = outExpect("[(cleo, peter),(sherlock, john),(pat, fire)]")){
                println(pairs);
        }
        pairs.remove("(pat, fire)");
        try (Close out = outExpect("[(cleo, peter),(sherlock, john)]")){
            println(pairs);
        }
    }
    
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
            println(pairs);
        }
        pairs.add(pairNew);
        
        try(Close out = outExpect("["+pairNew+"," +pair1+","+pair2+","+pair3+","+pair4+"]")) {       
            println(pairs);
        }
    }
    
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
            println(pairs);
        }
         
        pairs.remove(pair1);
        pairs.remove(pair3);
        try(Close out = outExpect("["+pair5+","+pair2+","+pair4+"]")){
            println(pairs);
        }
    }
    
        
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
        
        assert pairs.contains(pair5) == false;
        pairs.add(pair5);
        assert pairs.contains(pair5) == true;
        
        try(Close out = outExpect("["+pair5+"," +pair1+","+pair2+","+pair3+","+pair4+"]")) {       
            println(pairs);
        }
        
        assert pairs.contains(pair2) == true;
        assert pairs.contains(pair1) == true;
        assert pairs.contains(pair3) == true;
        assert pairs.contains(pair4) == true;
         
        pairs.remove(pair1);
        pairs.remove(pair3);
        try(Close out = outExpect("["+pair5+","+pair2+","+pair4+"]")){
            println(pairs);
        }
        
        assert pairs.contains(pair1)==false;
        assert pairs.contains(pair3)==false;
    }
     
    void run() {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for(int i = 0; i<t; i++){
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        
        HashSet<String> pairs = new HashSet<String>();
        
        for(int i = 0; i<t; i++){
            pairs.add("(" + pair_left[i] + ", " + pair_right[i] + ")");
            println(pairs.size());
        }
        println(pairs);
    }
}
