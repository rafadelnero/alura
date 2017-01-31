package br.com.meetup.livraria.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class TesteSessionScopedBean implements Serializable {

	private static final long serialVersionUID = 44323527738382L;
	
	private int numero;
	
	public void soma() {
		numero++;
	}

	public final int getNumero() {
		return numero;
	}

	public final void setNumero(int numero) {
		this.numero = numero;
	}
}
