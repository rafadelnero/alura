package strategy;

public class RealizadorDeInvestimentos {
	public void executa(Conta conta, Investimento investimento) {
		double valorRetornoInvestimento = investimento.calcula(conta);
		conta.deposita(valorRetornoInvestimento);
	}
}
