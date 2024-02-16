package main;

import controller.CMat;
import model.MMat;
import view.IMat;
import view.VMat;

public class Main {

    public static void main(String[] args) {

        MMat modelo = new MMat();
        IMat vista = new VMat();

        CMat controlador = new CMat(modelo,vista);
        vista.setController(controlador);
        vista.onStart();
    }
}
