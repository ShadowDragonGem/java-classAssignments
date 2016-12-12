/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author deser
 */
public class Enemies {
    private int x;
    private int y;
    private int size;
    private int speed;
   
    public Enemies(int x, int y, int size, int speed){
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
    }
   
    public int getY(){
        return y;
    }
    
    public int getX(){
        return x;
    }
   
    public int getHeight(){
        return size;
    }
   
   public void move(){
       y+= speed;
   }
   
   public void tick(){
       move();
   }
   
   public void draw(Graphics g)
   {
       g.setColor(Color.red);
       g.fillRect(x, y, size, size);
   }
}
