package com.Teste.spring.jpa.postgresql.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

// import com.Teste.spring.jpa.postgresql.dominio.BusacaConsultaRendimento;
import com.Teste.spring.jpa.postgresql.model.UserTrade;
import com.Teste.spring.jpa.postgresql.repository.UserTradeQueryRepository;
import com.Teste.spring.jpa.postgresql.repository.UserTradeRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api3")
public class UserTradeController {

    @Autowired
    UserTradeRepository userTradeRepository;

    @Autowired
    UserTradeQueryRepository userTradeQueryRepository;


    // @Autowired
    // BusacaConsultaRendimento busacaConsultaRendimento;

    @GetMapping("/usertrade")
    public ResponseEntity<List<UserTrade>> getAllTutorials(@RequestParam(required = false) String prazo) {
        System.out.println("This is my first log4j's statement");
        System.out.println("This is my first log4j's statement" + prazo);
        try {
            List<UserTrade> userTrade = new ArrayList<UserTrade>();

            if (prazo == null) {
                System.out.println("find all");
                userTradeRepository.findAll().forEach(userTrade::add);
                System.out.println("find all");

            } else {
                userTradeRepository.findByPrazoContaining(prazo).forEach(userTrade::add);
            }

            if (userTrade.isEmpty()) {
                System.out.println("vazio");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(userTrade, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/usertrade")
    public ResponseEntity<UserTrade> createTutorial(@RequestBody UserTrade userTrade) {
        try {

            UserTrade _userTrade = userTradeRepository
                    .save(new UserTrade(
                            userTrade.getData(),
                            userTrade.getTipoOperacao(),
                            userTrade.getMercado(),
                            userTrade.getPrazo(),
                            userTrade.getInstrument(),
                            userTrade.getEspecificacao(),
                            userTrade.getQuantidade(),
                            userTrade.getPreco(),
                            userTrade.getValorTotal()));
            return new ResponseEntity<>(_userTrade, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usertrade/{id}")
    public ResponseEntity<UserTrade> getTutorialById(@PathVariable("id") long id) {
        Optional<UserTrade> userTradeData = userTradeRepository.findById(id);

        if (userTradeData.isPresent()) {
            return new ResponseEntity<>(userTradeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/usertrade/data")
    public ResponseEntity<List<UserTrade>> getByIntervalodeData(@RequestParam(required = false) String tipoOperacao) {
        // Optional<UserTrade> userTradeData = userTradeRepository.findById(id);
        try {
            List<UserTrade> userTrade = new ArrayList<UserTrade>();
           // tipoOperacao = "C";
            System.out.println(tipoOperacao);
            if (tipoOperacao == null) {
                // return new ResponseEntity<>(userTradeData.get(), HttpStatus.OK);
               //compra comprauserTradeRepository.findByTipoOperacao(tipoOperacao).forEach(userTrade::add);
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date dataFinal = formato.parse("2019-12-31");
            Date dataInicial = formato.parse("2019-01-01");
            userTradeQueryRepository.customQueryData(dataInicial,dataFinal).forEach(userTrade::add);
            // return new ResponseEntity<>(HttpStatus.NO_CONTENT);else {
                System.out.println("Buscar");
               // userTradeRepository.buscar(tipoOperacao).forEach(userTrade::add);
                // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            
             System.out.println(userTrade);
            return new ResponseEntity<>(userTrade, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usertrade/compra")
    public ResponseEntity<List<UserTrade>> getCompraUserTrade(@RequestParam(required = false) String tipoOperacao) {
        // Optional<UserTrade> userTradeData = userTradeRepository.findById(id);
        try {
            List<UserTrade> userTrade = new ArrayList<UserTrade>();
            // tipoOperacao = "C";
            System.out.println(tipoOperacao);
            if (tipoOperacao == null) {
                // return new ResponseEntity<>(userTradeData.get(), HttpStatus.OK);
                // userTradeRepository.findByTipoOperacao(tipoOperacao).forEach(userTrade::add);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                System.out.println("Buscar");
                userTradeRepository.buscar(tipoOperacao).forEach(userTrade::add);
                // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            System.out.println(userTrade);
            return new ResponseEntity<>(userTrade, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/usertrade/listaracao")
    public ResponseEntity<List<UserTrade>> getListaAcao(@RequestParam(required = false) String tipoOperacao) {
        // Optional<UserTrade> userTradeData = userTradeRepository.findById(id);
        try {
            List<UserTrade> userTrade = new ArrayList<UserTrade>();
            // tipoOperacao = "C";
            System.out.println(tipoOperacao);
            if (tipoOperacao == null) {
                // return new ResponseEntity<>(userTradeData.get(), HttpStatus.OK);
                // userTradeRepository.findByTipoOperacao(tipoOperacao).forEach(userTrade::add);
        
                System.out.println("getListComparandoPreco");
                userTradeQueryRepository.getListPreco(tipoOperacao).forEach(userTrade::add);

               //  System.out.println("getListComparandoPreco"+userTradeQueryRepository.getListComparandoPreco());
                // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            System.out.println(userTrade);
            return new ResponseEntity<>(userTrade, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/usertrade/{id}")
    public ResponseEntity<UserTrade> updateTutorial(@PathVariable("id") long id, @RequestBody UserTrade userTrade) {
        Optional<UserTrade> userTradeData = userTradeRepository.findById(id);

        if (userTradeData.isPresent()) {
            UserTrade _userTrade = userTradeData.get();
            _userTrade.setData(userTrade.getData());
            _userTrade.setTipoOperacao(userTrade.getTipoOperacao());
            _userTrade.setMercado(userTrade.getMercado());
            _userTrade.setPrazo(userTrade.getPrazo());
            _userTrade.setInstrument(userTrade.getInstrument());
            _userTrade.setEspecificacao(userTrade.getEspecificacao());
            _userTrade.setQuantidade(userTrade.getQuantidade());
            _userTrade.setPreco(userTrade.getPreco());
            _userTrade.setValorTotal(userTrade.getValorTotal());

            return new ResponseEntity<>(userTradeRepository.save(_userTrade), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/usertrade/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            userTradeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/usertrade")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            userTradeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
