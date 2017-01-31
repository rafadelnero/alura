package br.com.alura.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MapaDeAtributos {
	
	public Map<String, Object> getAtributos(Object objeto) throws Exception {
		Map<String, Object> mapaComAtributos = new HashMap<>();
		
		for (Field field : objeto.getClass().getDeclaredFields()) {
			if (!field.isAccessible()) {
				field.setAccessible(true);
			}
			
			mapaComAtributos.put(field.getName(), field.get(objeto));
		}
		
		return mapaComAtributos;
	}
}
