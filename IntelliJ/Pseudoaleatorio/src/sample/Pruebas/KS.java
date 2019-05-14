package sample.Pruebas;

import javafx.scene.control.Alert;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.LinkedList;

public class KS {
    int n;
    LinkedList<Double> l ;
    String H;

    public KS( LinkedList<Double> l) {

        this.l = l;
        pruebaks();
    }

    public void pruebaks(){
        double dplus,dmin,dmax;
        n = l.size();
        double d [] = new double[n];
        double dp[]=new double[n];
        double dm[]=new double[n];

        for (int i = 0; i < n ; i++) {
            d[i] = l.get(i);
        }
        //los ordena la muestra del nas pequeño al mas grande
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(d[i]>d[j])
                {
                    double temp=d[i];
                    d[i]=d[j];
                    d[j]=temp;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            dp[i]=((double)(i+1)/n)-d[i];
        }

        for(int i=0;i<n;i++)
        {
            dm[i]=d[i]-((double)i/n);
        }

        dplus=dp[0];
        dmin=dm[0];
        for(int i=0;i<n;i++)
        {
            if(dp[i]>dplus)
            {
                dplus=dp[i];
            }
        }

        for(int i=1;i<n;i++)
        {
            if(dm[i]>dmin)
            {
                dmin=dm[i];
            }
        }

        System.out.println("D+="+dplus+"\nD-="+dmin);

        double D= Math.max(dplus,dmin);

        System.out.println("D="+D);

        System.out.println("valor critico:");
        double da= 1.36 / Math.sqrt(n);

        if(D>da)
        {
           H = "hipotesis H0 es rechazada";

        }
        else
        {
          H = "hipotesis H0 es aceptada" ;
        }


        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(H);
        a.setTitle("Prueba KS");
        a.setHeaderText("estadistico D: "+ D +"estadistico Da: " + da);
        a.showAndWait();



    }

}
