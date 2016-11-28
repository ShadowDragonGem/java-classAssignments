/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animals;

/**
 *
 * @author deser
 */
public class Platypus extends DefaultMammal implements Bird {
    
    private  DefaultBird birdness;
    public Platypus(String _name) {
        super(_name);
        birdness = new DefaultBird(_name);
    }

    @Override
    public void fly() {
        birdness.fly();
    }
    
    @Override
    public void setName(String name){
        birdness.setName(name);
        super.setName(name);
    }
  
    
}
