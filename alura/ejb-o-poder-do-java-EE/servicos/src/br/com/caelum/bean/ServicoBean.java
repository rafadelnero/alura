package br.com.caelum.bean;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(Servico.class)
public class ServicoBean implements Servico, Serializable {

	private static final long serialVersionUID = 7200267041060686396L;

	public void executa() {
		// executa a logica de negocios
		System.out.println("recebendo chamada remota");
	}
	
	public static void main(String[] args) {
		Integer lol = null;
		
		teste(lol);
	}
	
	public static void teste(int teste) {
		System.out.println(teste);
	}
}