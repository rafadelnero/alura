package observer;

import builder.NotaFiscal;

public class EnviadorDeSms implements AcaoAposGerarNota {
	public void enviaPorSms(NotaFiscal notaFiscal) {
		System.out.println("Enviando por sms.");
	}

	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("Enviando por sms.");
	}
}
