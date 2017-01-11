/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameWithBullet;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


/**
 *
 * @author Joshua-OC
 */
public class Bullet extends ShapeObject {
    
    private int power;
    private Tank owner;
    private Explote ex;

    public Bullet( Color color, int power, Tank owner) {
        
        super(0, 0, 4, 4, owner.getTurret().getAngle(), true, null, color);
        
        AffineTransform transformer = AffineTransform.getRotateInstance(
        Math.toRadians(owner.getTurret().getAngle()),
                owner.getX() + (owner.getWidth() / 2) - 2,
                owner.getY() + (owner.getWidth() / 2 ) -3);
        
        Point2D before = new Point2D.Double(owner.getX() + 15, owner.getY()-5);
        Point2D after = new Point2D.Double();
        
        after = transformer.transform(before, after);
        
        Ellipse2D.Double ed = new Ellipse2D.Double(this.getX(), this.getY(), power, power);
        
        this.setShape(ed);
        this.setPower(power);
        this.setOwner(null);
        this.setX(after.getX());
        this.setY(after.getY());
        
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Tank getOwner() {
        return owner;
    }

    public void setOwner(Tank owner) {
        this.owner = owner;
    }

    @Override
    public void paint(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setPaint(this.getColor());
        g2d.fill(this.getShape());

    }
    
    public void move(){
        
        //double x0 = 0, y0 = 0, anglet = 0;
        
        this.setX(this.getX() + Utilities.calculCoordenadaX(this.getAngle(), this.getVx()));
        this.setY(this.getY() + Utilities.calculCoordenadaY(this.getAngle(), this.getVy()));
        
        this.setShape(new Ellipse2D.Double(this.getX(), this.getY(), power, power));

    }



    
    
    
}
