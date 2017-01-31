package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Autor;

public class AutorDao implements Serializable {
	
	private static final long serialVersionUID = 6078347564284431965L;

	@Inject
	private EntityManager em;
	
	private DAO<Autor> dao;
	
	@PostConstruct
	public void inicia() {
		dao = new DAO<Autor>(em, Autor.class);
	}

	public List<Autor> listaTodos() {
		return dao.listaTodos();
	}

	public Autor buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}

	public void atualiza(Autor autor) {
		dao.atualiza(autor);
	}

	public void adiciona(Autor autor) {
		dao.adiciona(autor);
	}

	public void remove(Autor autor) {
		dao.remove(autor);
	}
}
