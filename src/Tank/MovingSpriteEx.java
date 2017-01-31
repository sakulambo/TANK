/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tank;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class MovingSpriteEx extends JFrame {

    public MovingSpriteEx() {

        initUI();
        
    }

    private void initUI() {

        add(new Board());

        setSize(800, 600);
        setResizable(false);

        setTitle("SURVIVAL TANK!");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                MovingSpriteEx ex = new MovingSpriteEx();
                ex.setVisible(true);
            }
        });
    }
}
