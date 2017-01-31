package decorator;

public class TesteImpostoMuitoAlto {
	public static void main(String[] args) {
		Imposto imposto = new ImpostoMuitoAlto(new ISS());

		Orcamento orcamento = new Orcamento(500.0);

		System.out.println(imposto.calcula(orcamento));
	}
}
