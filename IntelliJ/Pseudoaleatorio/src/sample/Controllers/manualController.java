package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import sample.Main;
import sample.Modelos.NumePseudoaleatorios;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class manualController implements Initializable {
    @FXML JFXButton btnRegresar; @FXML JFXButton btnCerrar;
    @FXML JFXButton btnLeer;
    @FXML JFXButton btnDistribuciones;
    @FXML JFXButton btnAceptar;
    @FXML JFXTextField textNumero;
    @FXML Label lblCantidad;
    @FXML TableView<NumePseudoaleatorios> tbNumeros;
    @FXML TableColumn clmNumeros;

    Main main=new Main();

    LinkedList<Double> numeros=new LinkedList<>();
    ObservableList<NumePseudoaleatorios> num= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnRegresar.setOnAction(event -> {
            menuAleatoriasController menuAleatoriasController = new menuAleatoriasController();
            main.abrirEscena(event, "menuAleatorias.fxml", menuAleatoriasController, "Menu Aleatorias");
        });
        btnCerrar.setOnAction(event -> {
            System.exit(0);
        });

        btnAceptar.setOnAction(event -> {
            num.add(new NumePseudoaleatorios(Double.parseDouble(textNumero.getText())));
            numeros.add(Double.parseDouble(textNumero.getText()));
            tbNumeros.setItems(num);
        });

        clmNumeros.setCellValueFactory(new PropertyValueFactory<NumePseudoaleatorios, Double>("numeroPseudoaleatorio"));

        btnLeer.setOnAction(event -> {
            FileChooser chooser=new FileChooser();
            //chooser.setInitialDirectory(new File("C:\\Users\\hanse\\Documents\\Hansel\\Juan\\Escuela\\ITC\\Semestre 5\\Simulacion\\Parcial 3\\Numeros-Pseudoaleatorios\\IntelliJ\\Pseudoaleatorio"));
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Texto","*.dat"));
            File file=chooser.showOpenDialog(null);
            if (file!=null){
                try {
                    FileInputStream Fi_Input = new FileInputStream(file);
                    DataInputStream lee = new DataInputStream(Fi_Input);

                    while(true){
                        numeros.add(lee.readDouble());
                        num.add(new NumePseudoaleatorios(lee.readDouble()));
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ArchivoController.class.getName()).log(Level.SEVERE, null, ex);
                }catch(EOFException e) {
                    System.out.println("Leido con exito");
                }
                catch (IOException ex) {
                    Logger.getLogger(ArchivoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            tbNumeros.setItems(num);
            lblCantidad.setText(""+numeros.size());
        });

        btnDistribuciones.setOnAction(event -> {
            if (numeros.size()!=0) {
                distribucionesController distribucionesController = new distribucionesController(numeros,"Manual");
                main.abrirEscena(event, "distribuciones.fxml", distribucionesController, "Distribuciones");
            }else {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("Debe de generar numeros pseudoaleatorios antes de acceder");
                a.setTitle("Atencion");
                a.setHeaderText("Atencion");
                a.showAndWait();
            }
        });
    }
}
