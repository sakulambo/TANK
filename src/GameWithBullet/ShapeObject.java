/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameWithBullet;

import java.awt.Color;
import java.awt.Shape;

/**
 *
 * @author Joshua-OC
 */
public abstract class ShapeObject extends GraphicObject{
    
    protected Shape shape;
    protected Color color;

    public ShapeObject(double x, double y, double vx, double vy, double angle,
            boolean visible, Shape shape, Color color) {
        
        super(x, y, vx, vy, angle, visible );
        
        this.shape = shape;
        this.color = color;
        
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
    
    
    
    
    
}
