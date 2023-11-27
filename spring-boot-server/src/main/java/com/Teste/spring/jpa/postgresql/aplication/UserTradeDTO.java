package com.Teste.spring.jpa.postgresql.aplication;


public class UserTradeDTO {


        private String data;
        private String tipoOperacao;
        private String mercado;
        private String prazo;
        private String instrument;
        private String especificacao;
        private double quantidade;
        private double preco;
        private double valorTotal;


    
        public UserTradeDTO(String data, String tipoOperacao, String mercado, String prazo, String instrument,
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

        public String getData() {
                return data;
        }

        public void setData(String data) {
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
}
