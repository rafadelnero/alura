package br.com.alura.reflection;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.alura.modelo.PessoaNatural;

public class MapaDeAtributosTest {
	
	@Test
	public void getListClassTest() throws Exception {
		MapaDeAtributos mapaDeAtributos = new MapaDeAtributos();
		
		PessoaNatural pessoaNatural = new PessoaNatural("Zezao");
		pessoaNatural.setAltura(1.80);
		pessoaNatural.setIdade(77);
		pessoaNatural.setPeso(230);
		
		Map<String, Object> mapaComAtributos = mapaDeAtributos.getAtributos(pessoaNatural);
		
		Assert.assertEquals(1.80, (double) mapaComAtributos.get("altura"), 0.0001); 
	}
}
