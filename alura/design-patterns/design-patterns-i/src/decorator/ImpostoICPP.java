package decorator;

class ImpostoICPP extends TemplateDeImpostoCondicional {
	public ImpostoICPP(Imposto outroImposto) {
		super(outroImposto);
	}

	public ImpostoICPP() {
		super();
	}

	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() < 500;
	}

	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05 + calculoDoOutroImposto(orcamento);
	}

	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.07 + calculoDoOutroImposto(orcamento);
	}
}
