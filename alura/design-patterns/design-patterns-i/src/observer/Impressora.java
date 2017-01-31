package observer;

import builder.NotaFiscal;

public class Impressora implements AcaoAposGerarNota {
	public void imprime(NotaFiscal notaFiscal) {
		System.out.println("Imprimindo nota fiscal.");
	}

	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("Imprimindo nota fiscal.");
	}
}
