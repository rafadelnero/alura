package br.com.caelum.estoque.cliente;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ClienteEstoqueDinamico {
	public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8080/estoque-web/EstoqueWS?wsdl");
        QName qname = new QName("http://ws.estoque.caelum.com.br/", "EstoqueWS");
		
        Service service = Service.create(url, qname);

        EstoqueWS cliente = service.getPort(EstoqueWS.class);

        Filtro filtro = new Filtro();
		filtro.setNome("IPhone");
		filtro.setTipo(TipoItem.CELULAR);;

		Filtros filtros = new Filtros();
		filtros.getFiltro().add(filtro);

		ListaItens lista = cliente.todosOsItens(filtros);

        System.out.println(lista.item);
    }
}
