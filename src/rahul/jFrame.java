package rahul;

import javax.swing.*;
import java.awt.*;

public class jFrame{
    public static void main(String[] args) {
        ImageIcon image = new ImageIcon("");

        JLabel label = new JLabel();
        label.setText(" you");
        label.setIcon(image);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(420, 420);
        frame.setTitle("Hello");
        frame.getContentPane().setBackground(new Color(23, 196, 133));
        frame.add(label);
        frame.setIconImage(image.getImage());

    }
}
