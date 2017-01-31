package br.com.alura.reflection;

import org.junit.Test;

public class ManipuladorMetodosTest {

	/**
	 * Invoca métodos que iniciam com test, void e não possui parâmetros.
	 * 
	 * @param objeto qualque objeto.
	 * @throws Exception se houver erro no processamento.
	 */
	@Test
	public void invocaMetodoComTesteSemRetornoTest() throws Exception {
		new ManipuladorMetodos().invocaMetodoComTesteSemRetorno(new BuscaAtributosTest());
	}

}
