package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Venda;

public class VendasDao implements Serializable {
	
	private static final long serialVersionUID = 2838932623762886736L;

	@Inject
	private EntityManager manager;
	
	public List<Venda> getVendas() {
		List<Venda> vendas = manager.createQuery("select v from Venda v", Venda.class).getResultList();
		
		return vendas;
	}
}
