package br.com.caelum.leilao.builder;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoBuilder {
	
	private Leilao leilao;
	
	public LeilaoBuilder(String descricao) {
		leilao = new Leilao(descricao);
	}
	
	public LeilaoBuilder lance(Usuario usuario, double valor) {
		leilao.propoe(new Lance(usuario, valor));
		
		return this;
	}
	
	public LeilaoBuilder dobraLance(Usuario usuario) {
		leilao.propoe(leilao.dobraLance(usuario));
		
		return this;
	}
	
	public Leilao constroi() {
		return leilao;
	}
}
