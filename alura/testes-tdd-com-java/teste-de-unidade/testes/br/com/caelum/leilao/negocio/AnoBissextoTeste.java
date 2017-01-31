package br.com.caelum.leilao.negocio;

import org.junit.Assert;
import org.junit.Test;

public class AnoBissextoTeste {
	
	@Test 
	public void deveSerBissextoTest() {
		Assert.assertTrue(AnoBissexto.ehBissexto(4));
		Assert.assertTrue(AnoBissexto.ehBissexto(16));
		Assert.assertTrue(AnoBissexto.ehBissexto(20));
		Assert.assertTrue(AnoBissexto.ehBissexto(24));
		Assert.assertTrue(AnoBissexto.ehBissexto(28));
		Assert.assertTrue(AnoBissexto.ehBissexto(400));
		Assert.assertTrue(AnoBissexto.ehBissexto(800));
		Assert.assertTrue(AnoBissexto.ehBissexto(1200));
	}
	
	@Test 
	public void naoDeveSerBissextoTest() {
		Assert.assertFalse(AnoBissexto.ehBissexto(1));
		Assert.assertFalse(AnoBissexto.ehBissexto(2));
		Assert.assertFalse(AnoBissexto.ehBissexto(3));
		Assert.assertFalse(AnoBissexto.ehBissexto(5));
		Assert.assertFalse(AnoBissexto.ehBissexto(100));
		Assert.assertFalse(AnoBissexto.ehBissexto(90));
		Assert.assertFalse(AnoBissexto.ehBissexto(500));
		Assert.assertFalse(AnoBissexto.ehBissexto(600));
		Assert.assertFalse(AnoBissexto.ehBissexto(700));
	}
}
