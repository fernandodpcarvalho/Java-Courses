package br.com.caelum.estruturais.adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Data {
	  public Calendar hoje() {
	    return Calendar.getInstance();
	  }
	  
	  public String hoje_formatado(){
		  return new SimpleDateFormat("dd/MM//YYYY").format(Calendar.getInstance().getTime());
	  }
	  
	  
	}
