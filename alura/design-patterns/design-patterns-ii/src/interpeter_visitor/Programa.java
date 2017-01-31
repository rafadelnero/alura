package interpeter_visitor;

public class Programa {
	public static void main(String[] args) {
		Impressora impressora = new Impressora();
		
		Soma expressaoSoma = new Soma(new Numero(3), new Numero(5));
		impressora.visitaSoma(expressaoSoma);
		
		Subtracao expressaoSubtracao = new Subtracao(expressaoSoma, new Numero(3));
		impressora.visitaSubtracao(expressaoSubtracao);
		
		RaizQuadrada expressaoRaizQuadrada = new RaizQuadrada(expressaoSubtracao);
		impressora.visitaRaizQuadrada(expressaoRaizQuadrada);
		
		Soma expressaoSoma2 = new Soma(expressaoRaizQuadrada, new Numero(10));
		impressora.visitaSoma(expressaoSoma2);
		
		Soma expressaoSoma3 = new Soma(expressaoRaizQuadrada, expressaoSoma2);
		impressora.visitaSoma(expressaoSoma3);
		
		System.out.println(expressaoSoma3.avalia());
	}
}
