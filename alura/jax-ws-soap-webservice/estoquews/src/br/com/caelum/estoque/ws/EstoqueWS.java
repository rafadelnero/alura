package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;
import br.com.caelum.estoque.ws.exception.AutorizacaoException;

@WebService
//@SOAPBinding(style=Style.DOCUMENT,parameterStyle=ParameterStyle.BARE)
public class EstoqueWS {
	private ItemDao dao = new ItemDao();

	@RequestWrapper(localName = "listaItens")
	@ResponseWrapper(localName = "itens")
	@WebMethod(operationName = "todosOsItens")
	@WebResult(name = "itens")
	public List<Item> getItens(@WebParam(name = "filtros") Filtros filtros) {
		System.out.println("Chamando todosItens()");
		List<Filtro> lista = filtros.getLista();

		return dao.todosItens(lista);
	}

	@WebMethod(operationName = "CadastrarItem")
	public Item cadastrarItem(@WebParam(name = "token", header = true) TokenUsuario token,
			@WebParam(name = "item") Item item) throws AutorizacaoException {
		System.out.println("Cadastrando: " + item + ", " + token);

		if (!new TokenDao().ehValido(token)) {
			throw new AutorizacaoException("Autorização falhou");
		}
		
		new ItemValidador(item).validate();

		this.dao.cadastrar(item);
		return item;
	}
	
	@Oneway
	@WebMethod(exclude = true, operationName = "GeraPDF")
	public void geraPDF(@WebParam(name = "item") Item item) {
		System.out.println("Gerando PDF....");
	}

	@WebMethod(exclude = true)
	public void metodoNaoUsado() {

	}
}
