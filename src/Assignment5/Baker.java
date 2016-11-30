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
public class Baker {
    String name;
    Items baked;
    boolean done = false;
    
    class Action extends Thread{
        public void run(){
            int count = 0;
            while(!done){
                pause(random(0, 500)*.001);
                ++count;
                baked.addItem(name + " new item " + count);
            }
        }
    }
    
    Action action;
    void complete(){
        done = true;
        try {
            action.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Baker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Baker(String _name, Items _baked){
        name = _name;
        baked = _baked;
        action = new Action();
        action.start();
    }
    
}
