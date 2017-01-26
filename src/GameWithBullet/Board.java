/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameWithBullet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Joshua-OC
 */
public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Tank tank;

    private final int DELAY = 10;
    public final static int WIDTH = 790;
    public final static int HEIGHT = 563;
    public static LinkedList<Bullet> bullets;
    public static LinkedList<Explote> explotes;
    private Explote ex;

    //private Bullet bullet;
    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new GameWithBullet.Board.TAdapter());
        this.addMouseWheelListener(new Wheel2());
        this.addMouseListener(new clicked());
        setFocusable(true);
        setBackground(Color.BLACK);

        tank = new Tank("body", "turret", "radar", 50, 50, 2, 2, 0, true);

//        bullet = new Bullet(this.tank.getX(), this.tank.getY(), 2, 2, 0, true,
//                new Ellipse2D.Double(), Color.MAGENTA, 50, tank);
        bullets = new LinkedList<>();
        explotes = new LinkedList<>();

        //ex = new Explote("exploteBullet", 60, 60, 18 , 50, false, 100, 100, 0);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        tank.paint(g);

        for (Bullet b : bullets) {
            if (b.isVisible()) {
                b.paint(g);
            }

        }

        for (Explote ex : explotes) {
            ex.paint(g);
        }

        //bullet.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        tank.move();

        for (Bullet b : bullets) {
            if (b.isVisible()) {
                b.move();

                if (!inBoard(b.getX(), b.getY())) {
                    b.setVisible(false);
                    ex = new Explote("exploteBullet", 60, 60, 18, 50, false, (int) b.getX(), (int) b.getY(), 0);
                    explotes.add(ex);
                }
            }

        }

        //bullet.move();
        repaint();
    }

    private class Wheel2 extends MouseAdapter {

        @Override
        public void mouseWheelMoved(MouseWheelEvent mwe) {
            tank.mouseWheelMoved(mwe);
        }
    }

    private class clicked extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            tank.mouseClicked(e);
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            tank.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            tank.keyPressed(e);
        }
    }

    public static boolean inBoard(double x, double y) {
        return (x > 0 && x < Board.WIDTH && y > 0 && y < Board.HEIGHT);
    }

}
