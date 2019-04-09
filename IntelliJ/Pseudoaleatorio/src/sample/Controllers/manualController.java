package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import sample.Modelos.NumePseudoaleatorios;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class manualController implements Initializable {
    @FXML JFXButton btnRegresar; @FXML JFXButton btnCerrar;
    @FXML JFXButton btnAgregar;  @FXML JFXButton btnGuardar;
    @FXML JFXTextField textNumero;
    @FXML TableView<NumePseudoaleatorios> tbNumeros;
    @FXML TableColumn clmNumeros;

    Main main=new Main();

    LinkedList<Double> numeros=new LinkedList<>();
    ObservableList<NumePseudoaleatorios> num= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

        clmNumeros.setCellValueFactory(new PropertyValueFactory<NumePseudoaleatorios, Double>("numeroPseudoaleatorio"));

        btnAgregar.setOnAction(event -> {
            num.add(new NumePseudoaleatorios(Double.parseDouble(textNumero.getText())));
            tbNumeros.setItems(num);
            textNumero.setText("");
        });

        btnGuardar.setOnAction(event -> {
            for (int i = 0; i < num.size(); i++) {
                numeros.add(num.get(i).getNumeroPseudoaleatorio());
            }
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Guardado");
            a.setTitle("Guardado");
            a.setHeaderText("¡Guardado!");
            a.showAndWait();
        });
    }
}
