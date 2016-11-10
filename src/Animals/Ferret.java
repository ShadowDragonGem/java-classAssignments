/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animals;
import static kiss.API.*;
/**
 *
 * @author deser
 */
public class Ferret extends animal {
    Ferret(String name){
        super(name);
    }
    void scurry(){
        println("scurry!!!");
    }
}
