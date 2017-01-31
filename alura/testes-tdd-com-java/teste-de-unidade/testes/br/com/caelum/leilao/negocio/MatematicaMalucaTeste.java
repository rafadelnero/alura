package br.com.caelum.leilao.negocio;

import org.junit.Assert;
import org.junit.Test;

public class MatematicaMalucaTeste {
	
	@Test
	public void deveCalcularComNumeroMaiorQueTrinta() {
		MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
		int contaMaluca = matematicaMaluca.contaMaluca(40);
		
		Assert.assertEquals(160, contaMaluca, 0);
	} 
	
	@Test
	public void deveCalcularComNumeroMaiorQueDez() {
		MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
		int contaMaluca = matematicaMaluca.contaMaluca(20);
		
		Assert.assertEquals(60, contaMaluca, 0);
	}
	@Test
	public void deveCalcularComNumeroMenorQueOnze() {
		MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
		int contaMaluca = matematicaMaluca.contaMaluca(10);
		
		Assert.assertEquals(20, contaMaluca, 0);
	}
}
