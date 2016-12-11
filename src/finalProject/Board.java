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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author deser
 */
public class Board extends JPanel{
    private Dimension d;
    private final Font smallfont = new Font("Helvetica", Font.BOLD, 14);

    private Color background;
    private boolean ingame = false;
    private boolean dying = false;
    
    
    
    public Board(){
       
        
        setFocusable(true);
        setBackground(Color.black);
    }
}
