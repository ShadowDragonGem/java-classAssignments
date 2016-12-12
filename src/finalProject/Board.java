/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author deser
 */
public class Board extends JPanel implements ActionListener{
    private Dimension d;
    
    private boolean ingame;
    private Timer timer;
    private Timer scoreTimer;
    private Timer enemyTimer;
    
    private int score = 0;
    
    Player player;
    List<Enemies> enemies;
    Random randNum = new Random();
    int timeSinceLastEnemy = 0;
    
    public Board(){
      initBoard();
    }
    
    public void initBoard(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.black);
        ingame = true;
        player = new Player(300,300);
        initEnemies();
        timer = new Timer(15, this);
        timer.start();
        
    }
   
    
    public void initEnemies(){
        enemies = new ArrayList<>();
        enemies.add(new Enemies(100, -5, randNum.nextInt(40), randNum.nextInt(8)+1));
    }
    
    public void addEnemy(){
        int size = randNum.nextInt(40);
        int speed = randNum.nextInt(8);
        if(timeSinceLastEnemy >5 || enemies.isEmpty()){
            enemies.add(new Enemies(randNum.nextInt(600),size,size,speed));
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(ingame){
            drawObjects(g);
        }else {
            drawGameOver(g);
        }
        
        Toolkit.getDefaultToolkit().sync();
    }
    private void drawObjects(Graphics g){
       player.draw(g);
       
       for(Enemies e: enemies){
           e.draw(g);
       }
       
       g.setColor(Color.WHITE);
       g.drawString("Score: " + score, 5, 15);
    }
    
    private void drawGameOver(Graphics g){
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (600 -fm.stringWidth(msg))/2, 600/2);
    }
    
    @Override
    
    public void actionPerformed(ActionEvent e){
        inGame();
        updatePlayer();
        updateEnemies();
        
        score++;
        timeSinceLastEnemy++;
        repaint();
    }
    
    private void inGame(){
        if(!ingame){
            timer.stop();
        }
    }
    
    private void updatePlayer(){
        player.move();
    }
    
    private void updateEnemies(){
        int x;
        int y;
        int size;
        addEnemy();
        if(enemies.isEmpty()){
            ingame = false;
            return;
        }
        
        for(int i = 0; i<enemies.size(); ++i){
            Enemies e = enemies.get(i);
            x=e.getX();
            y=e.getY();
            size = e.getHeight();
            if((x+size!=600)&&(y+size!=600))
                e.move();
            else
                enemies.remove(i);
        }
    }
    
    private class TAdapter extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e){
            player.keyReleased(e);
        }
        
        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);
        }
    }
}
