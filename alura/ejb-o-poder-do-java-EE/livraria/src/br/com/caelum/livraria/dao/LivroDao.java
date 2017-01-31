package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Livro;

@Stateless
@Interceptors({LogInterceptador.class})
public class LivroDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void salva(Livro livro) {
		manager.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return manager.createQuery("select livro from Livro livro", Livro.class).getResultList();
	}

	public List<Livro> livrosPeloTitulo(String titulo) {
		TypedQuery<Livro> query = manager.createQuery("select livro from Livro livro where livro.titulo like :titulo", Livro.class)
				.setParameter("titulo", "%" + titulo + "%");
		
		return  query.getResultList();
	}
	
}
