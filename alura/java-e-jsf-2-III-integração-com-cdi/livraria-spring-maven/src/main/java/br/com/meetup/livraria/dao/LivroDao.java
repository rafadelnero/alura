package br.com.meetup.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.meetup.livraria.modelo.Livro;

@Repository
public class LivroDao implements Serializable {

	private static final long serialVersionUID = 3574297513809088365L;

	@PersistenceContext
	private EntityManager em;
	
	private DAO<Livro> dao;
	
	@PostConstruct
	public void inicia() {
		dao = new DAO<Livro>(em, Livro.class);
	}

	public void adiciona(Livro t) {
		dao.adiciona(t);
	}

	public void atualiza(Livro t) {
		dao.atualiza(t);
	}

	public List<Livro> listaTodos() {
		return dao.listaTodos();
	}

	public Livro buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}

	public void remove(Livro livro) {
		dao.remove(livro);
	}

}
