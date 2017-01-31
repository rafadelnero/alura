package br.com.meetup.livraria.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.meetup.livraria.dao.UsuarioDao;
import br.com.meetup.livraria.modelo.Usuario;

@Controller
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 2039182637211948417L;
	private Usuario usuario = new Usuario();

	@Inject
	private UsuarioDao usuarioDao;

	public Usuario getUsuario() {
		return usuario;
	}

	public String efetuaLogin() {
		System.out.println("fazendo login do usuario " + this.usuario.getEmail());

		boolean existe = usuarioDao.existe(this.usuario);
		if (existe) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "livro?faces-redirect=true";
		}

		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário não encontrado"));

		return "login?faces-redirect=true";
	}

	public String deslogar() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}
}
