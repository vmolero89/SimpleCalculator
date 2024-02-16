package model;

public class MMat {
    public double calcular (double numA, double numB, char op){
        double resp = 0.0;
        if (op=='+'){
            resp = numA+numB;
        } else if (op == '-') {
            resp = numA-numB;
        } else if (op == '*') {
            resp = numA*numB;
        } else{
            resp = numA/numB;
        }
        return resp;
    }
}
