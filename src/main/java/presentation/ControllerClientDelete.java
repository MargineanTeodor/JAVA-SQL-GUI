package presentation;

import dao.ClientDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ControllerClientDelete implements ActionListener {
    private ViewClient view;
    public ControllerClientDelete(ViewClient view){
        this.view=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id=parseInt(view.getIdtext().getText());
        ClientDAO x= new ClientDAO();
        x.delete(id);
    }
}
