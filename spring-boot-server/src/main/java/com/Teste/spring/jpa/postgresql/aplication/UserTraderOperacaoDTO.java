package com.Teste.spring.jpa.postgresql.aplication;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.crypto.Data;

public class UserTraderOperacaoDTO {
    private Double precoAnterior;
    private Double precoDaCompra;
    private String operacao;
    private String sigla;
    private String nome;
    private Double quantidade;
    private Date data;

    public UserTraderOperacaoDTO() {
    }

    public UserTraderOperacaoDTO(Double precoAnterior, Double precoDaCompra, String operacao, String sigla, String nome,
            Double quantidade, Date data) {
        this.precoAnterior = precoAnterior;
        this.precoDaCompra = precoDaCompra;
        this.operacao = operacao;
        this.sigla = sigla;
        this.nome = nome;
        this.quantidade = quantidade;
        this.data = data;
    }

    public Double getPrecoAnterior() {
        return precoAnterior;
    }

    public void setPrecoAnterior(Double precoAnterior) {
        this.precoAnterior = precoAnterior;
    }

    public Double getPrecoDaCompra() {
        return precoDaCompra;
    }

    public void setPrecoDaCompra(Double precoDaCompra) {
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

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataretorno = sdf.format(data);
        return dataretorno;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
