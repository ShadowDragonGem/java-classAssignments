/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animals;
import java.util.LinkedList;
import static kiss.API.*;
/**
 *
 * @author deser
 */
public class App {
    void testAnimals(){
        LinkedList<DefaultAnimal> animals = new LinkedList<DefaultAnimal>();
        animals.add(new Ferret("Slim"));
        animals.add(new Ferret("Tim"));
        animals.add(new Raven("Poe"));
        animals.add(new DefaultBird("Dee"));
        
        for(DefaultAnimal Animal: animals){
            println("Name: " + Animal.getName());
        }
        
        for (DefaultAnimal Animal: animals){
            if (Animal instanceof DefaultBird){
                DefaultBird bird = (DefaultBird) Animal;
                bird.fly();
            }
        }
    }
    
    void testPlatypus(){
        Platypus pete = new Platypus("Pete");
        assert pete.isFurry() == true;
    }
    
    void testCollectionOfAnimals(){
        LinkedList<DefaultAnimal> animals = new LinkedList<DefaultAnimal>();
        animals.add(new Ferret("Slim"));
        animals.add(new Ferret("Tim"));
        animals.add(new Raven("Poe"));
        animals.add(new DefaultBird("Dee"));
        
        try (Close out = outExpect("Name: Slim", EOL,
                                    "Name: Tim", EOL, 
                                    "Name: Poe" , EOL,
                                    "Name: Dee")){
            for(DefaultAnimal Animal: animals){
                println("Name: " + Animal.getName());
            }
        }
        
    }
    
    void testOnlyBirdsFly(){
         LinkedList<DefaultAnimal> animals = new LinkedList<DefaultAnimal>();
        animals.add(new Ferret("Slim"));
        animals.add(new Ferret("Tim"));
        animals.add(new Raven("Poe"));
        animals.add(new DefaultBird("Dee"));
        
        try(Close out = outExpect("flying...", EOL, "quietly...", EOL, "flying...")){
            for (DefaultAnimal Animal: animals){
                if (Animal instanceof DefaultBird){
                    DefaultBird bird = (DefaultBird) Animal;
                    bird.fly();
                }
            }
        } 
    }
    
    void testCastException(){
        LinkedList<DefaultAnimal> animals = new LinkedList<DefaultAnimal>();
        animals.add(new Ferret("Slim"));
        boolean passed = false;
        try{
        DefaultBird bird = (DefaultBird) animals.getFirst();
        } catch (ClassCastException ex){
            passed = true;
        }
        assert passed;
    }
}
