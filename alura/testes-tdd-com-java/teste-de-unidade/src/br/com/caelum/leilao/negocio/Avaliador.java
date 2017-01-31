package br.com.caelum.leilao.negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {
	private double menorLance = Double.POSITIVE_INFINITY;
	private double maiorLance = Double.NEGATIVE_INFINITY;
	
	private List<Lance> maiores;

	public void avalia(Leilao leilao) {
		if (leilao.getLances().size() == 0) {
			throw new RuntimeException("Não há lances para serem avaliados.");
		}
		
		for (Lance lance : leilao.getLances()) {
			if (menorLance > lance.getValor()) {
				menorLance = lance.getValor();
			}

			if (maiorLance < lance.getValor()) {
				maiorLance = lance.getValor();
			}
		}

		pegaOsMaioresNo(leilao);
	}

	private void pegaOsMaioresNo(Leilao leilao) {
		maiores = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maiores, new Comparator<Lance>() {
			public int compare(Lance o1, Lance o2) {
				if (o1.getValor() < o2.getValor())
					return 1;
				if (o1.getValor() > o2.getValor())
					return -1;
				return 0;
			}
		});
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
	}

	public double calculaValorMedioDosLances(Leilao leilao) {
		double valorTotalDosLances = 0.0;

		for (Lance lance : leilao.getLances()) {
			valorTotalDosLances += lance.getValor();
		}

		return valorTotalDosLances / leilao.getLances().size();
	}

	public double getMenorLance() {
		return menorLance;
	}

	public double getMaiorLance() {
		return maiorLance;
	}

	public List<Lance> getTresMaiores() {
		return this.maiores;
	}
}
