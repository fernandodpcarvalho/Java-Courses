package testes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Testes {

	public static void main(String[] args) {
		

//		System.out.println(new Date());
//
//		System.out.println(new Date().getTime());
//		
//		System.out.println(TimeZone.getDefault());
		
		Date agora = new Date();
		System.out.println(agora);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(formatter.format(agora));
		
		// usar um timezone específico
		formatter.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		// formatando a data atual
		System.out.println(formatter.format(new Date()));
		
		
		// mudar o timezone padrão
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));
		SimpleDateFormat formatter_Tokyo = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(formatter_Tokyo.format(agora));
		
		//ISO 8601:
		SimpleDateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		System.out.println(iso8601Format.format(agora));
		

	}

}
