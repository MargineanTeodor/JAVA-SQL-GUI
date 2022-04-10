package presentation;

import bll.validators.Validator;
import dao.ClientDAO;
import dao.ProductDAO;
import model.Client;
import model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ControllerProductInsert implements ActionListener {
    private ViewProduct view;
    public ControllerProductInsert(ViewProduct view){
        this.view=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id=parseInt(view.getIdtext().getText());
        Product x3 =new Product(id,"dummy",20);
        Validator<Client>[] validators = new Validator[0];
        ProductDAO x= new ProductDAO();
        x.insert(x3);
    }
}
