package sample.Modelos;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.util.Arrays;

public class Pruebas {
    TablaChi2 chi2= new TablaChi2();
    
    public Pruebas(){
        
    }
    
    public void pruebaPromedios(ObservableList<NumePseudoaleatorios> numeros){
        double mediaHipotesis = 0.5, sumatoria = 0, Za = 1.96;
        double media,Zo,varianza;
        varianza=Math.sqrt((double)1/12);
        for(int i = 0; i < numeros.size(); i++){
            sumatoria = sumatoria + numeros.get(i).getNumeroPseudoaleatorio();
	}
	media = sumatoria / numeros.size();
	Zo = (media - mediaHipotesis)*Math.sqrt(numeros.size())/varianza;
        
	if(Zo < Za){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Prueba de Promedios: Se acepta la hipotesis de que estos numeros tienen una media de 0.5");
        a.setTitle("Se Acepta");
        a.setHeaderText("Se acepta la hipotesis");
        a.showAndWait();
	}else{
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Prueba de Promedios: Se rechaza la hipotesis de que estos numeros tienen una media de 0.5");
        a.setTitle("Se Rechaza");
        a.setHeaderText("Se rechaza la hipotesis");
        a.showAndWait();
        }
    }
    
    public void pruebaChiCuadrada(ObservableList<NumePseudoaleatorios> numeros){
        double sub1=0,sub2=0,sub3=0,sub4=0,sub5=0;
        double alfa=0.05;
        for(int i = 0; i < numeros.size(); i++){
            double mult = numeros.get(i).getNumeroPseudoaleatorio()*10;
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
        double FE = numeros.size()/5;
        int GradosL = 4;
        double X1 = ((sub1-FE)*(sub1-FE))/FE;
        double X2 = ((sub2-FE)*(sub2-FE))/FE;
        double X3 = ((sub3-FE)*(sub3-FE))/FE;
        double X4 = ((sub4-FE)*(sub4-FE))/FE;
        double X5 = ((sub5-FE)*(sub5-FE))/FE;
        double SumX = X1+X2+X3+X4+X5;
        double x0a=chi2.getchi2().ObtenerChi(alfa,GradosL);
        if(SumX <x0a){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Prueba de Chi-Cuadrada: Se acepta la hipotesis de que estos numeros tiene una distribucion uniforme");
            a.setTitle("Se Acepta");
            a.setHeaderText("Se acepta la hipotesis");
            a.showAndWait();
        }else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Prueba de Chi-Cuadrada: No se acepta la hipotesis de que estos numeros tiene una distribucion uniforme");
            a.setTitle("Se Rechaza");
            a.setHeaderText("Se rechaza la hipotesis");
            a.showAndWait();
        }
    }
    
