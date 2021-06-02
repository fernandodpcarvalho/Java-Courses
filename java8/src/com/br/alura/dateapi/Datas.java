package com.br.alura.dateapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	
	public static void main(String[] args) {
		
		//toda data é imutável.
		
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDateTime hojeAgora = LocalDateTime.now();
		System.out.println(hojeAgora);
		
		LocalDate dataQualquer = LocalDate.of(2016, Month.JUNE, 5);
		System.out.println(dataQualquer);
		
		int ano = hojeAgora.getYear() - dataQualquer.getYear();
		System.out.println(ano);
		
		Period periodo = Period.between(dataQualquer, hoje);
		System.out.println(periodo);
		System.out.println(periodo.getDays());
		System.out.println(periodo.plusYears(4));
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hojeAgora.format(formatador));

		System.out.println(hojeAgora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
		
		System.out.println(LocalTime.of(15, 30));
		
		
	}
}
