package controle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dados.CriptomoedaDados;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modelo.Criptomoeda;

public class AdicionarControle implements Initializable {

    @FXML
    private TextField textNome;

    @FXML
    private TextField textCodigo;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnFechar;

    @FXML
    private Button btnCancelar;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        
    }

    public void salvar(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException{
        CriptomoedaDados cd = new CriptomoedaDados();
        String nome = textNome.getText();
        String codigo = textCodigo.getText();
        Criptomoeda c = new Criptomoeda(nome,codigo);
        cd.cadastrarCriptomoeda(c);
        mensagemInformativa();
    }

    public void mensagemInformativa(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        alert.setTitle("INFO");
        alert.setHeaderText(null);
        alert.setContentText("Criptomoeda adicionada com sucesso !");
        
        alert.show();
    }

    public void cancelar(ActionEvent event) {
            
            Stage stage =  (Stage) btnCancelar.getScene().getWindow();
            //stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
            stage.close();
        
        
    }

    
    
}
