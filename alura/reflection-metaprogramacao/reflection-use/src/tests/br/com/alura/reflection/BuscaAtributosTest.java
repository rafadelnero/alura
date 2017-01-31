package br.com.alura.reflection;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.alura.modelo.Produto;

public class BuscaAtributosTest {

	@Test
	public void buscaStringNosAtributosPublicosDaClasseComNomeProdutoTest()
			throws IllegalArgumentException, IllegalAccessException {
		Produto produto = new Produto();

		List<Object> listaDeAtributos = new BuscaAtributos().buscaStringNosAtributosPublicosDaClasse
				(produto, "Playstation");

		Assert.assertEquals("Playstation", listaDeAtributos.get(0).toString());
	}
	
	@Test
	public void buscaStringNosAtributosPublicosDaClasseComPrecoProdutoTest()
			throws IllegalArgumentException, IllegalAccessException {
		Produto produto = new Produto();
		
		List<Object> listaDeAtributos = new BuscaAtributos().buscaStringNosAtributosPublicosDaClasse
				(produto, 399.00);
		
		Assert.assertEquals(399.00, listaDeAtributos.get(0));
	}
	
	@Test
	public void buscaStringNaoExistenteNosAtributosPublicosDaClasseTest()
			throws IllegalArgumentException, IllegalAccessException {
		Produto produto = new Produto();
		
		List<Object> listaDeAtributos = new BuscaAtributos().buscaStringNosAtributosPublicosDaClasse
				(produto, "Playstations");
		
		Assert.assertTrue(listaDeAtributos.isEmpty());
	}
	
	@Test
	public void lancaExceptionTest() throws Exception {
		throw new Exception();
	}
}
