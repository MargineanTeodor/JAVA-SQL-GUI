package presentation;

import dao.ClientDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ControllerClientUpdate implements ActionListener {
    private ViewClient view;
    public ControllerClientUpdate(ViewClient view){
        this.view=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id=parseInt(view.getIdtext().getText());
        String val=view.getElemText().getText();
        ClientDAO x= new ClientDAO();
        x.update(id,Integer.parseInt(val));
    }
}
