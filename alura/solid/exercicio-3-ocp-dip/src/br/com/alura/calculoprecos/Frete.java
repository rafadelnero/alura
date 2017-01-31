package br.com.alura.calculoprecos;
public class Frete implements ServicoDeEntrega {
	
	@Override
    public double para(String cidade) {
        if("SAO PAULO".equalsIgnoreCase(cidade.toUpperCase())) {
            return 15;
        }
        return 30;
    }
}