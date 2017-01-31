package br.com.caelum.livraria.dao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	@EJB
	private AutorDao autorDao;

	public Usuario buscaPeloLogin(String login) {
		return this.manager.createQuery("select usuario from Usuario usuario where usuario.login like :login", Usuario.class)
				.setParameter("login", login).getSingleResult();
	}

}
