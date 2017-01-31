package br.com.caelum.estoque.ws.exception;

import java.util.Date;

import javax.xml.ws.WebFault;

import br.com.caelum.estoque.modelo.fault.InfoFault;

@WebFault(name="AutorizacaoFault", messageName="AutorizacaoFault")
public class AutorizacaoException extends Exception {

	private static final long serialVersionUID = 3808665396670957168L;
	
	public AutorizacaoException(String mensagem) {
		super(mensagem);
	}
	 
	public InfoFault getFaultInfo() {
		return new InfoFault("Token inválido", new Date());
	}
}
