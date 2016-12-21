/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *
 * @author sakulambo
 */
public class Bullet extends ShapeObj {

    private int power;
    private Tank owner;

    public Bullet(Tank owner, double x, double y, double vx, double vy, double angle, Color color, boolean visible) {
        super(0, 0, 4, 4, owner.getTurret().getAngle(), null, color, true);

        AffineTransform transformer = AffineTransform.getRotateInstance
        (Math.toRadians(owner.getTurret().getAngle()), owner.getX()
        + (owner.getWidth() / 2) - 2, owner.getY() + (owner.getHeight() / 2) - 3);

        
        Point2D before = new Point2D.Double(owner.getX() + 15, owner.getY() - 5);
        Point2D after = new Point2D.Double();
        after = transformer.transform(before, after);
        Ellipse2D.Double ed = new Ellipse2D.Double(after.getX(), after.getY(), power, power);
     
        
        this.setShape(ed);
        this.setPower(5);
        this.setOwner(owner);
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

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(this.getColor());

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        g2d.fill(this.getShape());        
    }

    public void move() {
        this.setX(this.getX() + Utilities.calculCoordenadaX(this.getX(), this.getAngle(), this.getVx()));
        this.setY(this.getY() + Utilities.calculCoordenadaY(this.getY(), this.getAngle(), this.getVy()));
        this.setShape(new Ellipse2D.Double(this.getX(), this.getY(), this.getPower(), this.getPower()));
    }   
    
}
