/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figures;

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
class Cuadrat extends JPanel {

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
        g2d.setPaint(new Color(250, 250, 250));
        g2d.fillRect(120, 20, 100, 100);
        g2d.setPaint(new Color(0, 0, 0));
        g2d.fillOval(260, 20, 50, 50);
        g2d.setPaint(new Color(140, 0,140 ));
        g2d.fillOval(350, 20, 100, 100);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class Ex1 extends JFrame {

    public Ex1() {

        initUI();
    }

    private void initUI() {

        add(new Cuadrat());

        setTitle("Exercici 1");
        setSize(550, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Ex1 ex = new Ex1();
                ex.setVisible(true);
            }
        });
    }
}
