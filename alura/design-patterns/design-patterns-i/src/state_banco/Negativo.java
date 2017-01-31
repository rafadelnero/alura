package state_banco;

public class Negativo implements EstadoDaConta {
	@Override
	public void saca(Conta conta, double valor) {
		throw new RuntimeException("Sua conta está no vermelho. Não é possível sacar!");
	}

	@Override
	public void deposita(Conta conta, double valor) {
		if (conta.saldo > 0) {
			conta.estadoDaConta = new Positivo();
		}
	}
}
