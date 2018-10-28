package br.com.alura.solid;

public class CalculadoraDeSalario {

	public static double calcula(Funcionario funcionario) {
		return funcionario.getCargo().getRegra().calcula(funcionario);
	}
}
