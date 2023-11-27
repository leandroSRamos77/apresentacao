package com.Teste.spring.jpa.postgresql.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Teste.spring.jpa.postgresql.aplication.UserTraderOperacaoDTO;
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

import com.Teste.spring.jpa.postgresql.aplication.UserTradeDTO;
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
    public ResponseEntity<List<UserTradeDTO>> getAllUsertrade(@RequestParam(required = false) String prazoquery) {
        System.out.println("This is my first log4j's statement");
        System.out.println("This is my first log4j's statement" + prazoquery);
        try {
            List<UserTrade> userTrade = new ArrayList<UserTrade>();
            List<UserTradeDTO> userTradeDTO = new ArrayList<UserTradeDTO>();
            if (prazoquery == null) {
                System.out.println("find all");
                userTradeRepository.findAll().forEach(userTrade::add);

                
                     userTradeDTO = userTrade.stream().map(result -> {
                        String data = null;
                        try {
                            data = result.getDataFormatado();
                        } catch (ParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                         System.out.println("reult result.getTipoOperacao() ==>"+result.getTipoOperacao());
                        String tipoOperacao = result.getTipoOperacao();
                        String mercado = result.getMercado();
                        String prazo = result.getPrazo();
                        String instrument = result.getInstrument();
                        String especificacao = result.getEspecificacao();
                        double quantidade = result.getQuantidade();
                        double preco = result.getPreco();
                        double valorTotal = result.getValorTotal();

                        System.out.println("Data ==>"+data);

                        return new UserTradeDTO(data, tipoOperacao, mercado, prazo, instrument,
                                especificacao, quantidade, preco, valorTotal);
                    }).toList();
         
                System.out.println("find all"+userTradeDTO);

            } else {
                userTradeRepository.findByPrazoContaining(prazoquery).forEach(userTrade::add);
            }

            if (userTrade.isEmpty()) {
                System.out.println("vazio");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(userTradeDTO, HttpStatus.OK);
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
                // compra
                // comprauserTradeRepository.findByTipoOperacao(tipoOperacao).forEach(userTrade::add);
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date dataFinal = formato.parse("2019-12-31");
                Date dataInicial = formato.parse("2019-01-01");
                userTradeQueryRepository.customQueryData(dataInicial, dataFinal).forEach(userTrade::add);
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



    @GetMapping("/usertrade/vendas")
    public ResponseEntity<List<Object>> getCompraUserTrade(@RequestParam(required = false) String name) {
        // Optional<UserTrade> userTradeData = userTradeRepository.findById(id);
        try {
            List<Object> userTrade = new ArrayList<Object>();
            // tipoOperacao = "C";
            System.out.println(name);
            if (name == null) {
                // return new ResponseEntity<>(userTradeData.get(), HttpStatus.OK);
             userTradeQueryRepository.fetchTradeData().forEach(userTrade::add);
             //   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                System.out.println("Buscar");
                 userTradeQueryRepository.fetchTradeData(name).forEach(userTrade::add);
            //    userTradeRepository.fetchTradeSelfData().forEach(userTrade::add);
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

                // System.out.println("getListComparandoPreco"+userTradeQueryRepository.getListComparandoPreco());
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
