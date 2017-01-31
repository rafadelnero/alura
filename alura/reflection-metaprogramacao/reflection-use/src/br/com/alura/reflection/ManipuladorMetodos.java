package br.com.alura.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ManipuladorMetodos {

	/**
	 * Invoca métodos que acabam com Test, void e não possui parâmetros.
	 * 
	 * @param objeto qualque objeto.
	 * @throws IllegalArgumentException se houver erro
	 * @throws IllegalAccessException se houver erro
	 * @throws Exception se houver erro no processamento.
	 */
	public void invocaMetodoComTesteSemRetorno(Object objeto) throws IllegalAccessException, IllegalArgumentException {
		for (Method metodo : objeto.getClass().getMethods()) {
			boolean comecaComTest = metodo.getName().endsWith("Test");
			boolean ehVoid = metodo.getReturnType().equals(void.class);
			boolean ehSemParametro = metodo.getParameters().length == 0;
			
			if (comecaComTest && ehVoid && ehSemParametro) {
				try {
					metodo.invoke(objeto);
				} catch (InvocationTargetException exception) {
					exception.getTargetException().printStackTrace();
				}
			}
		}
	}

}
