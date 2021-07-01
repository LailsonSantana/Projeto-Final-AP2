package dados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import modelo.Criptomoeda;

public class CapturarInformacoes{

    public ArrayList<Criptomoeda> capturarDados(){
        try{
        Document doc = Jsoup.connect("https://br.investing.com/currencies/streaming-forex-rates-majors").get();
        Element table = doc.getElementsByClass("genTbl closedTbl crossRatesTbl").first();
        Element tbody = table.getElementsByTag("tbody").first();

        List<Element> criptos = tbody.getElementsByTag("tr");
        ArrayList<Criptomoeda> criptomoedas = new ArrayList<>();

        for(Element criptomoeda : criptos){
            List<Element> dados = criptomoeda.getElementsByTag("td");
            Criptomoeda c = new Criptomoeda();
            c.setNome(dados.get(2).text());
            //c.setValor(dados.get(3).text());
            c.setCodigo(dados.get(3).text());
            criptomoedas.add(c);
        }

        return criptomoedas;
        }catch(Exception e){
             System.out.println("Erro no metodo 1");
        }
        return null;

    }

    public void listarDados() throws IOException{
        ArrayList<Criptomoeda> criptomoedas = new ArrayList<>();
        criptomoedas = capturarDados();
        for (Criptomoeda c: criptomoedas) {
            converterToJson(c);
        } 
    }

    private void converterToJson(Criptomoeda c){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(c);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    
}
