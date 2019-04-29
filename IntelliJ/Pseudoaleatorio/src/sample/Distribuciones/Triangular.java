package sample.Distribuciones;

import java.util.LinkedList;

public class Triangular {
    double a, b, c;
    LinkedList<Double> X = new LinkedList<>();
    LinkedList<Double> R;

    public Triangular(double a, double b, double c, LinkedList<Double> r) {
        this.a = a;
        this.b = b;
        this.c = c;
        R = r;
    }

    public LinkedList<Double> transformadaInversa(double a, double b, double c) {
        double F = (c - a) / (b - a);
        for (Double qk : R) {
            if (qk < F) {
                X.add( a + Math.sqrt(qk * (b - a) * (c - a)));
            } else {
                X.add( b - Math.sqrt((1 - qk) * (b - a) * (b - c)));
            }
        }
       return  X;
    }

}
