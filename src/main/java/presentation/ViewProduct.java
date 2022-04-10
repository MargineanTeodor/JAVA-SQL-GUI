package presentation;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;

public class ViewProduct extends JPanel {
    private JButton Add;
    private JTable table;
    private JButton Delete;
    private JButton Edit;
    private JButton Afisare;
    private JTextField idtext;
    private JLabel id;
    private JLabel coloana;
    private JTextField coloanaText;
    private JLabel elem;
    private JTextField elemText;

    public ViewProduct() {
        Add = new JButton ("Add");
        Delete = new JButton ("Delete");
        Edit = new JButton ("Edit");
        Afisare = new JButton ("Afisare");
        idtext = new JTextField (5);
        id = new JLabel ("id");
        coloana = new JLabel ("coloana");
        coloanaText = new JTextField (5);
        elem = new JLabel ("elemDeModificat");
        elemText = new JTextField (5);
        table=new JTable();
        setPreferredSize (new Dimension (573, 517));
        setLayout (null);
        ControllerProductSelect x=new ControllerProductSelect(this);
        Afisare.addActionListener(x);
        ControllerProductInsert x2= new ControllerProductInsert(this);
        Add.addActionListener(x2);
        ControllerProductUpdate x3= new ControllerProductUpdate(this);
        Edit.addActionListener(x3);
        ControllerProductDelete x4= new ControllerProductDelete(this);
        Delete.addActionListener(x4);
        add (Add);
        add (Delete);
        add (Edit);
        add (Afisare);
        add (idtext);
        add (id);
        add (coloana);
        add (coloanaText);
        add (elem);
        add(table);
        add (elemText);
        Add.setBounds (15, 15, 100, 40);
        Delete.setBounds (15, 85, 100, 35);
        Edit.setBounds (15, 55, 100, 35);
        Afisare.setBounds (15, 120, 100, 35);
        idtext.setBounds (140, 15, 100, 25);
        id.setBounds (245, 10, 75, 30);
        coloana.setBounds (245, 40, 100, 25);
        coloanaText.setBounds (140, 45, 100, 25);
        elem.setBounds (245, 75, 100, 25);
        elemText.setBounds (140, 75, 100, 25);
        table.setBounds(15,140,200,100);
    }
    public JTextField getIdtext() {
        return idtext;
    }

    public void setIdtext(JTextField idtext) {
        this.idtext = idtext;
    }

    public JTextField getColoanaText() {
        return coloanaText;
    }

    public void setColoanaText(JTextField coloanaText) {
        this.coloanaText = coloanaText;
    }

    public JTextField getElemText() {
        return elemText;
    }
    public void setElemText(JTextField elemText) {
        this.elemText = elemText;
    }
    public  void main (String[] args) {
        JFrame frame = new JFrame ("Product");
        frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add (new ViewProduct());
        frame.pack();
        frame.setVisible (true);
    }
}
