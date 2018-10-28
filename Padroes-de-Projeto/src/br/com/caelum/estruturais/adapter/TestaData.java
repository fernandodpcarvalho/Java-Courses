package br.com.caelum.estruturais.adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestaData {
	
	public static void main(String[] args) {
		Data data = new Data();
		
		Calendar hoje = data.hoje();
		
		System.out.println(new SimpleDateFormat("dd/MM//YYYY").format(hoje.getTime()));
		
		System.out.println(data.hoje_formatado());
		
	}

}
