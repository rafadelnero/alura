package com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.casadocodigo.loja.model.Produto;

@Repository
@Transactional
public class ProdutoDao {

	@PersistenceContext
	private EntityManager manager;

	public void grava(Produto produto) {
		manager.persist(produto);
	}

	public List<Produto> buscaTodos() {
		return manager.createQuery("from Produto", Produto.class).getResultList();
	}

	public Produto busca(long idProduto) {
		return manager.createQuery("select distinct(produto) from Produto produto "
				+ "join fecth produto.precos preco where produto.id = :id", Produto.class)
				.setParameter("id", idProduto).getSingleResult();
	}
}
