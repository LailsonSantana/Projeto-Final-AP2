package controle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dados.CotacaoDolar;
import dados.CriptomoedaDados;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Criptomoeda;

public class ComprarControle implements Initializable{

    
    @FXML
    private TextField textQuantidade;

    @FXML
    private TextField textValorUnitario;

    @FXML
    private TextField textCodigo;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    @FXML
    private ComboBox<String> comboConvert;

    private ArrayList<String> opcoes = new ArrayList<>();
    private ObservableList<String> obs;

    

    @Override
    public void initialize(URL url, ResourceBundle arg1) {
        
        carregarOpcoes();
        
    }

    public void salvar(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException{
        CriptomoedaDados cd = new CriptomoedaDados();
        double quantidade = Double.parseDouble(textQuantidade.getText());
        double valorUnit = Double.parseDouble(textValorUnitario.getText());
        String codigo = textCodigo.getText();
        String opcao = comboConvert.getSelectionModel().getSelectedItem();
        if(opcao == "USD"){
            CotacaoDolar cot = new CotacaoDolar();
            double convertido = Double.valueOf(cot.listarDados());
            valorUnit = valorUnit * convertido;
        }
        System.out.println(opcao);
        Criptomoeda c = new Criptomoeda();
        cd.comprarCriptomoeda(codigo,quantidade,valorUnit);
        mensagemInformativa();
        
    }

    

    public void mensagemInformativa(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        alert.setTitle("INFO");
        alert.setHeaderText(null);
        alert.setContentText("Compra realizada com sucesso !");
        
        alert.show();
    }

    public void cancelar(ActionEvent event) {
        Stage stage =  (Stage) btnCancelar.getScene().getWindow();
        
        //stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
        stage.close();

    }

    public void carregarOpcoes(){
        opcoes.add("USD");
        opcoes.add("BRL");
        obs = FXCollections.observableArrayList(opcoes);
        comboConvert.setItems(obs);
    }

    
    
}
