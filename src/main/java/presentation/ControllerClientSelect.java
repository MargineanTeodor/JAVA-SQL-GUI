package presentation;

import dao.ClientDAO;
import model.Client;
import model.Order;
import reflection.reflection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class ControllerClientSelect implements ActionListener {
    private ViewClient view;
    public ControllerClientSelect(ViewClient view){
        this.view=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClientDAO x= new ClientDAO();
        String [][]a=new String[20][7];
        String []a2;
        int n=parseInt(view.getIdtext().getText());
        for(int i=0;i<=n;i++)
        {
            a2=x.afisare(i+1);
            a[i]=a2;
        }
        reflection x6 = new reflection();
        Client x2 = new Client(1,"1","1","1@gmail.com",23);
        ArrayList<String> a3=(ArrayList)x6.retrieveheader(x2);
        String columnName[]= new String[5];
        int i=0;
        for(String s3: a3)
        {
            columnName[i]=s3;
            i++;
        }
        ViewTabel xx = new ViewTabel(a,columnName);
        xx.main(a,columnName);


    }
}
