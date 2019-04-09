package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import sample.Modelos.NumePseudoaleatorios;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchivoController implements Initializable {
    @FXML JFXRadioButton rdInicio; @FXML JFXRadioButton rdIntervalo; @FXML JFXRadioButton rdFinal;
    @FXML JFXTextField textInicio; @FXML JFXTextField textFin;
    @FXML JFXButton btnLeer;       @FXML JFXButton btnRegresar;      @FXML JFXButton btnCerrar;
    @FXML Label lblCantidad;

    @FXML TableView<NumePseudoaleatorios> tbNumeros;
    @FXML TableColumn clmNumePseudoaleatorios;
    File file = null;
    Main main=new Main();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnRegresar.setOnAction(event -> {
            menuAleatoriasController menuAleatoriasController=new menuAleatoriasController();
            main.abrirEscena(event, "menuAleatorias.fxml", menuAleatoriasController, "Menu Aleatorias");
        });
        btnCerrar.setOnAction(event -> {
            System.exit(0);
        });

        clmNumePseudoaleatorios.setCellValueFactory(new PropertyValueFactory<NumePseudoaleatorios, Double>("numeroPseudoaleatorio"));
        tbNumeros.setItems(llenarTabla());
        lblCantidad.setText(""+llenarTabla().size());

        rdInicio.setOnAction(event -> {
            System.out.println("Hola 1");
        });
        rdIntervalo.setOnAction(event -> {
            System.out.println("Hola 2");
        });
        rdFinal.setOnAction(event -> {
            System.out.println("Hola 3");
        });
    }

    public ObservableList<NumePseudoaleatorios> llenarTabla(){
        ObservableList<NumePseudoaleatorios> numeros= FXCollections.observableArrayList();
        try {
            file = new File("Numeros Pseudoaleatorios.dat");
            FileInputStream Fi_Input = new FileInputStream(file);
            DataInputStream lee = new DataInputStream(Fi_Input);

            while(true){
                numeros.add(new NumePseudoaleatorios(lee.readDouble()));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoController.class.getName()).log(Level.SEVERE, null, ex);
        }catch(EOFException e) {
            System.out.println("Leido con exito");
        }
        catch (IOException ex) {
            Logger.getLogger(ArchivoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numeros;
    }
}
