package br.com.caelum.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

//imports omitidos

@Stateless
@Remote(Servico.class)
public class ServicoBean implements Servico {
	public void executa() {
		// executa a logica de negocios
		System.out.println("recebendo chamada remota");
	}
}