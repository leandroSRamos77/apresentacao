package com.Teste.spring.jpa.postgresql.model;

import java.util.Date;
import java.util.List;

import org.springframework.scheduling.config.Task;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_trade", schema = "public")
public class UserTrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "data")
    private Date data;

    @Column(name = "tipo_operacao")
    private String tipoOperacao;

    @Column(name = "mercado")
    private String mercado;

    @Column(name = "prazo")
    private String prazo;

    @Column(name = "instrument")
    private String instrument;

    @Column(name = "especificacao")
    private String especificacao;

    @Column(name = "quantidade")
    private double quantidade;

    @Column(name = "preco")
    private double preco;

    @Column(name = "valor_total")
    private double valorTotal;

    @OneToMany(cascade = CascadeType.ALL)
    private List<InstrumentQuote> instrumentQuote;

    // @Column(name = "user_trade_pkey")

    public UserTrade() {
    }

    public UserTrade(Date data, String tipoOperacao, String mercado, String prazo, String instrument,
            String especificacao, double quantidade, double preco, double valorTotal) {
        this.data = data;
        this.tipoOperacao = tipoOperacao;
        this.mercado = mercado;
        this.prazo = prazo;
        this.instrument = instrument;
        this.especificacao = especificacao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.valorTotal = valorTotal;
    }

        public UserTrade(double preco, String tipoOperacao,String prazo, String instrument,
             double quantidade) {
            
                this.preco = preco;
                this.tipoOperacao = tipoOperacao;
                this.prazo = prazo;
                this.instrument = instrument;
                this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", date=" + data + ", tipoOperacao=" + tipoOperacao + ", mercado=" + mercado
                + "]";
    }
}
