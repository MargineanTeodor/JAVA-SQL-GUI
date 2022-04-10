package presentation;

import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ControllerClientInsert implements ActionListener {
    private ViewClient view;
    public ControllerClientInsert(ViewClient view){
        this.view=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id=parseInt(view.getIdtext().getText());

        Client x3 =new Client(id, "dummy","dummy","dumy@gmail.com",20);
        Validator<Client>[] validators = new Validator[0];
        for (Validator<Client> v : validators) {
            v.validate(x3);
        }
        ClientDAO x= new ClientDAO();
        x.insert(x3);
    }
}
