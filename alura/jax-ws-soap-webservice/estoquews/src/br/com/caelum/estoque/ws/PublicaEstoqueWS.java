package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaEstoqueWS {
	public static void main(String[] args) {
		EstoqueWS estoqueWS = new EstoqueWS();
		String URL = "http://localhost:8080/estoquews";
		
		System.out.println("Estoque WS rodando: " + URL);
		
		Endpoint.publish(URL, estoqueWS);
	}
}
