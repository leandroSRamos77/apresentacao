package com.Teste.spring.jpa.postgresql.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Teste.spring.jpa.postgresql.aplication.UserTradeDTO;
import com.Teste.spring.jpa.postgresql.model.UserTrade;

@Repository
public interface UserTradeRepository extends JpaRepository<UserTrade, Long> {

    List<UserTrade> findByData(Date data);

    List<UserTrade> findByPrazoContaining(String prazo);

    List<UserTrade> findByTipoOperacao(String tipoOperacao);

    @Query("from UserTrade u where u.tipoOperacao = :tipoOperacao")
    List<UserTrade> buscar(@Param(value = "tipoOperacao") String tipoOperacao);
/* 
    @Query("SELECT new com.example.dto.UserTradeDTO(iq.price as precoAnterior, ut.preco as precoDaCompra, " +
            "ut.tipoOperacao as operacao, ut.prazo as sigla, ut.instrument as nome, ut.quantidade as quantidade) " +
            "FROM UserTrade ut " +
            "LEFT JOIN InstrumentQuote iq ON iq.simbol = ut.prazo AND iq.date = ut.data " +
            "WHERE ut.tipoOperacao = 'V' AND ut.prazo = 'VVAR3F'")
    List<UserTradeDTO> fetchTradeSelfData();
*/
}
