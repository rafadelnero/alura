package interpeter_visitor;

public class RaizQuadrada implements Expressao {
	
	private Expressao expressao;

	public RaizQuadrada(Expressao expressao) {
		super();
		this.expressao = expressao;
	}

	@Override
	public int avalia() {
		return (int) Math.sqrt(expressao.avalia());
	}

	@Override
	public void aceita(Visitor visitor) {
		visitor.visitaRaizQuadrada(this);
	}

	public Expressao getExpressao() {
		return expressao;
	}

}
