package presentation;

import dao.ClientDAO;
import dao.ProductDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ControllerProductUpdate implements ActionListener {
    private ViewProduct view;
    public ControllerProductUpdate(ViewProduct view){
        this.view=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id=parseInt(view.getIdtext().getText());
        String val=view.getElemText().getText();
        ProductDAO x= new ProductDAO();
        x.update(id,Integer.parseInt(val));
    }
}
