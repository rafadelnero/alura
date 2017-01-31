package strategy;

import java.util.Random;

public class Moderado implements Investimento {

	@Override
	public double calcula(Conta conta) {
		double chance = new Random().nextDouble();
		if (chance <= 0.50) {
			return (conta.getValorSaldo() * 0.025) * 0.75;
		} else {
			return (conta.getValorSaldo() * 0.070) * 0.75;
		}
	}

}
