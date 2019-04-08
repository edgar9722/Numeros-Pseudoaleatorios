package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    public static Stage primaryStage;
    @Override
    public void start(Stage _primaryStage) throws Exception{
        primaryStage = _primaryStage;
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/sample/FXML/menuPrincipal.fxml"));
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulacion");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void abrirEscena(ActionEvent event, String escena, Object controller, String titulo){
        try {
            Stage invoiceStage=new Stage();
            invoiceStage.initStyle(StageStyle.UNDECORATED);
            invoiceStage.setTitle(titulo);
            Parent root= null;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/FXML/"+escena));
            loader.setController(controller);
            root=loader.load();
            Scene scene=new Scene(root);
            invoiceStage.setScene(scene);
            invoiceStage.show();
            ((Stage)(((Button) event.getSource()).getScene().getWindow())).hide();
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
}
