package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerClient implements ActionListener {
    private View view;
    public ControllerClient(View view){
        this.view=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ViewClient x= new ViewClient();
        String []args = new String[0];
        x.main(args);
    }
}
