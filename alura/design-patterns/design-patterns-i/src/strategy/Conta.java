package strategy;

public class Conta {
	private double valorSaldo;

	public double getValorSaldo() {
		return valorSaldo;
	}

	public void deposita(double valorSaldo) {
		this.valorSaldo += valorSaldo;
	}

}
