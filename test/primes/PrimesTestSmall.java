/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primes;

/**
 *
 * @author deser
 */

import  java.util.*;
import static kiss.API.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class PrimesTestSmall {
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {0,false}, {1, false}, {2, true}, {3,true}, {4,false}
        });
    }
    
    Primes primes = new Primes();
    int x;
    boolean result;
    
}
