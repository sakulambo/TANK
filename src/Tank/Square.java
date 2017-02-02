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
import java.awt.RenderingHints;
import java.awt.Shape;

/**
 *
 * @author sakulambo
 */
public class Square extends ShapeObj {
    
    private Tank owner;
    private Rectangle rec;

    public Square(Tank owner, Color color) {
        super(0, 0, owner.getVx(), owner.getVy(),owner.getBody().getAngle(), null, color, true);        
        
        rec = new Rectangle((int)owner.getX(), (int)owner.getY(), owner.getWidth(), owner.getHeight());   
        System.out.println(owner.getX());
        System.out.println(owner.getY());
        System.out.println(owner.getWidth());
        System.out.println(owner.getHeight());
     
        
        this.setShape(rec);
        this.setOwner(owner);
        this.setX(owner.getX());
        this.setY(owner.getY());
        
    }

    public Rectangle getRec() {
        return rec;
    }

    public void setRec(Rectangle rec) {
        this.rec = rec;
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
        g2d.draw(this.getShape());
    }
    
    

  
}
