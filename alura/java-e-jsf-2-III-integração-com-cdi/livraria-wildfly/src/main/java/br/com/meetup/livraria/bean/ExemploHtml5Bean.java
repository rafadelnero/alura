package br.com.meetup.livraria.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ExemploHtml5Bean implements Serializable {
	private static final long serialVersionUID = 6895599338081487342L;

	private String email;

	public final String getEmail() {
		System.out.println(email);
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}
}
