package com.Teste.spring.jpa.postgresql.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Teste.spring.jpa.postgresql.model.InstrumentQuote;


public interface InstrumentQuoteRepository extends JpaRepository<InstrumentQuote, Long> {

    List<InstrumentQuote> findByDate(Date date);

    List<InstrumentQuote> findBySimbolContaining(String simbol);

  //  List<InstrumentQuote> buscarDate(String simbol);

//    List<InstrumentQuote> findBySimbolAndDate(String simbol,Date date);

   // Optional<InstrumentQuote> findByData(Date data);
}
