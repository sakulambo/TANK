/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tank;

/**
 *
 * @author sakulambo
 */
public class Utilities {
    
     public static double calculCoordenadaX(double x, double angle,double distX) {
        return distX * Math.sin(Math.toRadians(angle));
    }

    public static double calculCoordenadaY(double y, double angle, double distY) {
        return -distY * Math.cos(Math.toRadians(angle));
    }
    
}
