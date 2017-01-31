package br.com.alura.regrasalario.porcentagemsalario;

import br.com.alura.regrasalario.Funcionario;

public class DezOuVintePorcento implements RegraSalario {

	@Override
	public double calcula(Funcionario funcionario) {
		 if(funcionario.getSalarioBase() > 3000.0) {
	            return funcionario.getSalarioBase() * 0.8;
	        }
	        else {
	            return funcionario.getSalarioBase() * 0.9;
	        }
	}

}
