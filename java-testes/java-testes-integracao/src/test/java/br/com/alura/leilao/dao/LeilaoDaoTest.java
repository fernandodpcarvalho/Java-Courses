package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.LeilaoBuilder;
import br.com.alura.leilao.util.builder.UsuarioBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import java.math.BigDecimal;

class LeilaoDaoTest {

    private LeilaoDao dao;
    private EntityManager em;

    @BeforeEach
    private void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new LeilaoDao(em);
        em.getTransaction().begin();
    }

    @AfterEach
    private void afterEach() {
        em.getTransaction().rollback();
    }

    @Test
    void  deveCadastrarUmLeilao() {
        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678")
                .criar();
        em.persist(usuario);
        Leilao leilao = new LeilaoBuilder()
                .comNome("LeilaoTest")
                .comValorInicial(new BigDecimal("100.00"))
                .comUsuario(usuario)
                .criar();
        Leilao leilaoSalvo = this.dao.salvar(leilao);
        Assert.assertEquals(leilaoSalvo, this.dao.buscarPorId(leilaoSalvo.getId()));
    }

    @Test
    void deveAtualizarUmLeilao() {
        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678")
                .criar();
        em.persist(usuario);
        Leilao leilao = new LeilaoBuilder()
                .comNome("LeilaoTest")
                .comValorInicial(new BigDecimal("100.00"))
                .comUsuario(usuario)
                .criar();
        leilao = this.dao.salvar(leilao);
        leilao.setNome("leilaoAtualizadoTest");
        leilao.setValorInicial(new BigDecimal("300.00"));
        Leilao leilaoAtualizado = this.dao.salvar(leilao);
        Assert.assertEquals("leilaoAtualizadoTest", this.dao.buscarPorId(leilaoAtualizado.getId()).getNome());
        Assert.assertEquals(new BigDecimal("300.00"), this.dao.buscarPorId(leilaoAtualizado.getId()).getValorInicial());
    }
}