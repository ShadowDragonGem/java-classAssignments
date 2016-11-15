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
        LinkedList<animal> animals = new LinkedList<animal>();
        animals.add(new Ferret("Slim"));
        animals.add(new Ferret("Tim"));
        animals.add(new Raven("Poe"));
        animals.add(new Bird("Dee"));
        
        for(animal Animal: animals){
            println("Name: " + Animal.name);
        }
        
        for (animal Animal: animals){
            if (Animal instanceof Bird){
                Bird bird = (Bird) Animal;
                bird.fly();
            }
        }
    }
    
    void testCollectionOfAnimals(){
        LinkedList<animal> animals = new LinkedList<animal>();
        animals.add(new Ferret("Slim"));
        animals.add(new Ferret("Tim"));
        animals.add(new Raven("Poe"));
        animals.add(new Bird("Dee"));
        
        try (Close out = outExpect("Name: Slim", EOL,
                                    "Name: Tim", EOL, 
                                    "Name: Poe" , EOL,
                                    "Name: Dee")){
            for(animal Animal: animals){
                println("Name: " + Animal.name);
            }
        }
        
    }
    
    void testOnlyBirdsFly(){
         LinkedList<animal> animals = new LinkedList<animal>();
        animals.add(new Ferret("Slim"));
        animals.add(new Ferret("Tim"));
        animals.add(new Raven("Poe"));
        animals.add(new Bird("Dee"));
        
        try(Close out = outExpect("flying...", EOL, "quietly...", EOL, "flying...")){
            for (animal Animal: animals){
                if (Animal instanceof Bird){
                    Bird bird = (Bird) Animal;
                    bird.fly();
                }
            }
        } 
    }
    
    void testCastException(){
        LinkedList<animal> animals = new LinkedList<animal>();
        animals.add(new Ferret("Slim"));
        boolean passed = false;
        try{
        Bird bird = (Bird) animals.getFirst();
        } catch (ClassCastException ex){
            passed = true;
        }
        assert passed;
    }
}
