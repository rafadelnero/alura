package br.com.meetup.livraria.bean;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class TesteApplicationScopedBean implements Serializable {

	private static final long serialVersionUID = 4432365549527738382L;
	
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
