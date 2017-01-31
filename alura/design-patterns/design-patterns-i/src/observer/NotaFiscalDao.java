package observer;

import builder.NotaFiscal;

public class NotaFiscalDao implements AcaoAposGerarNota {
	public void salvaNoBanco(NotaFiscal notaFiscal) {
		System.out.println("Salvando no banco.");
	}

	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("Salvando no banco.");
	}
}
