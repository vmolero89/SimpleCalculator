package view;

import controller.CMat;

public interface IMat {
    public static final String CALCULATE = "calculate";

    public double getA();
    public double getB();
    public char getOperation();
    public void setAnswer(double resp);
    public void onStart();
    public void setController(CMat controller);
}
