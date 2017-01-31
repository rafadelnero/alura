
public class ManipuladorDeSaldo {
	private double saldo;

	public void deposita(double valor) {
		this.saldo += valor;
	}

	public void saca(double valor) {
		if (valor <= this.saldo) {
			this.saldo -= valor;
		} else {
			throw new IllegalArgumentException("Saldo não disponível.");
		}
	}

	public double getSaldo() {
		return saldo;
	}

	public void somaInvestimento() {
		this.saldo += this.saldo * 0.01;
	}
}
