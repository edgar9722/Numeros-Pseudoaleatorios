package sample.Distribuciones;

import java.util.LinkedList;

public class Uniforme {
    int a,b;
    LinkedList<Double> X = new LinkedList<>();

    LinkedList<Double> R;

    public Uniforme(int a, int b, LinkedList<Double>R) {
        this.a = a;
        this.b = b;
        this.R = R;
    }

    public LinkedList<Double> generar(){
        for (Double qk: R) {
            X.add(a+(b-a) * qk);
        }
        return X;
    }
}
