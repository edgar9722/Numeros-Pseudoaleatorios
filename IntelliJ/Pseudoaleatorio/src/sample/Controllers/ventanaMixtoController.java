package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Main;
import sample.Modelos.NumePseudoaleatorios;
import sample.Modelos.Pruebas;
import sample.Modelos.Semilla;

import java.net.URL;
import java.util.ResourceBundle;

public class ventanaMixtoController implements Initializable {
    @FXML JFXButton btnRegresar;     @FXML JFXButton btnCerrar;
    @FXML JFXButton btnGenerar;      @FXML JFXButton btnPruebas;
    @FXML JFXTextField textCantidad;
    @FXML TableView<NumePseudoaleatorios> tbNumePseudoaleatorios;
    @FXML TableColumn clmNumePseudoaleatorios;

    Main main=new Main();
    NumePseudoaleatorios modeloNumeros=null;

    ObservableList<NumePseudoaleatorios> numeros=FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clmNumePseudoaleatorios.setCellValueFactory(new PropertyValueFactory<NumePseudoaleatorios, Double>("numeroPseudoaleatorio"));
        tbNumePseudoaleatorios.setItems(llenarTabla());
        btnRegresar.setOnAction(event -> {
            Controller controller=new Controller();
            main.abrirEscena(event,"sample.fxml", controller,"Menu numeros pseudoaleatorios");
        });
        btnCerrar.setOnAction(event -> {
            System.exit(0);
        });

        btnGenerar.setOnAction(event -> {
            if (!textCantidad.getText().equals("")) {
                if (Integer.parseInt(textCantidad.getText()) > 0) {
                    Semilla.Iniciar();

                    String cadena = "";
                    int semilla = 5;
                    int multiplicador = 81;
                    int modulo = 100;
                    int constante = 89;
                    int cantidad = Integer.parseInt(textCantidad.getText());

                    int copiaSemilla = semilla;

                    for (int i = 0; i < cantidad; i++) {
                        semilla = ((semilla * multiplicador) + constante) % modulo;
                        cadena = semilla + "";
                        semilla = Integer.parseInt(cadena);
                        numeros.add(modeloNumeros = new NumePseudoaleatorios((double) semilla / modulo));

                        if (semilla == copiaSemilla) {
                            Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("la semilla inicial \"" + copiaSemilla + "\" se repite en : " + i);
                            a.setTitle("Informacion");
                            a.setHeaderText("Se repitio");
                            a.showAndWait();
                            break;
                        }
                        if (Semilla.esVacio()) {
                            Semilla.Agregar(cadena);
                        } else {
                            if (!Semilla.siExiste(cadena)) {
                                Semilla.Agregar(cadena);
                            } else {
                                Alert a = new Alert(Alert.AlertType.WARNING);
                                a.setContentText("la semilla inicial se repite en " + i);
                                a.setTitle("Informacion");
                                a.setHeaderText("Se repitio");
                                a.showAndWait();
                                break;
                            }
                        }
                    }
                    tbNumePseudoaleatorios.setItems(numeros);
                } else
                    if (Integer.parseInt(textCantidad.getText()) <= 0){
                        Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setContentText("Verificar dato");
                        a.setTitle("Atencion");
                        a.setHeaderText("Favor de verificar");
                        a.showAndWait();
                    }
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("No debes de dejar algun campo vacio");
                a.setTitle("Error");
                a.setHeaderText("Error");
                a.showAndWait();
            }
        });

        btnPruebas.setOnAction(event -> {
            if (!textCantidad.getText().equals("")) {
                Pruebas p = new Pruebas();
                p.pruebaPromedios(numeros);
                p.pruebaChiCuadrada(numeros);
                p.pruebaKolmogorov(numeros);
                p.pruebaCorridas(numeros);
                p.pruebaHuecos(numeros, 3);
                //p.pruebaPoker(numeros);
                p.pruebaAutocorrelacion(numeros);
            }else {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("No debes de dejar algun campo vacio");
                a.setTitle("Error");
                a.setHeaderText("Error");
                a.showAndWait();
            }
        });
    }
    public ObservableList<NumePseudoaleatorios> llenarTabla(){
        ObservableList<NumePseudoaleatorios> numePseudoaleatorios= FXCollections.observableArrayList();
        return numePseudoaleatorios;
    }
}
