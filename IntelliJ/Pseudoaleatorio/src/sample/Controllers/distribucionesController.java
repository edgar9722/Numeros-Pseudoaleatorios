package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Distribuciones.Exponencial;
import sample.Distribuciones.TriangularInversa;
import sample.Distribuciones.Uniforme;
import sample.Main;
import sample.Modelos.NumePseudoaleatorios;
import sample.Pruebas.Chi_cuadrada;
import sample.Pruebas.KS;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class distribucionesController implements Initializable {
    @FXML JFXButton btnRegresar; @FXML JFXButton btnCerrar;     @FXML JFXButton btnExponencial;
    @FXML JFXButton btnUniforme; @FXML JFXButton btnTriangular; @FXML JFXButton btnAceptacion;
    @FXML JFXRadioButton rdTransformada; @FXML JFXRadioButton rdComposicion;
    @FXML JFXButton btnGenerarU;
    @FXML JFXButton btnGenerarE, btnGenerarTT;
    @FXML JFXTextField textA;
    @FXML JFXTextField textB;
    @FXML JFXTextField lblA, lblB, lblC;
    @FXML JFXTextField lblLambda;
    @FXML Label lblInversa;
    @FXML TableView<NumePseudoaleatorios> tbNumerosX;
    @FXML TableColumn clmX;

    Main main=new Main();
    Uniforme uniforme;
    Chi_cuadrada chi_cuadrada=new Chi_cuadrada();
    KS ks = null;

    LinkedList<Double> numeros;
    ObservableList<NumePseudoaleatorios> x= FXCollections.observableArrayList();
    String clase;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciar();
        clmX.setCellValueFactory(new PropertyValueFactory<NumePseudoaleatorios, Double>("numeroPseudoaleatorio"));

        btnRegresar.setOnAction(event -> {
            if (clase.equals("Archivo")){
                ArchivoController archivoController=new ArchivoController();
                main.abrirEscena(event, "Archivo.fxml", archivoController, "Leer Archivo");
            }else{
                manualController manualController=new manualController();
                main.abrirEscena(event, "manual.fxml", manualController, "Leer Manualmente");
            }
        });

        btnCerrar.setOnAction(event -> {
            System.exit(0);
        });

        btnExponencial.setOnAction(event -> {
            iniciar();
            rdTransformada.setVisible(false);
            rdComposicion.setVisible(false);
            btnGenerarE.setVisible(true);
            lblLambda.setVisible(true);
        });

        rdTransformada.setOnAction(event -> {
            lblA.setVisible(true);
            lblB.setVisible(true);
            lblC.setVisible(true);
            btnGenerarTT.setVisible(true);
        });

        rdComposicion.setOnAction(event -> {
            lblA.setVisible(false);
            lblB.setVisible(false);
            lblC.setVisible(false);
            btnGenerarTT.setVisible(false);
        });

        btnUniforme.setOnAction(event -> {
            iniciar();
            rdTransformada.setVisible(false);
            rdComposicion.setVisible(false);
            textB.setVisible(true);
            textA.setVisible(true);
            btnGenerarU.setVisible(true);
            lblInversa.setVisible(true);
        });
        btnTriangular.setOnAction(event -> {
            iniciar();
            rdTransformada.setVisible(true);
            rdComposicion.setVisible(true);
        });
        btnAceptacion.setOnAction(event -> {
            iniciar();
            rdTransformada.setVisible(false);
            rdComposicion.setVisible(false);
        });
        btnGenerarU.setOnAction(event -> {
            if (textA.getText().equals("")&&textB.getText().equals("")){
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Alerta");
                a.setTitle("Alerta");
                a.setHeaderText("¡Debe de proporcionar LAMBDA!");
                a.showAndWait();
            }else {
                uniforme = new Uniforme(Integer.parseInt(textA.getText()), Integer.parseInt(textB.getText()), numeros);
                LinkedList<Double> num = uniforme.generar();
                int size=x.size();
                if (size!=0){
                    for (int i = size-1; i >= 0; i--) {
                        x.remove(i);
                    }
                }
                size=tbNumerosX.getItems().size();
                if (size!=0){
                    for (int i = size-1; i >= 0; i--) {
                        tbNumerosX.getItems().remove(i);
                    }
                }
                for (int i = 0; i < num.size(); i++) {
                    x.add(new NumePseudoaleatorios(num.get(i)));
                }
                tbNumerosX.setItems(x);
                chi_cuadrada.disUniforme(num);
            }
        });

        btnGenerarE.setOnAction(event -> {
            if (lblLambda.getText().equals("")){
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Alerta");
                a.setTitle("Alerta");
                a.setHeaderText("¡Debe de proporcionar LAMBDA!");
                a.showAndWait();
            }else {
                Exponencial exponencial = new Exponencial(numeros, Double.parseDouble(lblLambda.getText()));
                LinkedList<Double> num = exponencial.generar();
                int size=x.size();
                if (size!=0){
                    for (int i = size-1; i >= 0; i--) {
                        x.remove(i);
                    }
                }
                size=tbNumerosX.getItems().size();
                if (size!=0){
                    for (int i = size-1; i >= 0; i--) {
                        tbNumerosX.getItems().remove(i);
                    }
                }
                for (int i = 0; i < num.size(); i++) {
                    x.add(new NumePseudoaleatorios(num.get(i)));
                }
                tbNumerosX.setItems(x);
                ks=new KS(num);
            }
        });

        btnGenerarTT.setOnAction(event -> {
            if (rdTransformada.isSelected()) {
                TriangularInversa triangularInversa = new TriangularInversa(Double.parseDouble(lblA.getText()), Double.parseDouble(lblB.getText()), Double.parseDouble(lblC.getText()), numeros);
                LinkedList<Double> num = triangularInversa.transformadaInversa();
                int size=x.size();
                if (size!=0){
                    for (int i = size-1; i >= 0; i--) {
                        x.remove(i);
                    }
                }
                size=tbNumerosX.getItems().size();
                if (size!=0){
                    for (int i = size-1; i >= 0; i--) {
                        tbNumerosX.getItems().remove(i);
                    }
                }
                for (int i = 0; i < num.size(); i++) {
                    x.add(new NumePseudoaleatorios(num.get(i)));
                }
                tbNumerosX.setItems(x);
                ks=new KS(num);
            }else{

            }

        });

    }

    public void iniciar(){
        rdComposicion.setSelected(false);
        rdTransformada.setSelected(false);
        lblA.setVisible(false);
        lblB.setVisible(false);
        lblC.setVisible(false);
        btnGenerarTT.setVisible(false);
        rdComposicion.setVisible(false);
        rdTransformada.setVisible(false);
        textA.setVisible(false);
        textB.setVisible(false);
        btnGenerarU.setVisible(false);
        lblInversa.setVisible(false);
        btnGenerarE.setVisible(false);
        lblLambda.setVisible(false);
    }

    public distribucionesController(LinkedList<Double> numeros, String clase) {
        this.numeros = numeros;
        this.clase = clase;
    }
}