/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

/**
 *
 * @author deser
 */
import java.awt.EventQueue;
import kiss.API.*;

import javax.swing.JFrame;

public class Game extends JFrame{

    
    public Game(){
        
       initUI();
    }
    
    private void initUI(){
        add(new Board());
        setTitle("Avoid the Enemies");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                Game game = new Game();
                game.setVisible(true);
            }
        });
    }
    
}
