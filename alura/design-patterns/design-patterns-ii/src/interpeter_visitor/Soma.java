package interpeter_visitor;

public class Soma implements Expressao {
	
	private final Expressao esquerda;
	private final Expressao direita;
	
	public Soma(Expressao esquerda, Expressao direita) {
		super();
		this.esquerda = esquerda;
		this.direita = direita;
	}

	@Override
	public int avalia() {
		return esquerda.avalia() + direita.avalia();
	}

	@Override
	public void aceita(Visitor visitor) {
		visitor.visitaSoma(this);
	}

	public Expressao getEsquerda() {
		return esquerda;
	}

	public Expressao getDireita() {
		return direita;
	}

}
