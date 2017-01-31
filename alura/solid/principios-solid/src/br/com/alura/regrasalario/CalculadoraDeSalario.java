package br.com.alura.regrasalario;

public class CalculadoraDeSalario {
	public double calcula(Funcionario funcionario) {
       System.out.println(funcionario.calculaSalario());

        throw new RuntimeException("funcionario invalido");
    }
}
