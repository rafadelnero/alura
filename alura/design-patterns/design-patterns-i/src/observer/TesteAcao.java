package observer;

import java.util.ArrayList;
import java.util.List;

import builder.ItemDaNota;
import builder.NotaFiscal;

public class TesteAcao {
	public static void main(String[] args) {
		List<AcaoAposGerarNota> acoesAposGerarNotas = new ArrayList<>();
		acoesAposGerarNotas.add(new EnviadorDeEmail());
		acoesAposGerarNotas.add(new Impressora());
		acoesAposGerarNotas.add(new NotaFiscalDao());
		acoesAposGerarNotas.add(new EnviadorDeSms());
		acoesAposGerarNotas.add(new Multiplicador(5));
		NotaFiscalBuilder builder = new NotaFiscalBuilder(acoesAposGerarNotas);

		NotaFiscal notaFiscal = builder.paraEmpresa("Caelum").comCnpj("321312321")
				.comItem(new ItemDaNota("Item 1", 50)).comItem(new ItemDaNota("Item 2", 70))
				.comObservacoes("Entregar notaFiscal").naDataAtual().constroi();
	}
}
