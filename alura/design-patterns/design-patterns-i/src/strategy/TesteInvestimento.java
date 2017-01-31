package strategy;

public class TesteInvestimento {
	public static void main(String[] args) {
		Investimento conservador = new Conservador();
		Investimento moderado = new Moderado();
		Investimento arrojado = new Arrojado();

		Conta conta = new Conta();
		conta.deposita(1000);

		RealizadorDeInvestimentos realizadorDeInvestimentos = new RealizadorDeInvestimentos();

		realizadorDeInvestimentos.executa(conta, conservador);
		System.out.println(conta.getValorSaldo());
		realizadorDeInvestimentos.executa(conta, moderado);
		System.out.println(conta.getValorSaldo());
		realizadorDeInvestimentos.executa(conta, arrojado);
		System.out.println(conta.getValorSaldo());
	}
}
