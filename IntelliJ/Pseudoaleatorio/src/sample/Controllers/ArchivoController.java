package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
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
import sample.Main;
import sample.Modelos.NumePseudoaleatorios;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;
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
    int opcion=0;
    ObservableList<NumePseudoaleatorios> numeAll=FXCollections.observableArrayList();
    ObservableList<NumePseudoaleatorios> nume=FXCollections.observableArrayList();
    LinkedList<Double> numeros=new LinkedList<>();
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

        numeAll=llenarTabla();
        clmNumePseudoaleatorios.setCellValueFactory(new PropertyValueFactory<NumePseudoaleatorios, Double>("numeroPseudoaleatorio"));
        tbNumeros.setItems(numeAll);
        lblCantidad.setText(""+numeAll.size());

        rdInicio.setOnAction(event -> {
            opcion=1;
            textInicio.setText("0");
            textInicio.setPromptText("Inicio");
            textFin.setText("");
            textInicio.setPrefWidth(157);
            textInicio.setEditable(false);
            textFin.setVisible(true);
        });
        rdIntervalo.setOnAction(event -> {
            opcion=2;
            textInicio.setPromptText("Inicio");
            textInicio.setText("");
            textFin.setText("");
            textInicio.setPrefWidth(157);
            textInicio.setEditable(true);
            textFin.setVisible(true);
        });
        rdFinal.setOnAction(event -> {
            opcion=3;
            textInicio.setPromptText("Los ultimos");
            textInicio.setPrefWidth(330);
            textFin.setVisible(false);
        });
        btnLeer.setOnAction(event -> {
            int fin, inicio;
            switch (opcion){
                case 1:
                    fin=Integer.parseInt(textFin.getText());
                    for (int i = 0; i < fin; i++) {
                        numeros.add(numeAll.get(i).getNumeroPseudoaleatorio());
                        nume.add(numeAll.get(i));
                    }
                    break;
                case 2:
                    inicio=Integer.parseInt(textInicio.getText());
                    fin=Integer.parseInt(textFin.getText());
                    for (int i = inicio; i < fin; i++) {
                        numeros.add(numeAll.get(i).getNumeroPseudoaleatorio());
                        nume.add(numeAll.get(i));
                    }
                    break;
                case 3:
                    inicio=Integer.parseInt(textInicio.getText());
                    for (int i = inicio-1; i >= 0 ; i--) {
                        numeros.add(numeAll.get(i).getNumeroPseudoaleatorio());
                        nume.add(numeAll.get(i));
                    }
            }
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Leido con exito");
            a.setTitle("Informacion");
            a.setHeaderText("¡Exito!");
            a.showAndWait();
            tbNumeros.setItems(nume);
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
