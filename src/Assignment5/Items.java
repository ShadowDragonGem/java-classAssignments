/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author deser
 */
public class Items {
    private LinkedList<String> data = new LinkedList<String>();
    
    public synchronized void addItem(String item){
        data.add(item);
    }
    
    public synchronized List<String> getList(){
        ArrayList<String> ans = new ArrayList<String>(data);
        return ans;
    }
}
