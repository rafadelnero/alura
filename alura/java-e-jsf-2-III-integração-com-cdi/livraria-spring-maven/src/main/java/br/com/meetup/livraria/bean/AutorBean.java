package br.com.meetup.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.com.meetup.livraria.dao.AutorDao;
import br.com.meetup.livraria.modelo.Autor;

@Controller
public class AutorBean implements Serializable {

	private static final long serialVersionUID = -8864576577481472949L;

	private Autor autor = new Autor();
	
	private Integer autorId;
	
	@Inject
	private AutorDao autorDao;

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public void carregarAutorPelaId() {
		this.autor = autorDao.buscaPorId(autorId);
	}
	
	@Transactional
	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if(this.autor.getId() == null) {
			autorDao.adiciona(this.autor);
		} else {
			autorDao.atualiza(this.autor);
		}

		this.autor = new Autor();

		return "livro?faces-redirect=true";
	}
	
	@Transactional
	public void remover(Autor autor) {
		System.out.println("Removendo autor " + autor.getNome());
		autorDao.remove(autor);
	}
	
	public List<Autor> getAutores() {
		return autorDao.listaTodos();
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
