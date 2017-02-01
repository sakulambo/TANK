/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Player1 p1;
    private Player2 p2;
    private final int DELAY = 10;
    public final static int WIDTH = 755;
    public final static int HEIGHT = 535;
    public static LinkedList<Bullet> bullets;
    public static LinkedList<Bullet> bullets2;
    public static LinkedList<Explote> ex, ex2;
    private Explote exp;
    private String rutaBullet = "src/imatges/exploteBullet.png";
    private String rutaImg = "src/imatges/";

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
        p1 = new Player1(rutaImg + "body.png", rutaImg + "turret.png", rutaImg + "radar.png", 50, 50, 5, 5, 0, true);
        p2 = new Player2(rutaImg + "greenBody.png", rutaImg + "greenTurret.png", rutaImg + "yellowRadar.png", 100, 100, 5, 5, 0, true);
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
        p1.paint(g);
        p2.paint(g);

        for (Bullet b : bullets) {
            if (b.isVisible()) {
                b.paint(g);
            }
        }

//        for (Bullet b : bullets2) {
//            if (b.isVisible()) {
//                b.paint(g);
//            }
//        }
        for (Explote explotes : ex) {
            explotes.paint(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p1.move();
        p2.move();

        for (Bullet b : bullets) {
            if (b.isVisible()) {
                b.move();

                if (!inBoard(b.getX(), b.getY())) {
                    b.setVisible(false);
                    exp = new Explote(rutaBullet, 60, 60, 18, 50, false,
                            (int) b.getX(), (int) b.getY(), 0);
                    System.out.println((int) b.getX() + "," + (int) b.getY());
                    System.out.println((int) exp.getX() + "," + (int) exp.getY());
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
        checkCollisions();
    }

    private class Wheel implements MouseWheelListener {

        @Override
        public void mouseWheelMoved(MouseWheelEvent mwe) {
            p2.mouseWheelMoved(mwe);
        }

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            p1.keyReleased(e);
            p2.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            p1.keyPressed(e);
            p2.keyPressed(e);
        }

    }

    private class Mouse extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            p2.fire(5);
        }

    }

    public void checkCollisions() {

        Rectangle.Double r1 = p1.getBounds();
        Rectangle.Double r2 = p2.geBounds();
        
         AffineTransform transform = AffineTransform.getRotateInstance(Math.toRadians(p1.getTurret().getAngle()), p1.getX()
                + (p1.getWidth() / 2) - 2, p1.getY() + (p1.getHeight() / 2) - 3);
         r1.setRect(r1);

        if (r1.intersects(r2)) {

        }
    }

    public static boolean inBoard(double x,
            double y) {
        return (x > 0 && x < Board.WIDTH && y > 0
                && y < Board.HEIGHT);
    }

}
