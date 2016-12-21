package Figures.Tools;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class SwingTimer extends JFrame {

    public SwingTimer() {
        
        initUI();
    }
    
    private void initUI() {

        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("Cercle rebota");
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new SwingTimer();
                ex.setVisible(true);                
            }
        });
    }
}