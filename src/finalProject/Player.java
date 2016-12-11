/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 *
 * @author deser
 */
public class Player {
    private int x;
    private int y;
    private int width;
    private int height;
    
    public Player(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void moveX(int amount){
        x += amount;
    }
    
    public void moveY(int amount){
        y +=amount;
    }
    public void tick(){
        
    }
    
    public void draw(Graphics g){
        g.setColor(Color.blue);
        g.fillOval(x, y, width, height);
    }
    

    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();

        switch(keycode){
        case KeyEvent.VK_LEFT:
            moveX(5);
            break;
        case KeyEvent.VK_RIGHT:
            moveX(-5);
            break;
        case KeyEvent.VK_UP:
            moveY(-5);
            break;
        case KeyEvent.VK_DOWN:
            moveY(5);
            break;
        }
    }
    
}
