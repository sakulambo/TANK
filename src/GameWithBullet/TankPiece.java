/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameWithBullet;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;

/**
 *
 * @author Joshua-OC
 */
public class TankPiece extends ImageObject {
    
    private double dx;
    private double dy;

    public TankPiece(String fileName, double x, double y, double vx, double vy,
            double angle, boolean visible, double dx, double dy) {
        
        super(fileName, x, y, vx, vy, angle, visible);
        
        this.dx = dx;
        this.dy = dy;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    @Override
    public void paint(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;        
        AffineTransform at = new AffineTransform();
        at.translate(this.getX() + this.getDx(),
                this.getY()+ this.getDy());
        at.rotate(Math.toRadians(this.getAngle()),
                (this.getWidth() / 2),
                (this.getHeight() / 2));
        g2d.drawImage(this.getImage(), at, null);
        
    }
    
    
    
}
