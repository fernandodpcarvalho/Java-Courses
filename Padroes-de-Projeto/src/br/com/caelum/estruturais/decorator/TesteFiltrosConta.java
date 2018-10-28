package br.com.caelum.estruturais.decorator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.estruturais.decorator.Conta;
import br.com.caelum.estruturais.decorator.Filtro;
import br.com.caelum.estruturais.decorator.FiltroContaComDataDeAberturaMesCorrente;
import br.com.caelum.estruturais.decorator.FiltroSaldoMaiorQueQuinhentos;
import br.com.caelum.estruturais.decorator.FiltroSaldoMenorQueCem;

public class TesteFiltrosConta {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar mesPassado = Calendar.getInstance();		
		System.out.println(sdf.format(mesPassado.getTime()));

		mesPassado.add(Calendar.MONTH, -1);
		System.out.println(sdf.format(mesPassado.getTime()));
		
		mesPassado.add(Calendar.MONTH, -2);
		System.out.println(sdf.format(mesPassado.getTime()));
				
		List<Conta> contas = new ArrayList<>();
		contas.add(new Conta("Fernando", "12345", 80, "6288", mesPassado));
		contas.add(new Conta("Thais", "34567", 700, "4433", mesPassado));
		contas.add(new Conta("Karina", "56789", 300, "1267", Calendar.getInstance()));
		contas.add(new Conta("Marcia", "78901", 200, "6755", mesPassado));
		
		for (Conta conta : contas) {
			System.out.println("\nConta: "+conta.getNome()+" - Saldo: "+conta.getSaldo()+" - Data: "+sdf.format(conta.getDataAbertura().getTime()));
			System.out.println(new FiltroSaldoMenorQueCem().aplicaFiltro(conta));
			System.out.println(new FiltroSaldoMaiorQueQuinhentos().aplicaFiltro(conta));
			System.out.println(new FiltroContaComDataDeAberturaMesCorrente().aplicaFiltro(conta));
		}
		
		Filtro filtro = new FiltroSaldoMenorQueCem(new FiltroSaldoMaiorQueQuinhentos(new FiltroContaComDataDeAberturaMesCorrente()));
		
		for (Conta conta : contas) {
			System.out.println("\nConta: "+conta.getNome()+" - Saldo: "+conta.getSaldo()+" - Data: "+sdf.format(conta.getDataAbertura().getTime()));
			System.out.println(filtro.aplicaFiltro(conta));
		}
	}

}
