package com.Teste.spring.jpa.postgresql.repository;

import com.Teste.spring.jpa.postgresql.model.UserTrade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserTradeQueryRepository {

    @PersistenceContext
    private EntityManager em;

    public List<UserTrade> customQueryData(Date dataInicial, Date dataFinal) {
        String query = "from UserTrade iq  where iq.data  between :dataInicial and :dataFinal";
        TypedQuery<UserTrade> typedQuery = em.createQuery(query, UserTrade.class);
        typedQuery.setParameter("dataInicial", dataInicial);
        typedQuery.setParameter("dataFinal", dataFinal);

        return typedQuery.getResultList();

    }

    public List<UserTrade> getListComparandoPreco() {
        // Query query = em.createNativeQuery("SELECT ut.id , ut.\"data\", ut.preco,
        // ut.tipo_operacao, ut.mercado, ut.prazo, ut.instrument, ut.especificacao,
        // ut.quantidade, ut.valor_total"+
        // iq.price as precoAnterior,
        // SELECT ut.preco as precoDaCompra, ut.tipo_operacao as operacao, ut.prazo as
        // sigla, ut.instrument as nome, ut.quantidade as quantidade
        // " left join instrument_quote iq on (iq.simbol = ut.prazo and iq.\"date\" =
        // ut.\"data\") "+
        String query = " SELECT   ut.preco , ut.tipoOperacao , ut.prazo , ut.instrument , ut.quantidade  " +
                " FROM UserTrade ut " +
                " where ut.tipoOperacao = 'V'and ut.prazo = 'VVAR3F' ";
        TypedQuery<UserTrade> typedQuery = em.createQuery(query, UserTrade.class);
        System.out.println(typedQuery);
        System.out.println(typedQuery.getResultList());
        // List<Object[]> resultList = query.getResultList();
        return typedQuery.getResultList();

    }

    public List<UserTrade> getListPreco(String tipoOperacao) {
        String query = "from UserTrade iq  where iq.tipoOperacao =  :tipoOperacao";
        TypedQuery<UserTrade> typedQuery = em.createQuery(query, UserTrade.class);
        typedQuery.setParameter("tipoOperacao", tipoOperacao);

        return typedQuery.getResultList();

    }


    public List<Object[]> fetchTradeData(String name) {
        String jpql = """
                SELECT iq.price as precoAnterior, ut.preco as precoDaCompra,
                       ut.tipoOperacao as operacao, ut.prazo as sigla, ut.instrument as nome,
                       ut.quantidade as quantidade, to_char(ut.data, 'YYYY-MM-dd') as data
                FROM UserTrade ut
                LEFT JOIN InstrumentQuote iq ON iq.simbol = ut.prazo AND iq.date = ut.data
                WHERE (ut.tipoOperacao = 'V' OR ut.tipoOperacao = 'C') AND ut.prazo = :custName
                """;

        TypedQuery<Object[]> query = em.createQuery(jpql,Object[].class);
        query.setParameter("custName", name);
        System.out.println("query.getResultList()");
        System.out.println(query.getResultList());
        return query.getResultList();
    }



        public List<Object[]> fetchTradeData() {
        String jpql = """
                SELECT iq.price as precoAnterior, ut.preco as precoDaCompra,
                       ut.tipoOperacao as operacao, ut.prazo as sigla, ut.instrument as nome,
                       ut.quantidade as quantidade, to_char(ut.data, 'YYYY-MM-dd') as data
                FROM UserTrade ut
                LEFT JOIN InstrumentQuote iq ON iq.simbol = ut.prazo AND iq.date = ut.data
                WHERE ut.tipoOperacao = 'V' OR ut.tipoOperacao = 'C'
                """;

        TypedQuery<Object[]> query = em.createQuery(jpql,Object[].class);

        System.out.println("query.getResultList()");
        System.out.println(query.getResultList());
        return query.getResultList();
    }

}