package dados;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import modelo.Dolar;

public class CotacaoDolar {

    public Dolar capturarDados() throws IOException{
        
        Document doc = Jsoup.connect("https://br.investing.com/currencies/streaming-forex-rates-majors").get();

        Element tbody = doc.getElementsByTag("tbody").first();
        Element dolar = tbody.getElementsByTag("tr").get(0);
        Element e  = dolar.getElementsByTag("td").get(2);
        Dolar d = new Dolar();
        d.setValorAtual(e.text());
        return d;
        
    }

    public String listarDados() throws IOException{
        String convertido = null;
        Dolar d = new Dolar();
        d = capturarDados();
        
        convertido = converterToJson(d);
        convertido = convertido.replaceAll("[^0-9,',']", "");
        convertido = convertido.replaceAll(",", ".");
        System.out.println(convertido);
        return convertido;

    }

    private String converterToJson(Dolar d){
        String json = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(d);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
        
    }


    
    
}
