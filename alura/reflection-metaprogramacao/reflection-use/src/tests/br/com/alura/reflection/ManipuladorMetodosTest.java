package br.com.alura.reflection;

import org.junit.Test;

public class ManipuladorMetodosTest {

	/**
	 * Invoca m�todos que iniciam com test, void e n�o possui par�metros.
	 * 
	 * @param objeto qualque objeto.
	 * @throws Exception se houver erro no processamento.
	 */
	@Test
	public void invocaMetodoComTesteSemRetornoTest() throws Exception {
		new ManipuladorMetodos().invocaMetodoComTesteSemRetorno(new BuscaAtributosTest());
	}

}
