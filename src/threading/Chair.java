/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threading;
import java.util.logging.Level;
import java.util.logging.Logger;
import static kiss.API.*;
/**
 *
 * @author deser
 */
public class Chair {
    String name;
    Courses courses;
    boolean retired = false;
    class Action extends Thread{
        public void run(){
            int count = 0;
            while(!retired){
                pause(random(0,1000)*.001);
                ++count;
                courses.addCourse(name + " is great class "+ +count);
                
            }
        }
    }
    
    Action action;
    void retired(){
        retired = true;
        try {
            action.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Chair.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    Chair (String _name, Courses _courses){
        name = _name;
        courses = _courses;
        action = new Action();
        action.start();
    }
}
