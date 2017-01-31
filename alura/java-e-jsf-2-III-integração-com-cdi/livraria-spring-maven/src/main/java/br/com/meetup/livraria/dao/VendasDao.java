package br.com.meetup.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.meetup.livraria.modelo.Venda;

@Repository
public class VendasDao implements Serializable {
	
	private static final long serialVersionUID = 2838932623762886736L;

	@PersistenceContext
	private EntityManager manager;
	
	public List<Venda> getVendas() {
		List<Venda> vendas = manager.createQuery("select v from Venda v", Venda.class).getResultList();
		
		return vendas;
	}
}
