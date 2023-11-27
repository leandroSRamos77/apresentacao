package com.Teste.spring.jpa.postgresql.aplication;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RendimentoTest {

    @Test
    public void testCalcularRendimento() {
        // Arrange
        double valorInicial = 1.0;
        double valorFinal = 2.0;
        Rendimento rendimento = new Rendimento();

        // Act
        rendimento.setValorInicial(valorInicial);
        rendimento.setValorFinal(valorFinal);

        // Assert
        assertEquals(100.0, rendimento.getRendimento(), 0.0001);
    }
}