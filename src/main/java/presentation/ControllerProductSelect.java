package presentation;

import dao.ClientDAO;
import dao.ProductDAO;
import model.Order;
import model.Product;
import reflection.reflection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class ControllerProductSelect implements ActionListener {
    private ViewProduct view;
    public ControllerProductSelect(ViewProduct view){
        this.view=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProductDAO x= new ProductDAO();
        String [][]a=new String[20][7];
        String []a2;
        int n=parseInt(view.getIdtext().getText());
        for(int i=0;i<=n;i++)
        {
            a2=x.afisare(i+1);
            a[i]=a2;
        }
        reflection x6 = new reflection();
        Product x2= new Product(1,"1",1);
        ArrayList<String> a3=(ArrayList)x6.retrieveheader(x2);
        String columnName[]= new String[3];
        int i=0;
        for(String s3: a3)
        {
            columnName[i]=s3;
            i++;
        }
        //String[] columnNames = { "id", "name", "adress","email","age"};
        ViewTabel xx = new ViewTabel(a,columnName);
        xx.main(a,columnName);


    }
}
