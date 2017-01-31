package observer;

import builder.NotaFiscal;

public class EnviadorDeEmail implements AcaoAposGerarNota {
	public void enviaPorEmail(NotaFiscal notaFiscal) {
		System.out.println("enviando por e-mail.");
	}

	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("enviando por e-mail.");
	}
}