    public void pruebaKolmogorov(ObservableList<NumePseudoaleatorios> numeros){
        double vect[];
        double D[],d[];
        double Xi=0,j=1;
         double Mayor;
        vect = new double[numeros.size()];
        D = new double[numeros.size()];
        d = new double[numeros.size()];
        for (int i = 0; i < numeros.size(); i++) {
            vect[i] = numeros.get(i).getNumeroPseudoaleatorio();
             
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
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Prueba de Kolmogorov: Se acepta la hipotesis de que los numeros tienen una distribucion uniforme");
            a.setTitle("Se Acepta");
            a.setHeaderText("Se acepta la hipotesis");
            a.showAndWait();
        }else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Prueba de Kolmogorov: Se rechaza la hipotesis de que los numeros tienen una distribucion uniforme");
            a.setTitle("Se Rechaza");
            a.setHeaderText("Se rechaza la hipotesis");
            a.showAndWait();
        }
    }
    
    public void pruebaCorridas(ObservableList<NumePseudoaleatorios> numeros){
        double aux[];
        int  z=0 ;
        double corrida[];
        double valorM,Varianza,Z0,a=0,Za=-1.96,Za1=1.96;
        aux = new double[numeros.size()];
        corrida = new double[numeros.size()-1];
        for (int i = 0; i < numeros.size(); i++) {
            aux[i] = numeros.get(i).getNumeroPseudoaleatorio();
        }
        
        for(int j=0; j< numeros.size()-1;j++){
            for (int k = 1; k < aux.length-1; k++) {
                if(aux[k]>numeros.get(j).getNumeroPseudoaleatorio()){
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
        
        valorM=(2*(numeros.size())-1)/3;
        Varianza = (16*(numeros.size())-29)/90.0;
        Z0= (a - valorM)/Math.sqrt(Varianza);
        if(Za<Z0 && Z0<Za1){
            Alert b = new Alert(Alert.AlertType.INFORMATION);
            b.setContentText("Prueba de Corridas: No se rechaza la hipotesis de independencia de datos");
            b.setTitle("Se Acepta");
            b.setHeaderText("Se acepta la hipotesis");
            b.showAndWait();
        }else{
            Alert b = new Alert(Alert.AlertType.INFORMATION);
            b.setContentText("Prueba de Corridas: Se rechaza la hipotesis de independecia de datos");
            b.setTitle("Se Rechaza");
            b.setHeaderText("Se rechaza la hipotesis");
            b.showAndWait();
        }
    }
    
    public void pruebaHuecos(ObservableList<NumePseudoaleatorios> numeros, int n){
        double p[], foi, fei, a = 0.3, b = 0.7, x02, x0a;
        int cantidad = numeros.size(), FOtotal, ultimo = 0;
        int hueco[];
        hueco = new int[numeros.size()];

        p = new double[n + 1]; //vector de probabilidades
        int aux = 0, sapo = 0;
        for (int j = 0; j < cantidad; j++) {
            if (numeros.get(j).getNumeroPseudoaleatorio() >= a && numeros.get(j).getNumeroPseudoaleatorio() <= b) {
                aux = j;
                ultimo = j;
                sapo = -1;
                do {
                    sapo++;
                    aux++;
                    if (aux >= cantidad - 1) {
                        break;
                    }
                } while (numeros.get(aux).getNumeroPseudoaleatorio() < a || numeros.get(aux).getNumeroPseudoaleatorio() > b);
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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Prueba de huecos: Se acepta la hipotesis");
            alert.setTitle("Se Acepta");
            alert.setHeaderText("Se acepta la hipotesis");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Prueba de huecos: Se rechaza la hipotesis");
            alert.setTitle("Se Rechaza");
            alert.setHeaderText("Se rechaza la hipotesis");
            alert.showAndWait();
        }
    }
    
    public void pruebaPoker(ObservableList<NumePseudoaleatorios> numeros){
        int iguales = 0, diferentes = 0, dosiguales = 0;
        double fe_ig,fe_dif,fe_dosig;
        
        fe_ig=(.01*numeros.size());
        fe_dif=(.72*numeros.size());
        fe_dosig=(.27*numeros.size());
                
        String[] numerosstring = new String[numeros.size()];
        for(int i = 0; i < numeros.size(); i++){
            numerosstring[i] = Double.toString(numeros.get(i).getNumeroPseudoaleatorio());
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
    
    public void pruebaAutocorrelacion(ObservableList<NumePseudoaleatorios> numeros){
        int m = 5, M = 0;
        int cantidad = numeros.size();
        double oP = 0, Pi = 0, Z0, aux, mayor = 0, sumatoria = 0;
        for (int i = 0; i < cantidad; i++) {
            if( (1+(i + 1) * m) <= cantidad){
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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Prueba de Autocorrelacion: Se acepta que estos numeros son independientes");
            alert.setTitle("Se Acepta");
            alert.setHeaderText("Se acepta la hipotesis");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Prueba de Autocorrelacion: Se rechaza que estos numeros son independientes");
            alert.setTitle("Se Acepta");
            alert.setHeaderText("Se rechaza la hipotesis");
            alert.showAndWait();
        }
    }
}