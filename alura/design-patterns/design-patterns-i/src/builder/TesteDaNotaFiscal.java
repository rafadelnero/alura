package builder;

public class TesteDaNotaFiscal {
	public static void main(String[] args) {
		NotaFiscalBuilder builder = new NotaFiscalBuilder();
		builder.paraEmpresa("Caelum ensino e inovação").comCnpj("4324234242342")
				.comItem(new ItemDaNota("Item 1", 200.0)).comItem(new ItemDaNota("Item 2", 400.0))
				.comItem(new ItemDaNota("Item 2", 500.0)).comItem(new ItemDaNota("item 3", 300.0))
				.comObservacoes("entregar nf pessoalment").naDataAtual().constroi();

		NotaFiscal notaFiscal = builder.constroi();

		System.out.println(notaFiscal.getValorBruto());
	}
}
