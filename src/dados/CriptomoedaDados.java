package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import modelo.Criptomoeda;

public class CriptomoedaDados implements Serializable {

    public void cadastrarCriptomoeda (Criptomoeda c) throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList <Criptomoeda> criptomoedas = new ArrayList<>();
        File arq = new File ("listaCriptomoedas.ser");
        if (arq.exists()){
            criptomoedas = listarCriptomoedas();
            
        }
        criptomoedas.add(c);
        FileOutputStream fluxo = new FileOutputStream(arq);
        try (ObjectOutputStream gravarObj = new ObjectOutputStream(fluxo)) {
            gravarObj.writeObject(criptomoedas);
        }
        System.out.println("Veio no adicionar");
    }
    
    public ArrayList<Criptomoeda> listarCriptomoedas() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList <Criptomoeda> criptomoedas;

        File arq = new File ("listaCriptomoedas.ser");
        FileInputStream fluxo = new FileInputStream(arq);
        ObjectInputStream lerObj = new ObjectInputStream(fluxo);
        criptomoedas = (ArrayList<Criptomoeda>) lerObj.readObject();

        return criptomoedas;
    }

    public void comprarCriptomoeda(String codigo,double quantidade,double valorUnit) throws FileNotFoundException, ClassNotFoundException, IOException{
        ArrayList<Criptomoeda> criptomoedas = new ArrayList<>();
        File arq = new File ("listaCriptomoedas.ser");
        Criptomoeda c = null;
        criptomoedas = listarCriptomoedas();
        for(int i=0;i<criptomoedas.size();i++){
            if(criptomoedas.get(i).getCodigo().equals(codigo)){
                c = criptomoedas.get(i);
                c.setQuantidade(quantidade + c.getQuantidade());
                c.setValorTotal((quantidade*valorUnit) + c.getValorTotal());
                c.setPrecoMedio(c.getValorTotal()/c.getQuantidade());
            }
        }
        FileOutputStream fluxo = new FileOutputStream(arq);
        try (ObjectOutputStream gravarObj = new ObjectOutputStream(fluxo)) {
            gravarObj.writeObject(criptomoedas);
        }
    }

    public void venderCriptomoeda(String codigo,double quantidade,double valorUnit) throws FileNotFoundException, ClassNotFoundException, IOException{
        ArrayList<Criptomoeda> criptomoedas = new ArrayList<>();
        File arq = new File ("listaCriptomoedas.ser");
        criptomoedas = listarCriptomoedas();
        Criptomoeda c = null;
        for(int i=0;i<criptomoedas.size();i++){
            if(criptomoedas.get(i).getCodigo().equals(codigo)){
                c = criptomoedas.get(i);
                c.setQuantidade(c.getQuantidade()- quantidade);
                c.setValorTotal(c.getValorTotal()-(quantidade*valorUnit));
                c.setPrecoMedio(c.getValorTotal()/c.getQuantidade());

            }
        }
        FileOutputStream fluxo = new FileOutputStream(arq);
        try (ObjectOutputStream gravarObj = new ObjectOutputStream(fluxo)) {
            gravarObj.writeObject(criptomoedas);
        }
    }
    
    
    
    public void removerAtivo(Criptomoeda c) throws IOException{
        ArrayList <Criptomoeda> criptomoedas = new ArrayList<>();
        criptomoedas.remove(c);
        
        File arquivo = new File( "listaCriptomoedas.ser");
        FileOutputStream fluxo = new FileOutputStream(arquivo);
        try (ObjectOutputStream gravarObj = new ObjectOutputStream(fluxo)) {
            gravarObj.writeObject(criptomoedas);
        }
    }

    
    
}
