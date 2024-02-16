package controller;

import model.MMat;
import view.IMat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CMat implements ActionListener {
   private MMat modelo;
   private IMat vista;


    public CMat(MMat modelo, IMat vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(IMat.CALCULATE)){
            vista.setAnswer(modelo.calcular(vista.getA(),vista.getB(), vista.getOperation()));
        }
    }
}
