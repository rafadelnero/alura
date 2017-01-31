package strategy;

import java.util.Random;

public class Arrojado implements Investimento {
	@Override
	public double calcula(Conta conta) {
		double chance = new Random().nextDouble();
		if (chance <= 0.20) {
			return (conta.getValorSaldo() * 0.05) * 0.75;
		} else if (chance <= 0.50) {
			return (conta.getValorSaldo() * 0.03) * 0.75;
		} else {
			return (conta.getValorSaldo() * 0.006) * 0.75;
		}
	}
}
