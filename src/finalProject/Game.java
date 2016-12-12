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
import java.awt.Color;
import kiss.API.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame implements Runnable{

    
    public Game(){
        add(new Board());
        setTitle("Avoid the Enemies");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
       
    }
    
    public void run(){
        new Game();
    }
}
