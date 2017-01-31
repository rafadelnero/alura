package state_banco;

public class Conta {
	private String titular;
	protected double saldo;
	protected EstadoDaConta estadoDaConta;

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void deposita(double saldo) {
		this.saldo += saldo;
	}
}
