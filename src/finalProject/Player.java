/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 *
 * @author deser
 */
public class Player {
    private int x;
    private int y;
    private int amountx;
    private int amounty;
    private int width=20;
    private int height=20;
    
    public Player(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    public int getx(){
        return x;
    }
    
    public int gety(){
        return y;
    }
    
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void move(){
        x += amountx;
        y +=amounty;
        
        if (x<1)
            x=1;
        if(y<1)
            y=1;
    }
    
    
    public void tick(){
        
    }
    
    public void draw(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
    }
    

    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();

        switch(keycode){
        case KeyEvent.VK_LEFT:
            amountx = -5;
            break;
        case KeyEvent.VK_RIGHT:
            amountx=5;
            break;
        case KeyEvent.VK_UP:
            amounty = -5;
            break;
        case KeyEvent.VK_DOWN:
            amounty =5;
            break;
        }
    }
    
     public void keyReleased(KeyEvent e) {
        int keycode = e.getKeyCode();

        switch(keycode){
        case KeyEvent.VK_LEFT:
            amountx = 0;
            break;
        case KeyEvent.VK_RIGHT:
            amountx=0;
            break;
        case KeyEvent.VK_UP:
            amounty = 0;
            break;
        case KeyEvent.VK_DOWN:
            amounty =0;
            break;
        }
    }
     
     public Rectangle getBounds(){
         return new Rectangle (x,y,width,height);
     }
}
