package sample.Distribuciones;

import java.util.LinkedList;

public class Exponencial{
    LinkedList<Double> X = new LinkedList<>();
    LinkedList<Double> R;
    double lambda;

    public Exponencial(LinkedList<Double>R, double lambda) {
        this.R = R;
        this.lambda = lambda;
    }

    public LinkedList<Double> generar(){
        for (Double qk: R) {
            X.add((-1/lambda) * Math.log(qk));
        }
        return X;
    }
}
