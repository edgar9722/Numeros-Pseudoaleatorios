package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class menuPrincipalController implements Initializable {
    @FXML JFXButton btnpseudoaleatorios; @FXML JFXButton btnaleatorias; @FXML JFXButton btnCerrar;

    Main main=new Main();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnCerrar.setOnAction(event -> {
            System.exit(0);
        });
        btnpseudoaleatorios.setOnAction(event -> {
            Controller controller=new Controller();
            main.abrirEscena(event,"sample.fxml", controller,"Menu numeros pseudoaleatorios");
        });
        btnaleatorias.setOnAction(event -> {
            menuAleatoriasController menuAleatoriasController=new menuAleatoriasController();
            main.abrirEscena(event,"menuAleatorias.fxml",menuAleatoriasController, "Menu variables aleatorias");
        });
    }
}
