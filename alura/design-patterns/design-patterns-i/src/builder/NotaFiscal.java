package builder;

import java.util.Calendar;
import java.util.List;

public class NotaFiscal {
	private String razaoSocial;
	private String cnpj;
	private Calendar dataDaEmissao;
	private double valorBruto;
	private double impostos;
	public List<ItemDaNota> itens;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Calendar getDataDaEmissao() {
		return dataDaEmissao;
	}

	public double getValorBruto() {
		return valorBruto;
	}

	public double getImpostos() {
		return impostos;
	}

	public List<ItemDaNota> getItens() {
		return itens;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public NotaFiscal(String razaoSocial, String cnpj, Calendar dataDaEmissao, double valorBruto, double impostos,
			List<ItemDaNota> itens, String observacoes) {
		super();
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.dataDaEmissao = dataDaEmissao;
		this.valorBruto = valorBruto;
		this.impostos = impostos;
		this.itens = itens;
		this.observacoes = observacoes;
	}

	public String observacoes;

}
