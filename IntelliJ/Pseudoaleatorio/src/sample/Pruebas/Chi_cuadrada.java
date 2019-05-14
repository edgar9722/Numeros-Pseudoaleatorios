package sample.Pruebas;
import sample.Modelos.TablaChi2;

import javax.swing.*;
import java.util.LinkedList;

public class Chi_cuadrada {
    public void disUniforme(LinkedList<Double> numeros) {
        TablaChi2 tablaChi2=new TablaChi2();
        double Fosub1 = 0, Fosub2 = 0, Fosub3 = 0, Fosub4 = 0, Fosub5 = 0;
        double alfa = 0.05, max=0.0;
        for (int i = 0; i < numeros.size(); i++) {
            if (max<numeros.get(i)){
                max=numeros.get(i);
            }
        }
        double intervalo=max/5;
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) >= 0 && numeros.get(i) <= intervalo) {
                Fosub1++;
            } else if (numeros.get(i) >= intervalo && numeros.get(i) <= intervalo*2) {
                Fosub2++;
            } else if (numeros.get(i) >= intervalo*2 && numeros.get(i) <= intervalo*3) {
                Fosub3++;
            } else if (numeros.get(i) >= intervalo*3 && numeros.get(i) <= intervalo*4) {
                Fosub4++;
            } else if (numeros.get(i) >= intervalo*4 && numeros.get(i) <= intervalo*5) {
                Fosub5++;
            }
        }
        double totalsub = Fosub1 + Fosub2 + Fosub3 + Fosub4 + Fosub5;
        double Fe = totalsub / 5;

        double X1 = ((Fosub1 - Fe) * (Fosub1 - Fe)) / Fe;
        double X2 = ((Fosub2 - Fe) * (Fosub2 - Fe)) / Fe;
        double X3 = ((Fosub3 - Fe) * (Fosub3 - Fe)) / Fe;
        double X4 = ((Fosub4 - Fe) * (Fosub4 - Fe)) / Fe;
        double X5 = ((Fosub5 - Fe) * (Fosub5 - Fe)) / Fe;

        double SumX = X1 + X2 + X3 + X4 + X5;
        double x0a = tablaChi2.getchi2().ObtenerChi(alfa, 4);

        if (SumX < x0a) {
            JOptionPane.showMessageDialog(null, "Prueba de Chi-Cuadrada -Ho : Implica que las varibles se ajustan a una distribución uniforme\"");
        } else
            JOptionPane.showMessageDialog(null, "Prueba de Chi-Cuadrada -Ha : Implica que las varibles se no ajustan a una distribución uniforme\"");
    }
}