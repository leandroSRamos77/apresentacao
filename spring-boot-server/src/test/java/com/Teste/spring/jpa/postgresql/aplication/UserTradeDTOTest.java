package com.Teste.spring.jpa.postgresql.aplication;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTradeDTOTest {

   @Test
    public void testUserTradeDTO() {
        // Arrange
        String data = "2023-11-26";
        String tipoOperacao = "Compra";
        String mercado = "Ações";
        String prazo = "Curto Prazo";
        String instrument = "AAPL";
        String especificacao = "Especificação";
        double quantidade = 10.0;
        double preco = 150.0;
        double valorTotal = 1500.0;

        // Act
        UserTradeDTO trade = new UserTradeDTO(data, tipoOperacao, mercado, prazo, instrument, especificacao, quantidade, preco, valorTotal);

        // Assert
        assertNotNull(trade);
        assertEquals(data, trade.getData());
        assertEquals(tipoOperacao, trade.getTipoOperacao());
        assertEquals(mercado, trade.getMercado());
        assertEquals(prazo, trade.getPrazo());
        assertEquals(instrument, trade.getInstrument());
        assertEquals(especificacao, trade.getEspecificacao());
        assertEquals(quantidade, trade.getQuantidade(), 0.0001); // Delta for double comparison
        assertEquals(preco, trade.getPreco(), 0.0001); // Delta for double comparison
        assertEquals(valorTotal, trade.getValorTotal(), 0.0001); // Delta for double comparison
    }
}