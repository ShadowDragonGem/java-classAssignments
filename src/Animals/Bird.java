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
public class Bird extends animal{
    Bird(String name){
        super(name);
    }
    void fly(){
        println("flying...");
    }
}
