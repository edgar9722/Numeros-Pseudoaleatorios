package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Distribuciones.Uniforme;
import sample.Main;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class distribucionesController implements Initializable {
    @FXML JFXButton btnRegresar; @FXML JFXButton btnCerrar;     @FXML JFXButton btnExponencial;
    @FXML JFXButton btnUniforme; @FXML JFXButton btnTriangular; @FXML JFXButton btnGamma;
    @FXML JFXRadioButton rdTransformada; @FXML JFXRadioButton rdComposicion;
    @FXML JFXTextField textA;
    @FXML JFXTextField textB;

    Main main=new Main();

    LinkedList<Double> numeros;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rdComposicion.setVisible(false);
        rdTransformada.setVisible(false);
        textA.setVisible(false);
        textB.setVisible(false);
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
            rdTransformada.setVisible(false);
            rdComposicion.setVisible(false);
        });
        btnUniforme.setOnAction(event -> {
            rdTransformada.setVisible(false);
            rdComposicion.setVisible(false);
            textB.setVisible(true);
            textA.setVisible(true);
            Uniforme uniforme = new Uniforme(Integer.parseInt(textA.getText()),Integer.parseInt(textB.getText()),numeros);


        });
        btnTriangular.setOnAction(event -> {
            rdTransformada.setVisible(true);
            rdComposicion.setVisible(true);
        });
        btnGamma.setOnAction(event -> {
            rdTransformada.setVisible(false);
            rdComposicion.setVisible(false);
        });
    }

    public distribucionesController(LinkedList<Double> numeros) {
        this.numeros = numeros;
    }
}
