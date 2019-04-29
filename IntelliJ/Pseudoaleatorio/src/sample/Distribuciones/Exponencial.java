package sample.Distribuciones;

import java.util.LinkedList;

public class Exponencial{
    LinkedList<Double> X = new LinkedList<>();
    LinkedList<Double> R;

    public Exponencial(LinkedList<Double>R) {
        this.R = R;
    }

    public LinkedList<Double> generar(){
        for (Double qk: R) {
            X.add(-1* Math.log(qk));
        }
        return X;
    }
}
