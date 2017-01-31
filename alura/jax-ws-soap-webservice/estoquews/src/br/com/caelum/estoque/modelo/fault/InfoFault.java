package br.com.caelum.estoque.modelo.fault;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.caelum.estoque.modelo.adapter.DateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {
	
	private String mensagem;
	@XmlJavaTypeAdapter(DateAdapter.class) 
	private Date dataErro;

	public InfoFault() {
		super();
	}

	public InfoFault(final String mensagem, final Date dataErro) {
		this.mensagem = mensagem;
		this.dataErro = dataErro;
	}

	public Date getDataErro() {
		return dataErro;
	}

	public void setDataErro(Date dataErro) {
		this.dataErro = dataErro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
