package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.Main;
import sample.Modelos.NumePseudoaleatorios;
import sample.Modelos.Pruebas;

import java.net.URL;
import java.util.ResourceBundle;

public class ventanaPruebasController implements Initializable {
    @FXML JFXButton btnPromedios;       @FXML JFXButton btnChiCuadrada; @FXML JFXButton btnKolmogorov;
    @FXML JFXButton btnAutocorrelacion; @FXML JFXButton btnHuecos;      @FXML JFXButton btnCorridas;
    @FXML JFXButton btnPoker;

    @FXML JFXButton btnRegresar; @FXML JFXButton btnCerrar;

    ventanaModelosController ventanaModelosController=new ventanaModelosController();
    Pruebas p=new Pruebas();
    Main main=new Main();

    ObservableList<NumePseudoaleatorios> numeros= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnRegresar.setOnAction(event -> {
            Controller controller=new Controller();
            main.abrirEscena(event,"sample.fxml", controller,"Menu numeros pseudoaleatorios");
        });
        btnCerrar.setOnAction(event -> {
            System.exit(0);
        });
        btnPromedios.setOnAction(event -> {
            p.pruebaPromedios(numeros);
        });
        btnChiCuadrada.setOnAction(event -> {
            p.pruebaChiCuadrada(numeros);
        });
        btnKolmogorov.setOnAction(event -> {
            p.pruebaKolmogorov(numeros);
        });
        btnHuecos.setOnAction(event -> {
            p.pruebaHuecos(numeros,3);
        });
        btnCorridas.setOnAction(event -> {
            p.pruebaCorridas(numeros);
        });
        btnPoker.setOnAction(event -> {
            p.pruebaPoker(numeros);
        });
        btnAutocorrelacion.setOnAction(event -> {
            p.pruebaAutocorrelacion(numeros);
        });
    }

    public void setNumeros(ObservableList<NumePseudoaleatorios> numeros){
        this.numeros=numeros;
    }
}
