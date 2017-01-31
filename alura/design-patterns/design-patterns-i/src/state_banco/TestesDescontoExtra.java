package state_banco;

public class TestesDescontoExtra {
	public static void main(String[] args) {
		Conta conta = new Conta();

		EstadoDaConta estado = new Positivo();
		estado.saca(conta, 100);

		System.out.println(conta.saldo);

		estado.saca(conta, 100);
	}
}
