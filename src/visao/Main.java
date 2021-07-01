package visao;

import controle.MainControle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("TelaPrincipal.fxml"));
        MainControle controlador = new MainControle();
        fxmlloader.setController(controlador);
        Parent root = fxmlloader.load();
        Scene tela = new Scene(root);
        primaryStage.setTitle("Tela Principal");
        primaryStage.setScene(tela);
        primaryStage.show();
        
    }
}
