package numeros.pseudoaleatorios;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Pruebas {
    TablaChi2 chi2= new TablaChi2();
    
    public Pruebas(){
        
    }
    
    public void pruebaPromedios(double numeros []){
        double mediaHipotesis = 0.5, sumatoria = 0, Za = 1.96;
        double media,Zo,varianza;
        varianza=Math.sqrt((double)1/12);
        for(int i = 0; i < numeros.length; i++){			
            sumatoria = sumatoria + numeros[i];
	}
	media = sumatoria / numeros.length;
	Zo = (media - mediaHipotesis)*Math.sqrt(numeros.length)/varianza;
        
	if(Zo < Za){
            JOptionPane.showMessageDialog(null, "Prueba de Promedios: Se acepta la hipotesis de que estos numeros tienen una media de 0.5");
	}else{
            JOptionPane.showMessageDialog(null, "Prueba de Promedios: Se rechaza la hipotesis de que estos numeros tienen una media de 0.5");
        }
    }
    
    public void pruebaChiCuadrada(double numeros[]){
        double sub1=0,sub2=0,sub3=0,sub4=0,sub5=0;
        double alfa=0.05;
        for(int i = 0; i < numeros.length; i++){
            double mult = numeros[i]*10;
            if(Math.floor(mult)==1 || Math.floor(mult)==0 ){
                 sub1++;
            }else if(Math.floor(mult)==2 || Math.floor(mult)==3 ){
                 sub2++;
            }else if(Math.floor(mult)==4 || Math.floor(mult)==5 ){
                 sub3++;
            }else if(Math.floor(mult)==6 || Math.floor(mult)==7 ){
                sub4++;
            }else if(Math.floor(mult)==8 || Math.floor(mult)==9 ){
                sub5++;
            }
        }
        double FE = numeros.length/5;
        int GradosL = 4;
        double X1 = ((sub1-FE)*(sub1-FE))/FE;
        double X2 = ((sub2-FE)*(sub2-FE))/FE;
        double X3 = ((sub3-FE)*(sub3-FE))/FE;
        double X4 = ((sub4-FE)*(sub4-FE))/FE;
        double X5 = ((sub5-FE)*(sub5-FE))/FE;
        double SumX = X1+X2+X3+X4+X5;
        double x0a=chi2.getchi2().ObtenerChi(alfa,GradosL);
        if(SumX <x0a){
            JOptionPane.showMessageDialog(null, "Prueba de Chi-Cuadrada: Se acepta la hipotesis de que estos numeros tiene una distribucion uniforme");
        }else
            JOptionPane.showMessageDialog(null, "Prueba de Chi-Cuadrada: No se acepta la hipotesis de que estos numeros tiene una distribucion uniforme");
    }
    
    public void pruebaKolmogorov(double numeros[]){
        double vect[];
        double D[],d[];
        double Xi=0,j=1;
         double Mayor;
        vect = new double[numeros.length];
        D = new double[numeros.length];
        d = new double[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            vect[i] = numeros[i];
             
        }
        Arrays.sort(vect);
        for (int i = 0; i < vect.length; i++) {
            
            Xi= vect[i];
            double aux= j/vect.length;
            D[i] = (aux)-Xi;
            d[i] = Xi-((j-1)/vect.length);
            j++;
        }
        
        double mayorD,mayord;
        mayorD=D[0];
        mayord=d[0];
        for(int i=0;i<D.length;i++){
            if(D[i] > mayorD){
                mayorD = D[i];
            }
        }
        for(int i=0;i<d.length;i++){
            if(d[i] > mayord){
                mayord = d[i];
            }
        }
        
        if(mayorD>mayord){
            Mayor = mayorD;
        }else{
            Mayor = mayord;
        }
        double dnHipotesis = 1.36/Math.sqrt(vect.length);
        if(Mayor<=dnHipotesis){
            JOptionPane.showMessageDialog(null, "Prueba de Kolmogorov: Se acepta la hipotesis de que los numeros tienen una distribucion uniforme");
        }else
            JOptionPane.showMessageDialog(null, "Prueba de Kolmogorov: Se rechaza la hipotesis de que los numeros tienen una distribucion uniforme");
        
    }
    
    public void pruebaCorridas(double numeros[]){
        double aux[];
        int  z=0 ;
        double corrida[];
        double valorM,Varianza,Z0,a=0,Za=-1.96,Za1=1.96;
        aux = new double[numeros.length];
        corrida = new double[numeros.length-1];
        for (int i = 0; i < numeros.length; i++) {
            aux[i] = numeros[i];
        }
        
        for(int j=0; j< numeros.length-1;j++){
            for (int k = 1; k < aux.length-1; k++) {
                if(aux[k]>numeros[j]){
                    corrida[z]=1;
                    z++;
                }else{
                    corrida[z]=0;
                    z++;
                }
                j++;
            }
        }
       
        for (int k = 0; k < corrida.length-1; k++) {
            if(corrida[k]!=corrida[k+1]){ 
                a++;
            }
        }
        
       valorM=(2*(numeros.length)-1)/3;
       Varianza = (16*(numeros.length)-29)/90.0;
       Z0= (a - valorM)/Math.sqrt(Varianza);
       if(Za<Z0 && Z0<Za1){
           JOptionPane.showMessageDialog(null, "Prueba de Corridas: No se rechaza la hipotesis de independencia de datos");
        }else{
            JOptionPane.showMessageDialog(null, "Prueba de Corridas: Se rechaza la hipotesis de independecia de datos");
       }
}
    
    public void pruebaHuecos(double numeros[], int n){
        double p[], foi, fei, a = 0.3, b = 0.7, x02, x0a;
        int cantidad = numeros.length, FOtotal, ultimo = 0;
        int hueco[];
        hueco = new int[numeros.length];

        p = new double[n + 1]; //vector de probabilidades
        int aux = 0, sapo = 0;
        for (int j = 0; j < cantidad; j++) {
            if (numeros[j] >= a && numeros[j] <= b) {
                aux = j;
                ultimo = j;
                sapo = -1;
                do {
                    sapo++;
                    aux++;
                    if (aux >= cantidad - 1) {
                        break;
                    }
                } while (numeros[aux] < a || numeros[aux] > b);
                if (sapo >= n) {
                    sapo = n;
                }
                hueco[sapo]++;
            }

        }
        if (ultimo != cantidad - 1) {
            hueco[cantidad - 1 - ultimo]++;
        }
        FOtotal = 0;
        for (int i = 0; i <= n; i++) {
            FOtotal += hueco[i];
            p[i] = (b - a) * Math.pow((1 - (b - a)), i);
        }
        p[n] = Math.pow((1 - (b - a)), n);
        x02 = 0;
        for (int i = 0; i <= n; i++) {
            fei = FOtotal * p[i];
            x02 += (hueco[i] - fei) / fei;
        }

        x0a = chi2.getchi2().ObtenerChi(0.05, n);
        if (x02 < x0a) {
            JOptionPane.showMessageDialog(null, "Prueba de huecos: Se acepta la hipotesis");
        } else {
            JOptionPane.showMessageDialog(null, "Prueba de huecos: Se rechaza la hipotesis");
        }
    }
    
    public void pruebaPoker(double numeros[]){
        int iguales = 0, diferentes = 0, dosiguales = 0;
        double fe_ig,fe_dif,fe_dosig;
        
        fe_ig=(.01*numeros.length);
        fe_dif=(.72*numeros.length);
        fe_dosig=(.27*numeros.length);
                
        String[] numerosstring = new String[numeros.length];
        for(int i = 0; i < numeros.length; i++){
            numerosstring[i] = Double.toString(numeros[i]); 
            char ch1 = numerosstring[i].charAt(1);
            char ch2 = numerosstring[i].charAt(2);
            char ch3 = numerosstring[i].charAt(3);
            if(ch1 == ch2 && ch1 != ch3){
                dosiguales = dosiguales+1;
            }
            if (ch1 != ch2 && ch1 != ch3){
                diferentes = diferentes + 1;
            }else{
                iguales = iguales + 1;
            }
        }
    }
    
    public void pruebaAutocorrelacion(double numeros[]){
        int m = 5, M = 0;
        int cantidad = numeros.length;
        double oP = 0, Pi = 0, Z0, aux, mayor = 0, sumatoria = 0;
        for (int i = 0; i < numeros.length; i++) {
            if( (1+(i + 1) * m) <= numeros.length){
                M = i;
            }
           mayor = (double)M;
        }    
        oP = (double)(Math.sqrt((13 * mayor) + 7))/(12 * (mayor + 1));
        aux = (double)(1 / (mayor + 1));
        for (int j = 0; j < mayor; j++) {
            sumatoria = sumatoria + (double)((1 + j * m) * (1 + (j + 1) * m));
        }
        Pi = (aux * sumatoria - 0.25);
        Z0 = oP / Pi;
        if (-1.96 <= Z0 && Z0 <= 1.96) {
            JOptionPane.showMessageDialog(null, "Prueba de Autocorrelacion: Se acepta que estos numeros son independientes");
        } else {
            JOptionPane.showMessageDialog(null, "Prueba de Autocorrelacion: Se rechaza que estos numeros son independientes");
        }
    }
}