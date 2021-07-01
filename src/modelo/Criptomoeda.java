package modelo;

import java.io.Serializable;

public class Criptomoeda implements Serializable{

    private String nome;
    private String codigo;
    private double lucro;
    private double quantidade;
    private double valorUnitario;
    private double precoMedio;
    private double valorTotal;

    public Criptomoeda(){
    }

    public Criptomoeda(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getPrecoMedio(){
        return precoMedio;
    }

    public void setPrecoMedio(double valor){
        this.precoMedio = valor;
    }

    public double getValorTotal(){
        return valorTotal;
    }

    public void setValorTotal(double valor){
        this.valorTotal = valor;
    }


    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    
}
