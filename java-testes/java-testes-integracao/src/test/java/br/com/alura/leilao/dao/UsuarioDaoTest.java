package br.com.alura.leilao.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;

class UsuarioDaoTest {

	private UsuarioDao dao;
	private EntityManager em;

	@BeforeEach
	private void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new UsuarioDao(em);
		em.getTransaction().begin();
	}

	@AfterEach
	private void afterEach() {
		em.getTransaction().rollback();
	}

	@Test
	void deveEncontrarUsuarioCadastrado() {
		Usuario usuario = criarUsuario();
		Assert.assertNotNull(this.dao.buscarPorUsername(usuario.getNome()));
	}

	@Test
	void NaoDeveEncontrarUsuarioNaoCadastrado() {cute
		Usuario usuario = criarUsuario();
		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("Beltrano"));
	}

	@Test
	void deveRemoverUmUsuario() {
		Usuario usuario = criarUsuario();
		dao.deletar(usuario);
		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername((usuario.getNome())));
	}

	private Usuario criarUsuario() {
		Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
		em.persist(usuario);
		return usuario;
	}
}
