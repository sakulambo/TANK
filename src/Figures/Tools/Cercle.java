/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figures.Tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Figures.Tools.Board;

/**
 *
 * @author sakulambo
 */
public class Cercle {

    private int posx;
    private int posy;
    private int ample;
    private int alçada;
    private int vx;
    private int vy;
    private int radi;
    private Color color;

    public Cercle(int posx, int posy, int ample, int alçada,Color color) {
        this.posx = posx;
        this.posy = posy;
        this.ample = ample;
        this.alçada = alçada;       
        this.radi = ample / 2;
        this.color = color;

    }

    public Cercle(int posx, int posy, int ample, int alçada, int vx, int vy, int radi, Color color) {
        this.posx = posx;
        this.posy = posy;
        this.ample = ample;
        this.alçada = alçada;
        this.vx = vx;
        this.vy = vy;
        this.radi = radi;
        this.color = color;
    }

    //POS X
    public int getPosx() {
        return posx;
    }

    public Color getColor() {
        return color;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    //POS Y
    public int getPosy() {
        return posy;
    }

    public int getAlçada() {
        return alçada;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public int getRadi() {
        return radi;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    //AMPLADA
    public int getAmple() {
        return ample;
    }

    public void setAmple(int ample) {
        this.ample = ample;
    }

    //ALÇADA
    public int getAlcada() {
        return alçada;
    }

    public void setAlcada(int alçada) {
        this.alçada = alçada;
    }

    public void setAlçada(int alçada) {
        this.alçada = alçada;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public void setRadi(int radi) {
        this.radi = radi;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    

    public void pintar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(posx, posy, alçada, ample);
        
    }

    public void moviment() {
        posx = posx + vx;
        posy = posy + vy;

        if (posy > Board.B_HEIGHT - radi) {

            vx = +1;
            vy = - 1;
        }
        if (posx > Board.B_WIDTH - radi) {

            vx = - 1;
            vy = +1;
        }
        if (posy < Board.B_HEIGHT - radi) {

            vx = +1;
            vy = +1;
        }
        if (posx < Board.B_WIDTH - radi) {

            vx = - 1;
            vy = - 1;
        }

    }
}
