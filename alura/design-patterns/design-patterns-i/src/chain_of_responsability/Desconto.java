package chain_of_responsability;

public interface Desconto {
	double desconta(Orcamento orcamento);

	void setProximo(Desconto proximo);
}
