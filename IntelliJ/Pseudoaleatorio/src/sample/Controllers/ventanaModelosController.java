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

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ventanaModelosController implements Initializable {
    //Componentes
    @FXML JFXButton btnAyuda;   @FXML JFXButton btnVonNeumann;     @FXML JFXButton btnProdCentral; @FXML JFXButton btnFactConstante;
    @FXML JFXButton btnAditivo; @FXML JFXButton btnMultiplicativo; @FXML JFXButton btnMixto;       @FXML JFXButton btnPruebas;
    @FXML JFXButton btnGenerar; @FXML JFXButton btnRegresar;       @FXML JFXButton btnCerrar;

    @FXML JFXTextField textSemilla; @FXML JFXTextField textNumeAleatorio; @FXML JFXTextField textReferencia;
    @FXML JFXTextField textModulo;  @FXML JFXTextField textMultiplicador; @FXML JFXTextField textConsAditiva;

    @FXML TableView<NumePseudoaleatorios> tbNumePseudoaleatorios;
    @FXML TableColumn clmNumePseudoaleatorios;

    //Objetos
    Main main=new Main();
    NumePseudoaleatorios modeloNumeros=null;

    //Atributos
    File file = null;
    int numModelo=0;
    boolean opcionAyuda=false;
    int pseudo[];
    ObservableList<NumePseudoaleatorios> numeros=FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciar();
        btnRegresar.setOnAction(event -> {
            Controller controller=new Controller();
            main.abrirEscena(event,"sample.fxml", controller,"Menu numeros pseudoaleatorios");
        });
        btnCerrar.setOnAction(event -> {
            System.exit(0);
        });

        clmNumePseudoaleatorios.setCellValueFactory(new PropertyValueFactory<NumePseudoaleatorios, Integer>("numeroPseudoaleatorio"));
        tbNumePseudoaleatorios.setItems(llenarTabla());

        btnVonNeumann.setOnAction(event -> {
            numModelo=1;
            btnGenerar.setVisible(true);
            tbNumePseudoaleatorios.setVisible(true);
            textSemilla.setVisible(true);
            textSemilla.setText("");
            textNumeAleatorio.setVisible(false);
            textNumeAleatorio.setText("");
            textMultiplicador.setVisible(false);
            textMultiplicador.setText("");
            textReferencia.setVisible(false);
            textReferencia.setText("");
            textModulo.setVisible(false);
            textModulo.setText("");
            textConsAditiva.setVisible(false);
            textConsAditiva.setText("");
        });

        btnProdCentral.setOnAction(event -> {
            numModelo = 2;
            btnGenerar.setVisible(true);
            tbNumePseudoaleatorios.setVisible(true);
            textSemilla.setVisible(true);
            textSemilla.setText("");
            textNumeAleatorio.setVisible(true);
            textNumeAleatorio.setText("");
            textMultiplicador.setVisible(false);
            textMultiplicador.setText("");
            textReferencia.setVisible(false);
            textReferencia.setText("");
            textModulo.setVisible(false);
            textModulo.setText("");
            textConsAditiva.setVisible(false);
            textConsAditiva.setText("");
        });

        btnFactConstante.setOnAction(event -> {
            numModelo = 3;
            btnGenerar.setVisible(true);
            tbNumePseudoaleatorios.setVisible(true);
            textSemilla.setVisible(true);
            textSemilla.setText("");
            textNumeAleatorio.setVisible(false);
            textNumeAleatorio.setText("");
            textMultiplicador.setVisible(false);
            textMultiplicador.setText("");
            textReferencia.setVisible(true);
            textReferencia.setText("");
            textModulo.setVisible(false);
            textModulo.setText("");
            textConsAditiva.setVisible(false);
            textConsAditiva.setText("");
        });

        btnAditivo.setOnAction(event -> {
            tbNumePseudoaleatorios.setItems(null);
            int size=numeros.size()-1;
            for (int i = size; i >= 0; i--)
                numeros.remove(i);

            numModelo = 4;
            btnGenerar.setVisible(false);
            tbNumePseudoaleatorios.setVisible(true);

            textSemilla.setVisible(false);
            textSemilla.setText("");
            textNumeAleatorio.setVisible(false);
            textNumeAleatorio.setText("");
            textMultiplicador.setVisible(false);
            textMultiplicador.setText("");
            textReferencia.setVisible(false);
            textReferencia.setText("");
            textModulo.setVisible(false);
            textModulo.setText("");
            textConsAditiva.setVisible(false);
            textConsAditiva.setText("");

            TextInputDialog textInputDialog=new TextInputDialog();
            textInputDialog.setContentText("Valor");
            textInputDialog.setTitle("Ingresar dato");
            int num=0;
            int modulo=0, numerosemillas=0;
            try{
                textInputDialog.setHeaderText("¿Cuántos números pseudoaleatorios quieres?");
                Optional<String> dato = textInputDialog.showAndWait();
                if (dato.isPresent())
                    num = Integer.parseInt(dato.get());
                else
                    return;
                textInputDialog.getDefaultValue();
                textInputDialog.setHeaderText("Ingresa el valor del módulo");
                dato = textInputDialog.showAndWait();
                if (dato.isPresent())
                    modulo = Integer.parseInt(dato.get());
                else
                    return;
                textInputDialog.setHeaderText("¿Con cuántas semillas quieres realizar el cálculo?");
                dato = textInputDialog.showAndWait();
                if (dato.isPresent())
                    numerosemillas = Integer.parseInt(dato.get());
                else
                    return;
                registrar(num, numerosemillas);
                calcular(num, modulo, numerosemillas);

                for (int i = 0; i < pseudo.length; i++) {
                    numeros.add(new NumePseudoaleatorios(new Integer(pseudo[i])));
                }

                tbNumePseudoaleatorios.setItems(numeros);
                guardarTabla(numeros);
            }catch(Exception e){
                System.out.println("Operacion cancelada");
            }
        });

        btnMultiplicativo.setOnAction(event -> {
            numModelo = 5;
            btnGenerar.setVisible(true);
            tbNumePseudoaleatorios.setVisible(true);
            textSemilla.setVisible(true);
            textSemilla.setText("");
            textNumeAleatorio.setVisible(false);
            textNumeAleatorio.setText("");
            textMultiplicador.setVisible(true);
            textMultiplicador.setText("");
            textReferencia.setVisible(false);
            textReferencia.setText("");
            textModulo.setVisible(true);
            textModulo.setText("");
            textConsAditiva.setVisible(false);
            textConsAditiva.setText("");
        });

        btnMixto.setOnAction(event -> {
            numModelo = 6;
            btnGenerar.setVisible(true);
            tbNumePseudoaleatorios.setVisible(true);
            textSemilla.setVisible(true);
            textSemilla.setText("");
            textNumeAleatorio.setVisible(false);
            textNumeAleatorio.setText("");
            textMultiplicador.setVisible(true);
            textMultiplicador.setText("");
            textReferencia.setVisible(false);
            textReferencia.setText("");
            textModulo.setVisible(true);
            textModulo.setText("");
            textConsAditiva.setVisible(true);
            textConsAditiva.setText("");
        });

        btnAyuda.setOnAction(event -> {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Para el calculo de numeros pseudoaleatorios te sugerimos que: \n\n"
                    + "Metodo de Neumann: \n"
                    + "         La semilla sea un numero impar.\n"
                    + "         La semilla sea un numero de 4 digitos.\n\n"
                    + "Metodo de Producto Central: \n"
                    + "         Las semillas sea un numero impar\n\n"
                    + "Metodo de Factor Constante: \n"
                    + "         La semilla sea un numero impar.\n"
                    + "         La semilla y la referencia sean numeros de 4 digitos.\n"
                    + "Metodo Aditivo: \n"
                    + "         Las semillas sea un numero impar\n\n"
                    + "Metodo Multiplicativo: \n"
                    + "         La semilla sea un numero mayor a 0.\n"
                    + "         El multiplicador sea un numero mayor a 0.\n"
                    + "         El modulo sea mayor a la semilla y al multiplicador.\n\n"
                    + "Metodo Mixto: \n"
                    + "         La semilla sea un numero mayor a 0.\n"
                    + "         El multiplicador sea un numero mayor a 0.\n"
                    + "         La constante aditivia sea un numero mayor a 0.\n"
                    + "         El modulo sea mayor a la semilla y al multiplicador.\n\n");
            a.setTitle("Ayuda");
            a.setHeaderText("Ayuda");
            a.showAndWait();
        });

        btnGenerar.setOnAction(event -> {
            if (tbNumePseudoaleatorios.getItems().isEmpty()) {
                modelos();
            }else{
                int size=numeros.size()-1;
                for (int i = size; i >= 0; i--)
                    numeros.remove(i);
                modelos();
            }
        });

        btnPruebas.setOnAction(event -> {
            if (opcionAyuda){
                Pruebas p = new Pruebas();
                p.pruebaPromedios(numeros);
                p.pruebaChiCuadrada(numeros);
                p.pruebaKolmogorov(numeros);
                p.pruebaCorridas(numeros);
                p.pruebaHuecos(numeros, 3);
                //p.pruebaPoker(numeros);
                p.pruebaAutocorrelacion(numeros);
            }else {
                ventanaPruebasController ventanaPruebasController = new ventanaPruebasController();
                ventanaPruebasController.setNumeros(numeros);
                main.abrirEscena(event, "ventanaPruebas.fxml", ventanaPruebasController, "Pruebas");
            }
        });
    }

    public void modelos(){
        switch (numModelo) {
            case 1:
                //Neumann
                if (textSemilla.getText().length() > 0 && Integer.parseInt(textSemilla.getText()) > 999 && Integer.parseInt(textSemilla.getText()) <= 10000) {
                    Semilla.Iniciar();

                    int contador = 0;
                    int xSemilla = 0;

                    String cadena = "";
                    int semilla = Integer.parseInt(textSemilla.getText());
                    xSemilla = semilla;
                    int copiaSemilla = semilla;

                    while (true) {
                        int op = (semilla * semilla);
                        char[] nume = ("" + op).toCharArray();
                        int longitud = nume.length;
                        if (longitud == 4) {
                            semilla = op;
                        } else if (longitud == 1) {
                            cadena = "" + 0 + "" + 0 + "" + 0 + "" + nume[0];
                            semilla = Integer.parseInt(cadena);
                        } else if (longitud == 2) {
                            cadena = "" + 0 + "" + 0 + "" + nume[0] + "" + nume[1];
                            semilla = Integer.parseInt(cadena);
                        } else if (longitud == 3) {
                            cadena = "" + 0 + "" + nume[0] + "" + nume[1] + "" + nume[2];
                            semilla = Integer.parseInt(cadena);
                        } else if (longitud == 5) {
                            cadena = "" + 0 + "" + nume[0] + "" + nume[1] + "" + nume[2];
                            semilla = Integer.parseInt(cadena);
                        } else if (longitud == 6) {
                            cadena = "" + nume[0] + "" + nume[1] + "" + nume[2] + "" + nume[3];
                            semilla = Integer.parseInt(cadena);
                        } else if (longitud == 7) {
                            cadena = "" + nume[1] + "" + nume[2] + "" + nume[3] + "" + nume[4];
                            semilla = Integer.parseInt(cadena);
                        } else if (longitud == 8) {
                            cadena = "" + nume[2] + "" + nume[3] + "" + nume[4] + "" + nume[5];
                            semilla = Integer.parseInt(cadena);
                        }
                        numeros.add(modeloNumeros = new NumePseudoaleatorios((double) xSemilla / 10000));
                        xSemilla = semilla;
                        if (semilla == copiaSemilla) {
                            Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("la semilla inicial \"" + copiaSemilla + "\" se repite en : " + contador);
                            a.setTitle("Informacion");
                            a.setHeaderText("Se repitio");
                            a.showAndWait();
                            break;
                        } else if (semilla == 0) {
                            Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("el ciclo termina en 000 : " + contador);
                            a.setTitle("Informacion");
                            a.setHeaderText("Termina");
                            a.showAndWait();
                            break;
                        }
                        if (Semilla.esVacio()) {
                            Semilla.Agregar(cadena);
                        } else {
                            if (!Semilla.siExiste(cadena)) {
                                Semilla.Agregar(cadena);
                            } else {
                                Alert a = new Alert(Alert.AlertType.INFORMATION);
                                a.setContentText("El numero se repite en " + contador);
                                a.setTitle("Informacion");
                                a.setHeaderText("Se repitio");
                                a.showAndWait();
                                break;
                            }
                        }

                        contador++;
                    }
                    tbNumePseudoaleatorios.setItems(numeros);
                    guardarTabla(numeros);
                } else if (textSemilla.getText().length() == 0) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("No debes dejar algun campo vacio");
                    a.setTitle("Alerta");
                    a.setHeaderText("ERROR");
                    a.showAndWait();
                } else if (Integer.parseInt(textSemilla.getText()) <= 999 || Integer.parseInt(textSemilla.getText()) >= 10000) {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("El campo de la semilla debe ser de 4 digitos");
                    a.setTitle("Alerta");
                    a.setHeaderText("Alerta");
                    a.showAndWait();
                }
                break;

            case 2:
                //Producto Central
                class Proceso {
                    int semilla, numRandom;
                    String resultado;


                    public Proceso(int semilla, int numRandom) {
                        this.semilla = semilla;
                        this.numRandom = numRandom;
                    }

                    public void multiplicar() {
                        int aux = semilla * numRandom;
                        resultado = refactorizar(aux);
                    }

                    public String substraer() {
                        String xsemilla = resultado.substring(2, 6);
                        return xsemilla;
                    }

                    public String refactorizar(int refactor) {
                        String aux = String.valueOf(refactor);

                        if (aux.length() < 8) {

                            int numCeros = 8 - aux.length();
                            String ceros = "";
                            for (int i = 0; i < numCeros; i++)
                                ceros += "0";

                            aux = ceros + aux;
                        }
                        return aux;
                    }

                    public void conmutar(String substring) {
                        semilla = numRandom;
                        numRandom = Integer.valueOf(substring);
                    }

                    public boolean verificar(String substring) {
                        int aux = Integer.valueOf(substring);
                        return aux != semilla;
                    }

                    public void start() {
                        String xsemilla;
                        int contador = 1;
                        do {
                            multiplicar();
                            xsemilla = substraer();
                            conmutar(xsemilla);

                            numeros.add(new NumePseudoaleatorios(Double.parseDouble(xsemilla) / 10000));
                            contador++;
                            tbNumePseudoaleatorios.setItems(numeros);

                        } while (verificar(xsemilla));
                        if (xsemilla.equals("0000")) {
                            Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("El ciclo termina en 000: " + contador);
                            a.setTitle("Alerta");
                            a.setHeaderText("TERMINA");
                            a.showAndWait();
                        }
                        if (!verificar(xsemilla)) {
                            Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("El numero se repite en " + contador);
                            a.setTitle("Alerta");
                            a.setHeaderText("Se repite");
                            a.showAndWait();
                        }

                        guardarTabla(numeros);

                    }
                }
                if (textSemilla.getText().length() > 0 && Integer.parseInt(textSemilla.getText()) > 999 && Integer.parseInt(textSemilla.getText()) <= 10000 && textNumeAleatorio.getText().length() > 0 && Integer.parseInt(textNumeAleatorio.getText()) > 999 && Integer.parseInt(textNumeAleatorio.getText()) <= 10000) {
                    int semilla = Integer.parseInt(textSemilla.getText());
                    int numRandom = Integer.parseInt(textNumeAleatorio.getText());
                    Proceso proceso = new Proceso(semilla, numRandom);
                    proceso.start();
                } else if (textSemilla.getText().length() == 0 || textNumeAleatorio.getText().length() == 0) {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("No debes dejar algun campo vacio.");
                    a.setTitle("Alerta");
                    a.setHeaderText("Alerta");
                    a.showAndWait();
                } else if (Integer.parseInt(textSemilla.getText()) <= 999 || Integer.parseInt(textNumeAleatorio.getText()) >= 10000 || Integer.parseInt(textNumeAleatorio.getText()) <= 999 || Integer.parseInt(textNumeAleatorio.getText()) >= 10000) {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("El campo de la semilla y/o el campo numero aleatorio debe ser de 4 digitos");
                    a.setTitle("Alerta");
                    a.setHeaderText("Alerta");
                    a.showAndWait();
                }
                break;

            case 3:
                //Factor Constante
                if (textSemilla.getText().length() > 0 && Integer.parseInt(textSemilla.getText()) > 999 && Integer.parseInt(textSemilla.getText()) <= 10000 && textReferencia.getText().length() > 0 && Integer.parseInt(textReferencia.getText()) > 999 && Integer.parseInt(textReferencia.getText()) <= 10000) {
                    Semilla.Iniciar();

                    boolean existe = true;

                    try {
                        int numeroSemilla = Integer.parseInt(textSemilla.getText().toString());
                        int numeroReferencia = Integer.parseInt(textReferencia.getText().toString());
                    } catch (java.lang.NumberFormatException nfe) {
                        Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setContentText("No se puede procesar su entrada, debes escribir caracteres numericos!");
                        a.setTitle("Alerta");
                        a.setHeaderText("Alerta");
                        a.showAndWait();
                        existe = false;
                    }

                    if (existe == true) {
                        int contador = 0;
                        int xSemilla = 0;
                        int xReferencia = 0;
                        String cadena = "";
                        int semilla = Integer.parseInt(textSemilla.getText());
                        int referencia = Integer.parseInt(textReferencia.getText());
                        xSemilla = semilla;
                        int copiaSemilla = semilla;

                        while (true) {
                            int op = (semilla * referencia);
                            char[] numeros = ("" + op).toCharArray();
                            int longitud = numeros.length;
                            if (longitud == 4) {
                                semilla = op;
                            } else if (longitud == 1) {
                                cadena = "" + 0 + "" + 0 + "" + 0 + "" + numeros[0];
                                semilla = Integer.parseInt(cadena);
                            } else if (longitud == 2) {
                                cadena = "" + 0 + "" + 0 + "" + numeros[0] + "" + numeros[1];
                                semilla = Integer.parseInt(cadena);
                            } else if (longitud == 3) {
                                cadena = "" + 0 + "" + numeros[0] + "" + numeros[1] + "" + numeros[2];
                                semilla = Integer.parseInt(cadena);
                            } else if (longitud == 5) {
                                cadena = "" + 0 + "" + numeros[0] + "" + numeros[1] + "" + numeros[2];
                                semilla = Integer.parseInt(cadena);
                            } else if (longitud == 6) {
                                cadena = "" + numeros[0] + "" + numeros[1] + "" + numeros[2] + "" + numeros[3];
                                semilla = Integer.parseInt(cadena);
                            } else if (longitud == 7) {
                                cadena = "" + numeros[1] + "" + numeros[2] + "" + numeros[3] + "" + numeros[4];
                                semilla = Integer.parseInt(cadena);
                            } else if (longitud == 8) {
                                cadena = "" + numeros[2] + "" + numeros[3] + "" + numeros[4] + "" + numeros[5];
                                semilla = Integer.parseInt(cadena);
                            }
                            this.numeros.add(new NumePseudoaleatorios((double) xSemilla / 10000));
                            xSemilla = semilla;
                            if (semilla == copiaSemilla) {
                                Alert a = new Alert(Alert.AlertType.INFORMATION);
                                a.setContentText("la semilla inicial \"" + copiaSemilla + "\" se repite en : " + contador);
                                a.setTitle("Repite");
                                a.setHeaderText("Se repite");
                                a.showAndWait();
                                break;
                            } else if (semilla == 0) {
                                Alert a = new Alert(Alert.AlertType.INFORMATION);
                                a.setContentText("el ciclo termina en 000 : " + contador);
                                a.setTitle("Termina");
                                a.setHeaderText("TERMINA");
                                a.showAndWait();
                                break;
                            }
                            if (Semilla.esVacio()) {
                                Semilla.Agregar(cadena);
                            } else {
                                if (!Semilla.siExiste(cadena)) {
                                    Semilla.Agregar(cadena);
                                } else {
                                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                                    a.setContentText("El numero se repite en " + contador);
                                    a.setTitle("Repite");
                                    a.setHeaderText("Se repite");
                                    a.showAndWait();
                                    break;
                                }
                            }

                            contador++;
                        }
                        tbNumePseudoaleatorios.setItems(numeros);
                        guardarTabla(numeros);
                    }
                } else if (textSemilla.getText().length() == 0 || textReferencia.getText().length() == 0) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("No debes dejar algun campo vacio");
                    a.setTitle("Error");
                    a.setHeaderText("ERROR");
                    a.showAndWait();
                } else if (Integer.parseInt(textSemilla.getText()) <= 999 || Integer.parseInt(textSemilla.getText()) >= 10000 || Integer.parseInt(textReferencia.getText()) <= 999 || Integer.parseInt(textReferencia.getText()) >= 10000) {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("El campo de la semilla y/o el campo de la referencia debe ser de 4 digitos");
                    a.setTitle("Atencion");
                    a.setHeaderText("ATENCION");
                    a.showAndWait();
                }
                break;

            case 5:
                //Multiplicativo
                if (Integer.parseInt(textSemilla.getText()) > 0 && Integer.parseInt(textMultiplicador.getText()) > 0 && Integer.parseInt(textModulo.getText()) > Integer.parseInt(textSemilla.getText()) && Integer.parseInt(textModulo.getText()) > Integer.parseInt(textMultiplicador.getText())) {
                    Semilla.Iniciar();

                    String cadena = "";
                    int semilla = Integer.parseInt(textSemilla.getText());
                    int multiplicador = Integer.parseInt(textMultiplicador.getText());
                    int modulo = Integer.parseInt(textModulo.getText());
                    int copiaSemilla = semilla;

                    for (int i = 1; i < 100; i++) {
                        semilla = (semilla * multiplicador) % modulo;
                        cadena = semilla + "";
                        semilla = Integer.parseInt(cadena);
                        numeros.add(new NumePseudoaleatorios((double) semilla / modulo));

                        if (semilla == copiaSemilla) {
                            Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("la semilla inicial \"" + copiaSemilla + "\" se repite en : " + i);
                            a.setTitle("Repite");
                            a.setHeaderText("Se repite");
                            a.showAndWait();
                            break;
                        }
                        if (Semilla.esVacio()) {
                            Semilla.Agregar(cadena);
                        } else {
                            if (!Semilla.siExiste(cadena)) {
                                Semilla.Agregar(cadena);
                            } else {
                                Alert a = new Alert(Alert.AlertType.INFORMATION);
                                a.setContentText("la semilla inicial se repite en " + i);
                                a.setTitle("Repite");
                                a.setHeaderText("Se repite");
                                a.showAndWait();
                                break;
                            }
                        }
                    }
                    tbNumePseudoaleatorios.setItems(numeros);
                    guardarTabla(numeros);
                } else if (textSemilla.getText().length() == 0 || textMultiplicador.getText().length() == 0 || textModulo.getText().length() == 0) {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("No debes dejar algun campo vacio");
                    a.setTitle("Error");
                    a.setHeaderText("ERROR");
                    a.showAndWait();
                } else if (Integer.parseInt(textSemilla.getText()) <= 0 || Integer.parseInt(textMultiplicador.getText()) <= 0 || Integer.parseInt(textModulo.getText()) < Integer.parseInt(textSemilla.getText()) || Integer.parseInt(textModulo.getText()) < Integer.parseInt(textMultiplicador.getText())) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Verificar datos");
                    a.setTitle("Error");
                    a.setHeaderText("ERROR");
                    a.showAndWait();
                }
                break;

            case 6:
                //Mixto
                if (Integer.parseInt(textSemilla.getText()) > 0 && Integer.parseInt(textMultiplicador.getText()) > 0 && Integer.parseInt(textConsAditiva.getText()) > 0 && Integer.parseInt(textModulo.getText()) > Integer.parseInt(textSemilla.getText()) && Integer.parseInt(textModulo.getText()) > Integer.parseInt(textMultiplicador.getText())) {
                    Semilla.Iniciar();

                    String cadena = "";
                    int semilla = Integer.parseInt(textSemilla.getText());
                    int multiplicador = Integer.parseInt(textMultiplicador.getText());
                    int modulo = Integer.parseInt(textModulo.getText());
                    int constante = Integer.parseInt(textConsAditiva.getText());

                    int copiaSemilla = semilla;

                    for (int i = 1; i < 100; i++) {
                        semilla = ((semilla * multiplicador) + constante) % modulo;
                        cadena = semilla + "";
                        semilla = Integer.parseInt(cadena);
                        numeros.add(new NumePseudoaleatorios((double) semilla / modulo));

                        if (semilla == copiaSemilla) {
                            Alert a = new Alert(Alert.AlertType.INFORMATION);
                            a.setContentText("la semilla inicial \"" + copiaSemilla + "\" se repite en : " + i);
                            a.setTitle("Repite");
                            a.setHeaderText("Se repite");
                            a.showAndWait();
                            break;
                        }
                        if (Semilla.esVacio()) {
                            Semilla.Agregar(cadena);
                        } else {
                            if (!Semilla.siExiste(cadena)) {
                                Semilla.Agregar(cadena);
                            } else {
                                Alert a = new Alert(Alert.AlertType.INFORMATION);
                                a.setContentText("la semilla inicial se repite en " + i);
                                a.setTitle("Repite");
                                a.setHeaderText("Se repite");
                                a.showAndWait();
                                break;
                            }
                        }
                    }
                    tbNumePseudoaleatorios.setItems(numeros);
                    guardarTabla(numeros);
                } else if (textSemilla.getText().length() == 0 || textMultiplicador.getText().length() == 0 || textModulo.getText().length() == 0 || textConsAditiva.getText().length() == 0) {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("No debes dejar algun campo vacio");
                    a.setTitle("Error");
                    a.setHeaderText("ERROR");
                    a.showAndWait();
                } else if (Integer.parseInt(textSemilla.getText()) <= 0 || Integer.parseInt(textMultiplicador.getText()) <= 0 || Integer.parseInt(textConsAditiva.getText()) <= 0 || Integer.parseInt(textModulo.getText()) < Integer.parseInt(textSemilla.getText()) || Integer.parseInt(textModulo.getText()) < Integer.parseInt(textMultiplicador.getText())) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Verificar datos");
                    a.setTitle("Error");
                    a.setHeaderText("ERROR");
                    a.showAndWait();
                }
                break;
        }
    }

    private void guardarTabla (ObservableList<NumePseudoaleatorios> num_pseudoaleatorio){
        file = new File("Numeros Pseudoaleatorios.dat");
        try {
            FileOutputStream Fi_Out = new FileOutputStream (file,true);
            DataOutputStream escribe = new DataOutputStream(Fi_Out);

            for(int i=0; i<num_pseudoaleatorio.size();i++){
                escribe.writeDouble(num_pseudoaleatorio.get(i).getNumeroPseudoaleatorio());
            }
            System.out.println("Escrito correctamente");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ventanaModelosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ventanaModelosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void registrar (int num, int numerosemillas){
        TextInputDialog textInputDialog=new TextInputDialog();
        textInputDialog.setContentText("Valor");
        textInputDialog.setTitle("Ingresar semilla");
        pseudo=new int[num];
        int semilla=0;
        boolean error=false;
        for (int i = 0; i < numerosemillas; i++){
            do {
                error=false;
                textInputDialog.setHeaderText("Ingresa el valor de la semilla X" + (i + 1));
                Optional<String> sem = textInputDialog.showAndWait();
                if (sem.isPresent())
                    semilla = Integer.parseInt(sem.get());
                else{
                    error=true;
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Debe ingresar una semilla");
                    a.setTitle("Error");
                    a.setHeaderText("Error");
                    a.showAndWait();
                }
            }while (error);
            pseudo[i] = semilla;
        }
    }

    private void calcular (int num, int modulo, int numerosemillas){
        for (int i=numerosemillas;i<num;i++){
            pseudo[i]=(pseudo[i-1]+pseudo[i-numerosemillas])%modulo;
            for (int aux=0;aux<i;aux++){
                if(pseudo[i]==pseudo[aux]){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Se repitió en la posición "+i);
                    a.setTitle("Repeticion");
                    a.setHeaderText("Se repitio");
                    a.showAndWait();
                    for(int x = 0; x <= i; x++){
                        System.out.println(pseudo[x]);
                    }
                    break;
                }
            }
        }
        mostrar(num);
    }

    private void mostrar (int num){
        for(int i=0;i<num;i++){
            System.out.println(pseudo[i]);
        }
    }

    public ObservableList<NumePseudoaleatorios> llenarTabla(){
        ObservableList<NumePseudoaleatorios> numePseudoaleatorios= FXCollections.observableArrayList();
        return numePseudoaleatorios;
    }

    public void iniciar(){
        btnGenerar.setVisible(false);
        tbNumePseudoaleatorios.setVisible(false);
        textNumeAleatorio.setVisible(false);
        textMultiplicador.setVisible(false);
        textReferencia.setVisible(false);
        textModulo.setVisible(false);
        textConsAditiva.setVisible(false);
        if (!opcionAyuda)
            btnAyuda.setVisible(false);
    }

    public void ayuda(boolean ayuda){
        opcionAyuda=ayuda;
    }
}
