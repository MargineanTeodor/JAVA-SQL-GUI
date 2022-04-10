package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerOrder implements ActionListener {
    private View view;
    public ControllerOrder(View view){
        this.view=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ViewOrder x= new ViewOrder();
        String []args = new String[0];
        x.main(args);
    }
}
