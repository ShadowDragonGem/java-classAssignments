/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment5;

import java.util.logging.Level;
import java.util.logging.Logger;
import static kiss.API.*;

/**
 *
 * @author deser
 */
public class Shopper {
    String name;
    Items bought;
    boolean finished = false;
    
    class Action extends Thread{
        public void run(){
            while(!finished){
                pause(random(0,3000)*.001);
                println(name, " bought ", bought.getList());
            }
            
        }
        
        
    }
    
    Action action;
    void finish(){
        finished = true;
     
        try {
            action.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Shopper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    Shopper(String _name, Items _bought){
        name = _name;
        bought = _bought;
        action = new Action();
        action.start();
    }
}
