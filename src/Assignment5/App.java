/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment5;

import static kiss.API.*;
/**
 *
 * @author deser
 */
public class App {
    void run(){
        Items inventory = new Items();
        Baker jake = new Baker("Jake", inventory);
        Baker sue = new Baker("Sue", inventory);
        
        pause(1);
        
        Shopper jane = new Shopper("Jane", inventory);
        
        pause(2);
        jane.finish();
        
        Shopper hank = new Shopper("Hank", inventory);
        
        Shopper helen = new Shopper("Helen", inventory);
        
        
        pause(2);
        hank.finish();
        Shopper dan = new Shopper("Dan", inventory);
        
        pause(5);
        
        helen.finish();
        dan.finish();
        
        jake.complete();
        sue.complete();
        
    }
}
