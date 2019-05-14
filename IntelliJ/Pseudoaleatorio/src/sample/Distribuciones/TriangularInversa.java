package sample.Distribuciones;

import java.util.LinkedList;

public class TriangularInversa {
    double a, b, c;
    LinkedList<Double> X = new LinkedList<>();
    LinkedList<Double> R;

    public TriangularInversa(double a, double b, double c, LinkedList<Double> r) {
        this.a = a;
        this.b = b;
        this.c = c;
        R = r;
    }

    public LinkedList<Double> transformadaInversa() {
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
       return  X;
    }
}
