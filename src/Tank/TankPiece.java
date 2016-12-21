 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tank;
  
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

/**
 *
 * @author glenn
 */
public class TankPiece extends ImageObj {

    public TankPiece(String file, double x, double y, double vx, double vy, double angle, boolean visible) {
        super(file, x, y, vx, vy, angle, visible);
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
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

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;        
        AffineTransform at = new AffineTransform();
        at.translate(this.getX() + this.getVx(),
                this.getY()+ this.getVy());
        at.rotate(Math.toRadians(this.getAngle()),
                (this.getWidth() / 2),
                (this.getHeight() / 2));
        g2d.drawImage(this.getImage(), at, null);
    }

  
    
    
    
}
