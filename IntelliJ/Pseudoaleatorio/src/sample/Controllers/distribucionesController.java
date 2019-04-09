package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Distribuciones.Uniforme;
import sample.Main;
import sample.Modelos.NumePseudoaleatorios;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class distribucionesController implements Initializable {
    @FXML JFXButton btnRegresar; @FXML JFXButton btnCerrar;     @FXML JFXButton btnExponencial;
    @FXML JFXButton btnUniforme; @FXML JFXButton btnTriangular; @FXML JFXButton btnGamma;
    @FXML JFXRadioButton rdTransformada; @FXML JFXRadioButton rdComposicion;
    @FXML JFXButton btnGenerarU;
    @FXML JFXTextField textA;
    @FXML JFXTextField textB;
    @FXML Label lblInversa;
    @FXML TableView<NumePseudoaleatorios> tbNumerosX;
    @FXML TableColumn clmX;

    Main main=new Main();
    Uniforme uniforme;

    LinkedList<Double> numeros;
    ObservableList<NumePseudoaleatorios> x= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciar();
        clmX.setCellValueFactory(new PropertyValueFactory<NumePseudoaleatorios, Double>("numeroPseudoaleatorio"));
        btnRegresar.setOnAction(event -> {
            if (numeros.size()!=0){
                menuAleatoriasController menuAleatoriasController = new menuAleatoriasController();
                menuAleatoriasController.setNumeros(numeros);
                main.abrirEscena(event, "menuAleatorias.fxml", menuAleatoriasController, "Menu Aleatorias");
            }else {
                menuAleatoriasController menuAleatoriasController = new menuAleatoriasController();
                main.abrirEscena(event, "menuAleatorias.fxml", menuAleatoriasController, "Menu Aleatorias");
            }
        });
        btnCerrar.setOnAction(event -> {
            System.exit(0);
        });

        btnExponencial.setOnAction(event -> {
            iniciar();
            rdTransformada.setVisible(false);
            rdComposicion.setVisible(false);
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
        btnGamma.setOnAction(event -> {
            iniciar();
            rdTransformada.setVisible(false);
            rdComposicion.setVisible(false);
        });
        btnGenerarU.setOnAction(event -> {
            Uniforme uniforme = new Uniforme(Integer.parseInt(textA.getText()),Integer.parseInt(textB.getText()),numeros);
            numeros=uniforme.generar();
            for (int i = 0; i < numeros.size(); i++) {
                x.add(new NumePseudoaleatorios(numeros.get(i)));
            }
            tbNumerosX.setItems(x);
        });
    }

    public void iniciar(){
        rdComposicion.setVisible(false);
        rdTransformada.setVisible(false);
        textA.setVisible(false);
        textB.setVisible(false);
        btnGenerarU.setVisible(false);
        lblInversa.setVisible(false);
    }

    public distribucionesController(LinkedList<Double> numeros) {
        this.numeros = numeros;
    }
}
