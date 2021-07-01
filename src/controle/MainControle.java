package controle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import dados.CapturarInformacoes;
import dados.CotacaoDolar;
import dados.CriptomoedaDados;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Criptomoeda;


public class MainControle implements Initializable{

    @FXML
    private ImageView imageCripto;

    @FXML
    private Button btnAdicionar;

    @FXML
    private TableView<Criptomoeda> tableCripto;

    @FXML
    private TableColumn<Criptomoeda, String> colunaNome;

    @FXML
    private TableColumn<Criptomoeda, String> colunaCodigo;

    @FXML
    private TableColumn<Criptomoeda,Double> colunaValorUnit;

    @FXML
    private TableColumn<Criptomoeda, Double> colunaQuant;

    @FXML
    private TableColumn<Criptomoeda, Double> colunaPrecoMedio;

    @FXML
    private Button btnComprar;

    @FXML
    private Button btnVender;

    @FXML
    private Button btnInfo;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnAtualizar;

    

    private ObservableList<Criptomoeda> listaCriptomoedas = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle arg1) {

        carregarImagem();
        try {
            carregarLista();
        } catch (ClassNotFoundException | IOException e) {
            
            e.printStackTrace();
        }
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaValorUnit.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        colunaQuant.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colunaPrecoMedio.setCellValueFactory(new PropertyValueFactory<>("precoMedio"));

    }
    public void carregarImagem(){
        Image im = new Image("/dados/cripto.jpg");
        imageCripto.setImage(im);
    }
        
        
    

    @FXML
    public void adicionar(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/TelaAdicionar.fxml"));
        AdicionarControle controlador = new AdicionarControle();
        loader.setController(controlador);
        System.out.println("To aqui");
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Adicionar");
        stage.show();
    }

    @FXML
    public void comprar(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/TelaComprar.fxml"));
        ComprarControle controlador= new ComprarControle();
        loader.setController(controlador);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Salvar");
        stage.close();
        stage.show();

    }

    @FXML
    public void vender(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/TelaVender.fxml"));
        VenderControle controlador= new VenderControle();
        loader.setController(controlador);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Salvar");
        stage.show();
    }

    public void atualizar(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException{
        System.out.println("Atualizar está sendo chamado");
        carregarLista();
        tableCripto.setItems(listaCriptomoedas);
        
    }

    public void carregarLista() throws FileNotFoundException, ClassNotFoundException, IOException{
        try{
        CriptomoedaDados cd = new CriptomoedaDados();
        listaCriptomoedas = FXCollections.observableArrayList(cd.listarCriptomoedas());
        }catch(Exception e){
            System.out.println("O ERRO ESTÁ AQUII");
        }

        
    }

    public void fecharTudo(ActionEvent event) throws IOException{
        //Platform.exit();
        //CapturarInformacoes capturar = new CapturarInformacoes();
        //capturar.listarDados();
        CotacaoDolar cotacao = new CotacaoDolar();
        cotacao.listarDados();
    }

    
    
}
