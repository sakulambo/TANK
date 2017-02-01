/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tank;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author sakulambo
 */
public class Player1 extends Tank {
    
    private int up;
    private int down;
    private int right;
    private int left;
    private int wup;
    private int wdown;
    
    
    
    public Player1(String bod, String turret, String radar, double x, double y, double vx, double vy, double angle, boolean visible) {
        super(bod, turret, radar, x, y, vx, vy, angle, visible);
        
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getWup() {
        return wup;
    }

    public void setWup(int wup) {
        this.wup = wup;
    }

    public int getWdown() {
        return wdown;
    }

    public void setWdown(int wdown) {
        this.wdown = wdown;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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
    
    
    
    
    
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            up = 1;
        }

        if (key == KeyEvent.VK_S) {
            down = 1;
        }

        if (key == KeyEvent.VK_D) {
            right = 1;
        }

        if (key == KeyEvent.VK_A) {
            left = 1;
        }

        if (key == KeyEvent.VK_L) {
            double anglet = turret.getAngle();
            anglet = anglet + 5;
            this.getTurret().setAngle(anglet);
            this.getRadar().setAngle(anglet);
            System.out.println("Player 1 Angle++ -> "+this.getTurret().getAngle());
        }

        if (key == KeyEvent.VK_K) {
            double anglet = turret.getAngle();
            anglet = anglet - 5;
            this.getTurret().setAngle(anglet);
            this.getRadar().setAngle(anglet);
            System.out.println("Player 1 Angle-- -> "+this.getTurret().getAngle());
        }

        if (key == KeyEvent.VK_SPACE) {
            this.fire(5);
        }
    }
    
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            up = 0;
        }

        if (key == KeyEvent.VK_S) {
            down = 0;
        }

        if (key == KeyEvent.VK_D) {
            right = 0;
        }

        if (key == KeyEvent.VK_A) {
            left = 0;
        }

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

    Rectangle2D.Double getBounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
   
   
    
}
