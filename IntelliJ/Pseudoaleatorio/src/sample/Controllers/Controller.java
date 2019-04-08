package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML JFXButton btnNumePseudoaleatorios;
    @FXML JFXButton btnElegModeAyuda;
    @FXML JFXButton btnElegModelo;
    @FXML JFXButton btnRegresar;
    @FXML JFXButton btnCerrar;

    Main m=new Main();
    boolean opcionAyuda=false;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnRegresar.setOnAction(event -> {
            Controller controller=new Controller();
            m.abrirEscena(event,"sample.fxml", controller,"Menu numeros pseudoaleatorios");
        });
        btnCerrar.setOnAction(event -> {
            System.exit(0);
        });

        btnNumePseudoaleatorios.setOnAction(event -> {
            ventanaMixtoController ventanaMixtoController=new ventanaMixtoController();
            m.abrirEscena(event,"ventanaMixto.fxml",ventanaMixtoController, "Mixto");
        });

        btnElegModeAyuda.setOnAction(event ->{
            opcionAyuda=true;
            ventanaModelosController ventanaModelosController=new ventanaModelosController();
            ventanaModelosController.ayuda(opcionAyuda);
            m.abrirEscena(event, "ventanaModelos.fxml", ventanaModelosController, "Modelos");
        });

        btnElegModelo.setOnAction(event -> {
            opcionAyuda=false;
            ventanaModelosController ventanaModelosController=new ventanaModelosController();
            ventanaModelosController.ayuda(opcionAyuda);
            m.abrirEscena(event, "ventanaModelos.fxml", ventanaModelosController, "Modelos");
        });
    }
}
