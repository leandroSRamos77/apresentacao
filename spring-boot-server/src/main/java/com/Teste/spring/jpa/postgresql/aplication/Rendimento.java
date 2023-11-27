package com.Teste.spring.jpa.postgresql.aplication;

public class Rendimento {
    
    double valorInicial = 1.0;
    double valorFinal = 1.0;
    double rendimento = Rendimento(valorInicial, valorFinal);

    public static double Rendimento(double valorInicial, double valorFinal) {
        return ((valorFinal - valorInicial) / valorInicial) * 100;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}
