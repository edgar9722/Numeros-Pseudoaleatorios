package sample.Distribuciones;

import java.util.LinkedList;

public class Composicion {
    double a, b, c;
    LinkedList<Double> X = new LinkedList<>();
    LinkedList<Double> R;
    public Composicion(double a, double b, double c, LinkedList<Double> r) {
        this.a = a;
        this.b = b;
        this.c = c;
        R = r;
    }
    public LinkedList<Double> composicion() {
        double d=(b / 2);
        double F = c / d;
        double F2=F*1/2;
        for (Double qk : R) {
            if (a<=qk && qk<=c) {
                X.add( Math.sqrt(qk * 1/F2));
            } else {
                X.add( Math.sqrt(((b*2)+b)-F*qk));
            }
        }
        //Condicion de composicion
        return X;
    }
}
