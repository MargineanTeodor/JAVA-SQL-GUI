package presentation;

import dao.OrderDAO;
import model.Order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ControllerOrderGenerare implements ActionListener {
    private ViewOrder view;
    private int nrordine;
    public ControllerOrderGenerare(ViewOrder view){
        this.view=view;
        this.nrordine=0;
    }

    public int getNrordine() {
        return nrordine;
    }

    public void setNrordine(int nrordine) {
        this.nrordine = nrordine;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int cln=parseInt(view.getClientText().getText());
        int produs=parseInt(view.getProdusText().getText());
        int cantitate= parseInt(view.getCantitateText().getText());
        OrderDAO x =new OrderDAO();
        Order x2 =new Order(produs,this.getNrordine(),cln,cantitate);
        this.setNrordine(1+getNrordine());
        x.insert(x2,this.getNrordine());
    }
}
