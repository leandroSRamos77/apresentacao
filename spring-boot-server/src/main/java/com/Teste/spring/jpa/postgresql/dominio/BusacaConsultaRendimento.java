package com.Teste.spring.jpa.postgresql.dominio;

public class BusacaConsultaRendimento {

    private double parcelaAnterior;
    private double precoDaCompra;
    private String operacao;
    private String sigla;
    private String nome;
    private double quantidade;

    public BusacaConsultaRendimento(){}

    public BusacaConsultaRendimento(double parcelaAnterior, double precoDaCompra, String operacao, String sigla, String nome, double quantidade) {
        this.parcelaAnterior = parcelaAnterior;
        this.precoDaCompra = precoDaCompra;
        this.operacao = operacao;
        this.sigla = sigla;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public double getParcelaAnterior() {
        return parcelaAnterior;
    }

    public void setParcelaAnterior(double parcelaAnterior) {
        this.parcelaAnterior = parcelaAnterior;
    }

    public double getPrecoDaCompra() {
        return precoDaCompra;
    }

    public void setPrecoDaCompra(double precoDaCompra) {
        this.precoDaCompra = precoDaCompra;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }



    @Override
    public String toString() {
        return "BusacaConsultaRendimento{" +
                "parcelaAnterior=" + parcelaAnterior +
                ", precoDaCompra=" + precoDaCompra +
                ", operacao='" + operacao + '\'' +
                ", sigla='" + sigla + '\'' +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }


    
    
}
