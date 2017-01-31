/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Tank tank, tank2;
    private final int DELAY = 10;
    public final static int WIDTH = 755;
    public final static int HEIGHT = 535;
    public static LinkedList<Bullet> bullets;
    public static LinkedList<Bullet> bullets2;
    public static LinkedList<Explote> ex, ex2;
    private Explote exp;
    private String rutaBullet = "src/imatges/exploteBullet.png";

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        this.addMouseWheelListener(new Wheel());
        this.addMouseListener(new Mouse() {
        });
        setFocusable(true);
        setBackground(Color.BLACK);
        tank = new Tank(null, 50.0, 50.0, 1.0, 1.0, 0.0, true,"Player1");
        tank2 = new Tank(null, 100.0, 100.0, 1.0, 1.0, 0.0, true,"Player2");
        timer = new Timer(DELAY, this);
        timer.start();
        bullets = new LinkedList<>();
        bullets2 = new LinkedList<>();
        ex = new LinkedList<>();
        ex2 = new LinkedList<>();

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
        tank2.paint(g);

        for (Bullet b : bullets) {
            if (b.isVisible()) {
                b.paint(g);
            }
        }

        for (Bullet b : bullets2) {
            if (b.isVisible()) {
                b.paint(g);
            }
        }

        for (Explote explotes : ex) {
            explotes.paint(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tank.move();
        tank2.move();
        

        for (Bullet b : bullets) {
            if (b.isVisible()) {
                b.move();

                if (!inBoard(b.getX(), b.getY())) {
                    b.setVisible(false);
                    exp = new Explote(rutaBullet, 60, 60, 18, 50, false, 
                            (int) b.getX(), (int) b.getY(), 0);
                    System.out.println((int)b.getX()+","+ (int)b.getY());
                     System.out.println((int)exp.getX()+","+ (int)exp.getY());
                    ex.add(exp);

                }
            }
        }
//        for (Bullet b: bullets2) {
//            if (b.isVisible()) {
//                b.move();
//
//                if (!inBoard(b.getX(), b.getY())) {
//                    b.setVisible(true);
//                    System.out.println("hola25");
//                    exp = new Explote(rutaBullet, 60, 60, 18, 50, false, 
//                            (int) b.getX(), (int) b.getY(), 0);
//                    ex2.add(exp);
//                }
//            }
//        }
        repaint();
    }

    private class Wheel implements MouseWheelListener {

        @Override
        public void mouseWheelMoved(MouseWheelEvent mwe) {
            tank.mouseWheelMoved(mwe);
        }

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            tank.keyReleased(e);
            tank2.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            tank.keyPressed(e);
            tank2.keyPressed(e);
        }

    }

    private class Mouse extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            tank.fire(5);
        }

    }

    public static boolean inBoard(double x,
            double y) {
        return (x > 0 && x < Board.WIDTH && y > 0
                && y < Board.HEIGHT);
    }

}
