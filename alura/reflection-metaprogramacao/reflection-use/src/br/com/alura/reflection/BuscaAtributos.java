package br.com.alura.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class BuscaAtributos {
	public List<Object> buscaStringNosAtributosPublicosDaClasse(Object objeto, Object valor)
			throws IllegalArgumentException, IllegalAccessException {
		List<Object> atributosComString = new ArrayList<>();

		Class<?> classe = objeto.getClass();

		for (Field campo : classe.getFields()) {
			if (campo.getModifiers() == Modifier.PUBLIC && campo.get(objeto).equals(valor)) {
				atributosComString.add(campo.get(objeto));
			}
		}
	
		return atributosComString;
	}
}
