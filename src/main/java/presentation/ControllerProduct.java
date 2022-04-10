package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerProduct implements ActionListener {
    private View view;
    public ControllerProduct(View view){
        this.view=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ViewProduct x= new ViewProduct();
        String []args = new String[0];
        x.main(args);
    }
}
