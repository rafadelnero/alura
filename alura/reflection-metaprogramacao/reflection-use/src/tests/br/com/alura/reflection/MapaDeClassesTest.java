package br.com.alura.reflection;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.alura.modelo.PessoaNatural;

public class MapaDeClassesTest {
	
	@Test
	public void getListClassTest() throws Exception {
		MapaDeClasses mapaDeClasses = new MapaDeClasses();
		
		Class<?> classeArrayList = mapaDeClasses.getClass("java.util.List");
		
		Assert.assertTrue(List.class.isAssignableFrom(classeArrayList));
	}
	
	@Test
	public void getPessoaNaturalClassTest() throws Exception {
		MapaDeClasses mapaDeClasses = new MapaDeClasses();
		
		Class<?> classeArrayList = mapaDeClasses.getClass("br.com.alura.modelo.PessoaNatural");
		
		Assert.assertTrue(PessoaNatural.class.isAssignableFrom(classeArrayList));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void getObjectTest() throws Exception {
		MapaDeClasses mapaDeClasses = new MapaDeClasses();
		
		List classeArrayList = (List) mapaDeClasses.getObject("java.util.List");
		
		classeArrayList.add("teste");
		
		Assert.assertEquals("teste", classeArrayList.get(0).toString());
		Assert.assertEquals(1, classeArrayList.size());
	}
	
	@Test
	public void getObjectComParametroTest() throws Exception {
		MapaDeClasses mapaDeClasses = new MapaDeClasses();
		
		PessoaNatural pessoaNatural = (PessoaNatural) mapaDeClasses.getObject("br.com.alura.modelo.PessoaNatural", "Zezao");
		
		Assert.assertNotNull(pessoaNatural);
		Assert.assertEquals("Zezao", pessoaNatural.getNome());
	}
}
