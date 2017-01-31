package br.com.alura.notafiscal;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		AcaoAposGerarNota enviadorDeEmail = new EnviadorDeEmail();

		List<AcaoAposGerarNota> acoesAposGerarNota = new ArrayList<>();
		acoesAposGerarNota.add(enviadorDeEmail);
		acoesAposGerarNota.add(new EnviadorDeEmail());
		
		GeradorDeNotaFiscal geradorDeNotaFiscal = new GeradorDeNotaFiscal(acoesAposGerarNota);
		
		geradorDeNotaFiscal.gera(new Fatura());
	}
}
