package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class menuAleatoriasController implements Initializable {
    @FXML JFXButton btnRegresar;
    @FXML JFXButton btnCerrar;
    @FXML JFXButton btnArchivos;
    @FXML JFXButton btnManualmente;

    Main main=new Main();
    LinkedList<Double> numeros=new LinkedList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnRegresar.setOnAction(event -> {
            main.primaryStage.show();
            ((Stage) (((Button) event.getSource()).getScene().getWindow())).hide();
        });
        btnCerrar.setOnAction(event -> {
            System.exit(0);
        });
        btnArchivos.setOnAction(event -> {
            ArchivoController archivoController=new ArchivoController();
            main.abrirEscena(event, "Archivo.fxml", archivoController, "Leer Archivo");
        });
        btnManualmente.setOnAction(event -> {
            manualController manualController=new manualController();
            main.abrirEscena(event,"manual.fxml",manualController,"Insertar numeros pseudoaleatorios");
        });
    }
}
