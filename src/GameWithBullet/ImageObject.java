/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameWithBullet;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Joshua-OC
 */
public abstract class ImageObject extends GraphicObject {
    
    protected Image image;
    protected int width;
    protected int height;
    protected String fileName;

    
    public ImageObject(String fileName, double x, double y, double vx, double vy,
            double angle, boolean visible) {
        
        super(x, y, vx, vy, angle, visible);
        this.fileName = fileName;
        
        this.image = (new ImageIcon("src/images/"+fileName+".png")).getImage();
        this.width=image.getWidth(null);        
        this.height=image.getHeight(null);
        
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    
    
    
    
    
}
