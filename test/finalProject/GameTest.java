/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deser
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   

    
   

    /**
     * Test of addEnemy method, of class Board.
     */
    @Test
    public void testAddEnemy() {
        List<Enemies> enemies;
        enemies = new ArrayList<Enemies>();
        enemies.add(new Enemies(10,10,10,10));
        assertTrue(enemies.size()==1);
        assertTrue(enemies.get(0).getY() == 10);
    }

   
   /* @Test
    public void testScoreSystem(){
        Timer timer;
        timer = new Timer(15, );
        
    }
   */
    @Test
    public void testPlayer(){
        Player player;
        player = new Player(15,30);
       
        assertTrue(player.getHeight() == 20);
        assertFalse(player.getWidth() == 30);
        assertTrue(player.getx() == 15);
        assertTrue(player.gety() == 30);
        
    }
    
    @Test
    public void testCheckCollisions(){
        boolean ingame = true;
        Random randNum = new Random();
        Player player = new Player(14, 25);
        ArrayList<Enemies> enemies = new ArrayList<>();
        enemies.add(new Enemies(14,25, randNum.nextInt(40), randNum.nextInt(8)+1));

        
        Rectangle r3 = player.getBounds();
        
        for (Enemies enemy: enemies){
            Rectangle r2 = enemy.getBounds();
            
            if(r3.intersects(r2)){
                ingame = false;
            }
        }
        assertTrue(r3.intersects(enemies.get(0).getBounds()));
        assertFalse(ingame);
    }
    
    @Test 
    public void testRemoveEnemies(){
         List<Enemies> enemies = new ArrayList<Enemies>();
        enemies.add(new Enemies(10,10,10,10));
        enemies.add(new Enemies(20,20,20,20));
        enemies.add(new Enemies(5,5,5,5));
        assertTrue(enemies.size()==3);
        assertTrue(enemies.get(0).getX()==10);
        enemies.remove(enemies.get(0));
        assertTrue(enemies.get(0).getX()!=10);
    }
}
