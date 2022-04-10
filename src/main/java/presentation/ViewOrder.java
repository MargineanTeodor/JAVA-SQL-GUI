package presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ViewOrder extends JPanel {
    private JButton Add;
    private JTextField clientText;
    private JLabel Client;
    private JLabel produs;
    private JTextField produsText;
    private JLabel cantitate;
    private JTextField cantitateText;

    public ViewOrder() {
        Add = new JButton ("Add");
        clientText = new JTextField (5);
        Client = new JLabel ("Client");
        produs = new JLabel ("produs");
        produsText = new JTextField (5);
        cantitate = new JLabel ("cantitate");
        cantitateText = new JTextField (5);
        setPreferredSize (new Dimension (573, 175));
        setLayout (null);
        add (Add);
        add (clientText);
        add (Client);
        add (produs);
        add (produsText);
        ControllerOrderGenerare x =new ControllerOrderGenerare(this);
        Add.addActionListener(x);
        add (cantitate);
        add (cantitateText);
        Add.setBounds (45, 35, 100, 40);
        clientText.setBounds (205, 15, 100, 25);
        Client.setBounds (325, 10, 75, 30);
        produs.setBounds (325, 45, 100, 25);
        produsText.setBounds (205, 45, 100, 25);
        cantitate.setBounds (320, 80, 100, 25);
        cantitateText.setBounds (205, 80, 100, 25);
    }

    public JTextField getClientText() {
        return clientText;
    }

    public void setClientText(JTextField clientText) {
        this.clientText = clientText;
    }

    public JTextField getProdusText() {
        return produsText;
    }

    public void setProdusText(JTextField produsText) {
        this.produsText = produsText;
    }

    public JTextField getCantitateText() {
        return cantitateText;
    }

    public void setCantitateText(JTextField cantitateText) {
        this.cantitateText = cantitateText;
    }

    public void main (String[] args) {
        JFrame frame = new JFrame ("Order");
        frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add (new ViewOrder());
        frame.pack();
        frame.setVisible (true);
    }
}