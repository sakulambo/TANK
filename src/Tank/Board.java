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
    private Explote exp2;
    private String rutaBullet = "src/imatges/exploteBullet.png";
    private String rutaDeath = "src/imatges/exploteDeath.png";
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
        p1 = new Player1(rutaImg + "body.png", rutaImg + "turret.png", rutaImg + "radar.png", 50, 50, 5, 5, 0, 100, true);
        p2 = new Player2(rutaImg + "greenBody.png", rutaImg + "greenTurret.png", rutaImg + "yellowRadar.png", 100, 100, 5, 5, 0, 100, true);
        timer = new Timer(DELAY, this);
        timer.start();
        bullets = new LinkedList<>();
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

        for (Explote explotes : ex) {
            explotes.paint(g);
        }

        for (Explote ex : ex2) {
            ex.paint(g);
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
                    ex.add(exp);
                }
            }
        }
        repaint();
        checkCollisions();
        checkCollisionBullet();
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
        boolean collision = false;

        if ((p1.getRectangle().getShape().intersects((Rectangle) p2.getRectangle().getShape()))) {
            effectCollision();
        }
    }

    public void checkCollisionBullet() {

        for (Bullet b : bullets) {
            if (b.getOwner().equals(p2) && b.bulletHit(p1.getRectangle().getRectangle2D())) {
                p1.setLife(--p1.life);
                System.out.println("VIDA DEL TANKE 1 -> " + p1.getLife());
                exp2 = new Explote(rutaBullet, 60, 60, 18, 50, false,
                        (int) p1.getX() + p1.getWidth(), (int) p1.getY() + p1.getHeight(), 0);
                ex2.add(exp2);
            } else if (b.getOwner().equals(p1) && b.bulletHit(p2.getRectangle().getRectangle2D())) {
                p2.setLife(--p2.life);
                System.out.println("VIDA DEL TANKE 2 -> " + p2.getLife());
                exp2 = new Explote(rutaBullet, 60, 60, 18, 50, false,
                        (int) p2.getX() + p2.getWidth(), (int) p2.getY() + p2.getHeight(), 0);
                ex2.add(exp2);
            }
        }
    }

    private void effectCollision() {
        exp = new Explote(rutaBullet, 60, 60, 18, 50, false,
                (int) p1.getX() + p1.getWidth(), (int) p1.getY() + p1.getHeight(), 0);
        exp2 = new Explote(rutaBullet, 60, 60, 18, 50, false,
                (int) p2.getX() + p2.getWidth(), (int) p2.getY() + p2.getHeight(), 0);
        ex.add(exp);
        ex.add(exp2);
        p1.setX(p1.getX() - 5);
        p1.setY(p1.getY() + 5);
        p2.setX(p2.getX() + 5);
        p2.setY(p2.getY() - 5);
    }

    private boolean winCondition() {
        return p1.getLife() <= 0 || p2.getLife() <= 0;
    }

    public static boolean inBoard(double x,
            double y) {
        return (x > 0 && x < Board.WIDTH && y > 0
                && y < Board.HEIGHT);
    }

}
