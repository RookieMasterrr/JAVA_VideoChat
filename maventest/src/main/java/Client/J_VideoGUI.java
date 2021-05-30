package Client;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;

public class J_VideoGUI {
    public static JLabel jLabel;
    public J_VideoGUI(){
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(3);
        jFrame.setVisible(true);
        jFrame.setSize(400,400);
        jFrame.setAlwaysOnTop(true);
        Container container = jFrame.getContentPane();
        jLabel = new JLabel();
        container.add(jLabel);
    }
}
