package br.com.alura.solid;

public class TesteCalculaSalario {
	
	public static void main(String[] args) {
		
		Funcionario desenvolvedor = new Funcionario();
		desenvolvedor.setCargo(Cargo.DESENVOLVEDOR);
		desenvolvedor.setSalarioBase(1700);
		
		System.out.println(CalculadoraDeSalario.calcula(desenvolvedor));
		
	}
	
	
	
}
