package template_method;

class ImpostoICPP extends TemplateDeImpostoCondicional {

	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() < 500;
	}

	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}

	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}
}
