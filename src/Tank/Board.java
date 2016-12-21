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
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Tank tank;
    private Bullet bullet;
    private final int DELAY = 10;
    public final static int WIDTH = 755;
    public final static int HEIGHT = 535;
    public static LinkedList<Bullet> bullets;
    public static LinkedList<Explote> ex;
    private Explote exp, exp2;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        this.addMouseWheelListener(new Wheel());
        setFocusable(true);
        setBackground(Color.BLACK);
        tank = new Tank(null, 50.0, 50.0, 1.0, 1.0, 0.0, true);
        bullet = new Bullet(tank, 75, 75, 5, 5, 120, Color.YELLOW, true);
        timer = new Timer(DELAY, this);
        timer.start();
        bullets = new LinkedList<>();
        ex = new LinkedList<>();

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
        for (int i = 0; i < bullets.size(); i++) {
            if (bullet.isVisible()) {
                bullets.get(i).paint(g);
            }
        }
        for (int i = 0; i < ex.size(); i++) {
            if (bullet.isVisible()) {
                if (inBoard(bullet.getX(), bullet.getY())) {
                    exp = new Explote("exploteBullet.png", 100, 100, 30, 200, true,
                            (int) bullet.getX(), (int) bullet.getY(), 200);
                    ex.add(exp);
                    this.bullet.setVisible(false);
                    ex.get(i).paint(g);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tank.move();
        for (int i = 0; i < bullets.size(); i++) {
            if (bullet.isVisible()) {
                bullets.get(i).move();
                

            }
        }
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
        }

        @Override
        public void keyPressed(KeyEvent e) {
            tank.keyPressed(e);
        }

    }

    public static boolean inBoard(double x,
            double y) {
        return (x > 0 && x < Board.WIDTH && y > 0
                && y < Board.HEIGHT);
    }

}
