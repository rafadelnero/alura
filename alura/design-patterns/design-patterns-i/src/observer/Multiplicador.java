package observer;

import builder.NotaFiscal;

public class Multiplicador implements AcaoAposGerarNota {
	private double fator;

	public Multiplicador(double fator) {
		this.fator = fator;
	}

	@Override
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("O valor da nota multiplicado é: " + (notaFiscal.getValorBruto() * this.fator));
	}
}
