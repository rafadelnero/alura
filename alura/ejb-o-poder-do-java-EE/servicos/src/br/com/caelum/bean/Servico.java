package br.com.caelum.bean;

import javax.ejb.Remote;

@Remote
public interface Servico {
	
	public void executa();
}
