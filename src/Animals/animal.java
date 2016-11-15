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
public class animal implements AnimalInterface {
    String name;
    
    animal(String _name){
        name = _name;
    }

    @Override
    public String getName() {
    return name;
    }

    @Override
    public void setName(String _name) {
        name = _name;
    }
}
