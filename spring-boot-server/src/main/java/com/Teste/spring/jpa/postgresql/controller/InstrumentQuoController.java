package com.Teste.spring.jpa.postgresql.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//import org.hibernate.engine.jdbc.env.internal.LobCreationLogging_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Teste.spring.jpa.postgresql.model.InstrumentQuote;
import com.Teste.spring.jpa.postgresql.repository.InstrumentQuoteRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api2")
public class InstrumentQuoController {

	@Autowired
	InstrumentQuoteRepository instrumentQuoteRepository;

	@GetMapping("/instrument_quote")
	public ResponseEntity<List<InstrumentQuote>> getAllTutorials(@RequestParam(required = false) String simbol) {
		System.out.println("This is my first log4j's statement");
		System.out.println("This is my first log4j's statement" + simbol);
		try {
			List<InstrumentQuote> instrumentQuote = new ArrayList<InstrumentQuote>();

			if (simbol == null) {
				System.out.println("find all");
				instrumentQuoteRepository.findAll().forEach(instrumentQuote::add);
				System.out.println("find all");

			} else {
				instrumentQuoteRepository.findBySimbolContaining(simbol).forEach(instrumentQuote::add);
			}

			if (instrumentQuote.isEmpty()) {
				System.out.println("vazio");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			System.out.println("retorno" + instrumentQuote);
			return new ResponseEntity<>(instrumentQuote, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/instrument_quote/{data}")
	public ResponseEntity<List<InstrumentQuote>> getTutorialById(@PathVariable("data") String data) {
		List<InstrumentQuote> instrumentQuote = new ArrayList<InstrumentQuote>();
		System.out.println(data);
		if (data != null) {

			// Date dataFinal;
			try {

			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				Date dataFinal = (Date) formato.parse(data);
				instrumentQuoteRepository.findByDate(dataFinal).forEach(instrumentQuote::add);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			return new ResponseEntity<>(instrumentQuote, HttpStatus.OK);
		} else {
			try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			/// Date dataFinal;
			
				Date dataFinal = (Date) formato.parse(data);
				instrumentQuoteRepository.findByDate(dataFinal).forEach(instrumentQuote::add);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			return new ResponseEntity<>(instrumentQuote, HttpStatus.OK);
			// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
