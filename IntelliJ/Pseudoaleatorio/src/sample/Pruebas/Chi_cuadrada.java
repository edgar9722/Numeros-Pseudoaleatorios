package sample.Pruebas;
import sample.Modelos.TablaChi2;

import javax.swing.*;
import java.util.LinkedList;

public class Chi_cuadrada {
    TablaChi2 tablaChi2 = new TablaChi2();

    public void disUniforme(LinkedList<Double> numeros) {
        double Fosub1 = 0, Fosub2 = 0, Fosub3 = 0, Fosub4 = 0, Fosub5 = 0;
        double alfa = 0.05, max = 0.0;
        for (int i = 0; i < numeros.size(); i++) {
            if (max < numeros.get(i)) {
                max = numeros.get(i);
            }
        }
        double intervalo = max / 5;
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) >= 0 && numeros.get(i) <= intervalo) {
                Fosub1++;
            } else if (numeros.get(i) >= intervalo && numeros.get(i) <= intervalo * 2) {
                Fosub2++;
            } else if (numeros.get(i) >= intervalo * 2 && numeros.get(i) <= intervalo * 3) {
                Fosub3++;
            } else if (numeros.get(i) >= intervalo * 3 && numeros.get(i) <= intervalo * 4) {
                Fosub4++;
            } else if (numeros.get(i) >= intervalo * 4 && numeros.get(i) <= intervalo * 5) {
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
            JOptionPane.showMessageDialog(null, "Prueba de Chi-Cuadrada -Ho : Implica que las varibles se ajustan a una distribución uniforme\n"
                    + SumX + " menor a " + x0a);
        } else
            JOptionPane.showMessageDialog(null, "Prueba de Chi-Cuadrada -Ha : Implica que las varibles se no ajustan a una distribución uniforme\n"
                    + SumX + " menor a " + x0a);
    }

    public void disPoisson(LinkedList<Double> numeros) {
        double alfa = 0.05;
        double max = 0.0;
        double Fosub1 = 0, Fosub2 = 0, Fosub3 = 0, Fosub4 = 0, Fosub5 = 0;
        for (int i = 0; i < numeros.size(); i++) {
            if (max < numeros.get(i)) {
                max = numeros.get(i);
            }
        }
        double intervalo = max / 5;
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) >= 0 && numeros.get(i) <= intervalo) {
                Fosub1++;
            } else if (numeros.get(i) >= intervalo && numeros.get(i) <= intervalo * 2) {
                Fosub2++;
            } else if (numeros.get(i) >= intervalo * 2 && numeros.get(i) <= intervalo * 3) {
                Fosub3++;
            } else if (numeros.get(i) >= intervalo * 3 && numeros.get(i) <= intervalo * 4) {
                Fosub4++;
            } else if (numeros.get(i) >= intervalo * 4 && numeros.get(i) <= intervalo * 5) {
                Fosub5++;
            }
        }
        double totalsub = Fosub1 + Fosub2 + Fosub3 + Fosub4 + Fosub5;
        double sumU = ((intervalo * Fosub1) + ((intervalo * 2) * Fosub2) + ((intervalo * 3) * Fosub3) + ((intervalo * 4) * Fosub4) + ((intervalo * 5) * Fosub5));
        double mU = sumU / totalsub;

        double poisson1 = Math.pow(2.71828, (-1*mU)) * Math.pow(mU, intervalo) / factorial(intervalo);
        double poisson2 = Math.pow(2.71828, (-1*mU)) * Math.pow(mU, intervalo * 2) / factorial((intervalo * 2));
        double poisson3 = Math.pow(2.71828, (-1*mU)) * Math.pow(mU, intervalo * 3) / factorial((intervalo * 3));
        double poisson4 = Math.pow(2.71828,(-1*mU)) * Math.pow(mU, intervalo * 4) / factorial((intervalo * 4));
        double poisson5 = Math.pow(2.71828, (-1*mU)) * Math.pow(mU, intervalo * 5) / factorial((intervalo * 5));

        double Fe1 = totalsub * poisson1;
        double Fe2 = totalsub * poisson2;
        double Fe3 = totalsub * poisson3;
        double Fe4 = totalsub * poisson4;
        double Fe5 = totalsub * poisson5;

        double Chi2a = Math.pow((Fosub1 - Fe1), 2) / Fe1;
        double Chi2b = Math.pow((Fosub2 - Fe2), 2) / Fe2;
        double Chi2c = Math.pow((Fosub3 - Fe3), 2) / Fe3;
        double Chi2d = Math.pow((Fosub4 - Fe4), 2) / Fe4;
        double Chi2e = Math.pow((Fosub5 - Fe5), 2) / Fe5;

        double SumChi = Chi2a + Chi2b + Chi2c + Chi2d + Chi2e;
        double x0a = tablaChi2.getchi2().ObtenerChi(alfa, 4);

        if (SumChi < x0a) {
            JOptionPane.showMessageDialog(null, "Prueba de Chi-Cuadrada -Ho : Implica que las varibles se ajustan a una distribución Poisson\n"
                    + SumChi + " menor a " + x0a);
        } else
            JOptionPane.showMessageDialog(null, "Prueba de Chi-Cuadrada -Ha : Implica que las varibles se no ajustan a una distribución Poisson\n"
                    + SumChi + " mayor a " + x0a);
    }

        public double factorial ( double n){
            double fact = 1;
            for (int i = 2; i <= n; i++) {
                fact *= i;
            }
    return fact;
    }
}