package chain_of_responsability;

public class DescontoPorVendaCasada implements Desconto {
	private Desconto proximo;
	private String LAPIS = "LAPIS";
	private String CANETA = "CANETA";

	@Override
	public double desconta(Orcamento orcamento) {
		if (existe(orcamento)) {
			return orcamento.getValor() * 0.05;
		} else {
			return proximo.desconta(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

	private boolean existe(Orcamento orcamento) {
		boolean achouPrimeiroItem = false;
		boolean achouSegundoItem = false;

		for (Item item : orcamento.getItens()) {
			if (item.getNome().equals(LAPIS))
				achouPrimeiroItem = true;
			else if (item.getNome().equals(CANETA)) {
				achouSegundoItem = true;
			}
		}

		return achouPrimeiroItem && achouSegundoItem;
	}

}
