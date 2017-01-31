package chain_of_responsability;

public class TestaDescontos {
	public static void main(String[] args) {
		CalculadorDeDescontos calculador = new CalculadorDeDescontos();

		Orcamento orcamento = new Orcamento(4.0);
		orcamento.adicionaItem(new Item("CANETA", 2.0));
		orcamento.adicionaItem(new Item("LAPIS", 2.0));

		double desconto = calculador.calcula(orcamento);

		System.out.println(desconto);
	}
}
