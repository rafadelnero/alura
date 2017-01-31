package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		if (podeDarLance(lance)) {
			lances.add(lance);
		}
	}
	
	private boolean podeDarLance(Lance lance) {
		if (lance.getValor() <= 0) {
			throw new IllegalArgumentException("O valor do lance não pode ser menor ou igual a 0.");
		}
		
		return lances.isEmpty() || !temDoisLancesSeguidosPor(lance.getUsuario()) && totalDeLancesDoUsuario(lance.getUsuario())  < 5;
	}

	private int totalDeLancesDoUsuario(Usuario usuario) {
		int total = 0;
		
		for (Lance lanceDado : lances) {
			if (usuario.equals(lanceDado.getUsuario())) {
				total++;
			}
		}
		
		return total;
	}
	
	public Lance dobraLance(Usuario usuario) {
		double valorDoUltimoLance = ultimoLanceDo(usuario);
		
		if (valorDoUltimoLance > 0) {
			return new Lance(usuario, valorDoUltimoLance * 2);
		} 
		
		throw new IllegalArgumentException("O usuário não efetuou lance para ser dobrado.");
	}

	private double ultimoLanceDo(Usuario usuario) {
		for (int indice = lances.size() - 1; indice >= 0; indice--) {
			if (lances.get(indice).getUsuario().equals(usuario)) {
				return lances.get(indice).getValor();
			}
		}
		
		return 0;
	}

	private boolean temDoisLancesSeguidosPor(Usuario usuario) {
		return ultimoLanceDado().equals(usuario);
	}

	private Usuario ultimoLanceDado() {
		return lances.get(lances.size() - 1).getUsuario();
	}
	
	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}
}
