package strategy;

public class Conservador implements Investimento {

	@Override
	public double calcula(Conta conta) {
		return (conta.getValorSaldo() * 0.008) * 0.75;
	}
}
