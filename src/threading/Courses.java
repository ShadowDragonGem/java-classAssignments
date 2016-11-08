/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author deser
 */
public class Courses {
    private LinkedList<String> data  =new LinkedList<String>();
    
    public synchronized void addCourse(String corse){
        data.add(corse);
    }
    
    public synchronized  List<String> getCourses(){
        ArrayList<String> ans = new ArrayList<String>(data);
        return ans;
    }
    
}
