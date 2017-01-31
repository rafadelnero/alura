package decorator;

class ImpostoIKCV extends TemplateDeImpostoCondicional {
	public ImpostoIKCV(Imposto outroImposto) {
		super(outroImposto);
	}

	public ImpostoIKCV() {
		super();
	}

	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() < 500 && temItemMaiorQue100ReaisNo(orcamento);
	}

	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.10 + calculoDoOutroImposto(orcamento);
	}

	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.06 + calculoDoOutroImposto(orcamento);
	}

	private boolean temItemMaiorQue100ReaisNo(Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if (item.getValor() > 100) {
				return true;
			}
		}

		return false;
	}
}
