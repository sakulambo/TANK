
package GameWithBullet;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * @author Joshua-OC
 */
public class MovingSpriteEx extends JFrame {

    public MovingSpriteEx() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setSize(800, 600);
        setResizable(false);
        
        setTitle("Tank Attack!");
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