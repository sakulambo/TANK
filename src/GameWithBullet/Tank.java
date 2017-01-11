/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameWithBullet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Ellipse2D;

/**
 * @author Joshua-OC
 */

public class Tank extends ImageObject {
    
    private TankPiece body;
    private TankPiece turret;
    private TankPiece radar;
    private int width;
    private int height;
    private int up;
    private int down;
    private int left;
    private int right;
    private int wup;
    private int wdown;

    public Tank(String body, String turret, String radar, double x, double y, double vx,
            double vy, double angle, boolean visible) {
        
        
        super(null, x, y, vx, vy, angle, visible);

        this.body = new TankPiece(body, x, y, vx, vy, angle, visible, 0, 0);
        this.turret = new TankPiece(turret, x, y, vx, vy, angle, visible, 8, -8);
        this.radar = new TankPiece(radar, x, y, vx, vy, angle, visible, 7, 11);
        
        this.width = this.body.getWidth();
        this.height = this.body.getHeight();
        
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

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
    
    

    
    
    public void move(){
        
         double x0=0,y0=0,anglet=0;
        
         x0= x + up * Utilities.calculCoordenadaX( angle, vx);
         y0=y + up * Utilities.calculCoordenadaY( angle, vy);
         x0= x0 + down * Utilities.calculCoordenadaX( angle+180, vx);         
         y0= y0 + down * Utilities.calculCoordenadaY( angle+180, vy);
         
         angle += right;
         angle -= left;
         
         anglet=this.getTurret().getAngle();
         anglet=anglet+right;
         anglet=anglet-left;
          if(Board.inBoard(x0, y0)){
            x=x0;
            y=y0;
               this.setTank(anglet);
        }   
        
        
    }
    
    public void setTank(double anglet){
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
        
           up=1;              
        }

       if (key == KeyEvent.VK_DOWN) {
           down=1;

        }
        
        if (key == KeyEvent.VK_RIGHT) {
           right=1;

        }
       if (key == KeyEvent.VK_LEFT) {
          left=1;

        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

       if (key == KeyEvent.VK_UP) {
           up=0;              
        }

       if (key == KeyEvent.VK_DOWN) {
           down=0;

        }
        
        if (key == KeyEvent.VK_RIGHT) {
           right=0;

        }
       if (key == KeyEvent.VK_LEFT) {
          left=0;

        }
    }
    
    public void mouseWheelMoved(MouseWheelEvent e) {
       
        int notches = e.getWheelRotation();
       if (notches < 0) {
           
            double anglet=turret.getAngle();
            anglet=anglet-5;
            this.getTurret().setAngle(anglet);
            this.getRadar().setAngle(anglet);
            System.out.println(this.getTurret().getAngle());
            wdown=1;
            
       } else if(notches>0){
         
            double anglet=turret.getAngle();
            anglet=anglet+5;
            this.getTurret().setAngle(anglet);
            this.getRadar().setAngle(anglet);
            System.out.println(this.getTurret().getAngle());
            
       }if(notches==0){
           
       }
     }
    
    
    
    @Override
    public void paint(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        this.getBody().paint(g);
        this.getTurret().paint(g);
        this.getRadar().paint(g);
        
    }
    
    public Bullet fire () {
        
        Bullet auxBullet = new Bullet(Color.YELLOW, 4, this);
        
         return auxBullet;
        
    }
    
    public void mouseClicked(MouseEvent e) {
        Board.bullets.add(this.fire());
    }

}
