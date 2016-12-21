/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;

/**
 *
 * @author sakulambo
 */
public abstract class ShapeObj extends GraphicObj{
    
    protected Shape shape;
    protected Color color;
    

    public ShapeObj(double x, double y, double vx, double vy, double angle,Shape shape,Color color, boolean visible) {
        super(x, y, vx, vy, angle, visible);
        this.shape=shape;
        this.color=color;
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


    @Override
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
}
