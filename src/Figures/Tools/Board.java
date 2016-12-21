/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figures.Tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    public static final int B_WIDTH = 350;
    public static final int B_HEIGHT = 350;
    private final int INITIAL_X = 0;
    private final int INITIAL_Y = 50;
    private final int DELAY = 25;

    private Timer timer;
    private Cercle cercle;
    private int x, y, vx, vy;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);

        x = INITIAL_X;
        y = INITIAL_Y;
        
        cercle = new Cercle(x, y, 50, 20, Color.yellow);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        cercle.pintar(g);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cercle.moviment();
        repaint();
    }

}
