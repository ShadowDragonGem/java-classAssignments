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
public class Raven extends DefaultBird{
    Raven(String _name){
        super(_name);
    }
    void quoth(){
        println("nevermore...");
    }
    
    @Override
    public void fly(){
        super.fly();
        println("quietly...");
    }
    
}
