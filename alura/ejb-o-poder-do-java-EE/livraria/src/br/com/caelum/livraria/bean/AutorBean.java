package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;

import br.com.caelum.livraria.modelo.Autor;

@Model
public class AutorBean {
	
	private Autor autor = new Autor();
	
	@EJB
	private AutorService autorService;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() {
		autorService.adiciona(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return autorService.todosAutores();
	}
}
