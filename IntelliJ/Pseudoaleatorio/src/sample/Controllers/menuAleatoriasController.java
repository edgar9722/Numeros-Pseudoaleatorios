package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class menuAleatoriasController implements Initializable {
    @FXML JFXButton btnRegresar;
    @FXML JFXButton btnCerrar;


    Main main=new Main();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnRegresar.setOnAction(event -> {
            main.primaryStage.show();
            ((Stage) (((Button) event.getSource()).getScene().getWindow())).hide();
        });
        btnCerrar.setOnAction(event -> {
            System.exit(0);
        });

    }
}
