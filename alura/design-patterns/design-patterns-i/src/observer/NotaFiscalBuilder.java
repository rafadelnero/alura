package observer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import builder.ItemDaNota;
import builder.NotaFiscal;

public class NotaFiscalBuilder {
	private String razaoSocial;
	private String cnpj;

	private List<ItemDaNota> todosItens = new ArrayList<>();
	private double impostos;
	private double valorBruto;
	private String observacoes;
	private Calendar data;

	private List<AcaoAposGerarNota> todasAcoesASeremExecutadas = new ArrayList<>();

	public NotaFiscalBuilder(List<AcaoAposGerarNota> todasAcoesASeremExecutadas) {
		this.todasAcoesASeremExecutadas = todasAcoesASeremExecutadas;
	}

	public NotaFiscalBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;

		return this;
	}

	public NotaFiscalBuilder comCnpj(String cnpj) {
		this.cnpj = cnpj;

		return this;
	}

	public NotaFiscalBuilder naDataAtual() {
		this.data = Calendar.getInstance();

		return this;
	}

	public NotaFiscalBuilder comItem(ItemDaNota item) {
		this.todosItens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0;

		return this;
	}

	public NotaFiscalBuilder comObservacoes(String observacoes) {
		this.observacoes = observacoes;

		return this;
	}

	public void adicionaAcao(AcaoAposGerarNota novaAcao) {
		this.todasAcoesASeremExecutadas.add(novaAcao);
	}

	public NotaFiscal constroi() {
		NotaFiscal notaFiscal = new NotaFiscal(razaoSocial, cnpj, data, valorBruto, impostos, todosItens, observacoes);

		for (AcaoAposGerarNota acao : this.todasAcoesASeremExecutadas) {
			acao.executa(notaFiscal);
		}

		return notaFiscal;
	}
}
