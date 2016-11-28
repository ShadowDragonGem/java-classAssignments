/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment5;

import static kiss.API.*;
/**
 *
 * @author deser
 */
public class App {
    void run(){
        Items inventory = new Items();
        Baker jake = new Baker("Jake", inventory);
        pause (10);
        jake.complete();
    }
}
