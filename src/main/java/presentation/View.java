package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class View extends JPanel {
    private JButton Client;
    private JButton Product;
    private JButton Order;
    public View() {
        Client = new JButton ("Client");
        Product = new JButton ("Product");
        Order = new JButton ("Order");
        setPreferredSize (new Dimension (569, 251));
        setLayout (null);
        add (Client);
        add (Product);
        add (Order);
        ControllerClient x= new ControllerClient(this);
        ControllerProduct x2= new ControllerProduct(this);
        Product.addActionListener(x2);
        Client.addActionListener(x);
        ControllerOrder x3 = new ControllerOrder(this);
        Order.addActionListener(x3);
        Client.setBounds (60, 90, 125, 70);
        Product.setBounds (225, 90, 115, 70);
        Order.setBounds (380, 90, 120, 70);
    }
    public static void main (String[] args) {
        JFrame frame = new JFrame ("View");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new View());
        frame.pack();
        frame.setVisible (true);
    }
}