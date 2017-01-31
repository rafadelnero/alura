package state_banco;

public class Positivo implements EstadoDaConta {

	@Override
	public void saca(Conta conta, double valor) {
		conta.saldo -= valor;

		if (conta.saldo < 0) {
			conta.estadoDaConta = new Negativo();
		}

	}

	@Override
	public void deposita(Conta conta, double valor) {
		conta.saldo += valor * 0.98;

	}

}
