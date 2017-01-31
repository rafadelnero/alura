package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {
	
	@EJB
	private AutorDao autorDao;
	
	public void adiciona(Autor autor) {
		autorDao.salva(autor);
	}
	
	public List<Autor> todosAutores() {
		return autorDao.todosAutores();
	}
}
