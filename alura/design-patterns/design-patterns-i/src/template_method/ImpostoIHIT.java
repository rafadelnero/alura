package template_method;

class ImpostoIHIT extends TemplateDeImpostoCondicional {

	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return temIDoisNomesIguaisItens(orcamento);
	}

	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.13 + 100;
	}

	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.01;
	}

	private boolean temIDoisNomesIguaisItens(Orcamento orcamento) {
		int i = 0;
		for (Item item : orcamento.getItens()) {
			Item itemAux = item;

			if (item.getNome().equals(itemAux.getNome()) && i++ > 0) {
				return true;
			}
		}
		return false;
	}
}
