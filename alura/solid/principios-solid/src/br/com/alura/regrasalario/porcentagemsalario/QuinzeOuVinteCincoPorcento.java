package br.com.alura.regrasalario.porcentagemsalario;

import br.com.alura.regrasalario.Funcionario;

public class QuinzeOuVinteCincoPorcento implements RegraSalario {

	@Override
	public double calcula(Funcionario funcionario) {
		 if(funcionario.getSalarioBase() > 2000.0) {
	            return funcionario.getSalarioBase() * 0.75;
	        }
	        else {
	            return funcionario.getSalarioBase() * 0.85;
	        }
	}

}
