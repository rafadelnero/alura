package interpeter_visitor;

public class Impressora implements Visitor {
	
	@Override
	public void visitaSoma(Soma soma) {
		System.out.print(" + ");
		System.out.print(" ( ");
		soma.getEsquerda().aceita(this);
		
		
		soma.getDireita().aceita(this);
		System.out.print(" ) ");
	}
	
	@Override
	public void visitaSubtracao(Subtracao subtracao) {
		System.out.print(" - ");
		System.out.print(" ( ");
		subtracao.getEsquerda().aceita(this);
		
		
		subtracao.getDireita().aceita(this);
		System.out.print(" ) ");
	}
	
	@Override
	public void visitaNumero(Numero numero) {
		System.out.print(numero.getNumero());
	}

	@Override
	public void visitaMultiplicacao(Multiplicacao multiplicacao) {
		System.out.print(" * ");
		System.out.print(" ( ");
		
		multiplicacao.getEsquerda().aceita(this);
		
		
		multiplicacao.getDireita().aceita(this);
		System.out.print(" ) ");
	}

	@Override
	public void visitaDivisao(Divisao divisao) {
		System.out.print(" / ");
		System.out.print(" ( ");
		divisao.getEsquerda().aceita(this);
		
		
		divisao.getDireita().aceita(this);
		System.out.print(" ) ");
	}

	@Override
	public void visitaRaizQuadrada(RaizQuadrada raizQuadrada) {
		System.out.print("Raiz quadrada:");
		raizQuadrada.getExpressao().aceita(this);
	}

}
