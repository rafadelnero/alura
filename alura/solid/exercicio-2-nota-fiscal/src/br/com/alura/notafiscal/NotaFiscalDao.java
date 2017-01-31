package br.com.alura.notafiscal;

public class NotaFiscalDao implements AcaoAposGerarNota {

	@Override
	public void executa(NotaFiscal notaFiscal) {
		persiste(notaFiscal);
	}
	
	private void persiste(NotaFiscal nf) {
		System.out.println("Nota fiscal persistida!");
	}
}