package presentation;

import javax.swing.*;
import java.awt.*;

public class ViewTabel extends JPanel {
    private JTable x;
    public ViewTabel(String[][]a,String [] b) {
        x=new JTable(a,b);
        setPreferredSize (new Dimension (500, 250));
        setLayout (null);
        add (x);
        x.setBounds(0,0,500,250);
    }
    public  void main (String[][]a,String[]b) {
        JFrame frame = new JFrame ("View");
        frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add (new ViewTabel(a,b));
        frame.pack();
        frame.setVisible (true);
    }
}