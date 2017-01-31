package br.com.alura.calculoprecos;

public class Teste {
	public static void main(String[] args) {
		Compra compra = new Compra();
		compra.setCidade("Sao Paulo");
		compra.setValor(4000);
		
		System.out.println(new CalculadoraDePrecos(new TabelaDePrecoPadrao(), new Frete()).calcula(compra));
	}
}
