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
public class DefaultMammal extends DefaultAnimal implements Mammal{

    public DefaultMammal(String _name) {
        super(_name);
    }

    @Override
    public boolean isFurry() {
      return true;
    }
    
}
