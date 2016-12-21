/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figures;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sakulambo
 */
class Cuadrat2 extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(new Color(150, 150, 150));

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        g2d.fillRect(30, 20, 50, 50);
//        g2d.setPaint(new Color(250, 250, 250));
//        g2d.fillRect(120, 20, 100, 100);
//        g2d.setPaint(new Color(0, 0, 0));
//        g2d.fillOval(260, 20, 50, 50);
//        g2d.setPaint(new Color(140, 0,140 ));
//        g2d.fillOval(350, 20, 100, 100);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    public class Rectangle {

        private int posx;
        private int posy;
        private int ample;
        private int alçada;
        private Color color;

        public Rectangle(int posx, int posy, int ample, int alçada, Color color) {
            this.posx = posx;
            this.posy = posy;
            this.ample = ample;
            this.alçada = alçada;
            this.color = color;
        }

        //POS X
        public int getPosx() {
            return posx;
        }

        public void setPosx(int posx) {
            this.posx = posx;
        }

        //POS Y
        public int getPosy() {
            return posy;
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

        //COLOR
        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void pintar(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(color);
            BasicStroke gruix = new BasicStroke();
            g2d.drawRect(posx, posy, ample, alçada);
        }

    }

}

public class Ex2 extends JFrame {

    public Ex2() {

        initUI();
    }

    private void initUI() {

        add(new Cuadrat2());

        setTitle("Rectangle");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Cuadrat2 ex = new Cuadrat2();
                ex.setVisible(true);
            }
        });
    }
}
