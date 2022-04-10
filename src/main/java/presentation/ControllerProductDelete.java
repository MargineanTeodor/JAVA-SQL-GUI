package presentation;

import dao.ClientDAO;
import dao.ProductDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ControllerProductDelete implements ActionListener {
    private ViewProduct view;
    public ControllerProductDelete(ViewProduct view){
        this.view=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id=parseInt(view.getIdtext().getText());
        ProductDAO x= new ProductDAO();
        x.delete(id);
    }
}
