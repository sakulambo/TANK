/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;

/**
 *
 * @author glenn
 */
public class Tank extends ImageObj {

    private TankPiece body;
    private TankPiece turret;
    private TankPiece radar;

    private int up;
    private int down;
    private int right;
    private int left;
    private int wup;
    private int wdown;

    public Tank(String file, double x, double y, double vx, double vy, double angle, boolean visible) {
        super(null, x, y, vx, vy, angle, visible);
        this.body = new TankPiece("body.png", x, y, 0, 0, angle, visible);
        this.turret = new TankPiece("turret.png", x, y, 8, -8, angle, visible);
        this.radar = new TankPiece("radar.png", x, y, 7, 11, angle, visible);
        this.width = body.getWidth();
        this.height = body.getHeight();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public TankPiece getBody() {
        return body;
    }

    public void setBody(TankPiece body) {
        this.body = body;
    }

    public TankPiece getTurret() {
        return turret;
    }

    public void setTurret(TankPiece turret) {
        this.turret = turret;
    }

    public TankPiece getRadar() {
        return radar;
    }

    public void setRadar(TankPiece radar) {
        this.radar = radar;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        this.getBody().paint(g);
        this.getTurret().paint(g);
        this.getRadar().paint(g);

    }

    public void move() {
        double x0 = 0, y0 = 0;

        x0 = x + up * Utilities.calculCoordenadaX(x, angle, vx);
        y0 = y + up * Utilities.calculCoordenadaY(y, angle, vy);
        x0 = x0 + down * Utilities.calculCoordenadaX(x, angle + 180, vx);
        y0 = y0 + down * Utilities.calculCoordenadaY(y, angle + 180, vy);
        angle = angle + right;
        angle = angle - left;
        double anglet = this.getTurret().getAngle();
        anglet = anglet + right;
        anglet = anglet - left;
        if (Board.inBoard(x0, y0)) {
            x = x0;
            y = y0;
            this.setTank(anglet);
        }

    }

    public void setTank(double anglet) {
        body.setX(x);
        body.setY(y);
        body.setAngle(angle);
        turret.setX(x);
        turret.setY(y);
        turret.setAngle(anglet);
        radar.setX(x);
        radar.setY(y);
        radar.setAngle(anglet);

    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {

            up = 1;
        }

        if (key == KeyEvent.VK_DOWN) {
            down = 1;

        }

        if (key == KeyEvent.VK_RIGHT) {
            right = 1;

        }
        if (key == KeyEvent.VK_LEFT) {
            left = 1;

        }
        if (key == KeyEvent.VK_SPACE) {
            this.fire(5);
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            up = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            down = 0;

        }

        if (key == KeyEvent.VK_RIGHT) {
            right = 0;

        }
        if (key == KeyEvent.VK_LEFT) {
            left = 0;

        }
    }

    public void mouseWheelMoved(MouseWheelEvent e) {

        int notches = e.getWheelRotation();
        if (notches < 0) {

            double anglet = turret.getAngle();
            anglet = anglet - 5;
            this.getTurret().setAngle(anglet);
            this.getRadar().setAngle(anglet);
            System.out.println(this.getTurret().getAngle());
            wdown = 1;
        } else if (notches > 0) {

            double anglet = turret.getAngle();
            anglet = anglet + 5;
            this.getTurret().setAngle(anglet);
            this.getRadar().setAngle(anglet);
            System.out.println(this.getTurret().getAngle());
        }
        if (notches == 0) {

        }
    }

    public void fire(int power) {
        Bullet b = new Bullet(this, this.getX(), this.getY(),
                power, power, this.getAngle(), Color.yellow, true);
        Board.bullets.add(b);

    }

}
