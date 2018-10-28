import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class APIDatas {
	public static void main(String[] args) {
		
		//criando localDate com data atual
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		//Criando data específica
		LocalDate data1 = LocalDate.of(2099, Month.JANUARY, 25);
		LocalDate data2 = LocalDate.of(2099, 1, 25);
		
		//Calculando intervalo de tempo
		Period periodo = Period.between(hoje, data1);
		
		//Obtendo somente ano, mês ou dia.
		System.out.println(periodo.getYears());
		System.out.println(periodo.getMonths());
		System.out.println(periodo.getDays());
		
		//Outra forma de calcular intervalo
		int anos = data1.getYear() - hoje.getYear();
		
		//datas anteriores
		System.out.println(hoje.minusYears(1));
		System.out.println(hoje.minusMonths(4));
		System.out.println(hoje.minusDays(2));

		//datas posteriores
		System.out.println(hoje.plusYears(1));
		System.out.println(hoje.plusMonths(4));
		System.out.println(hoje.plusDays(2));
		
		//formatando datas
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorFormatado = hoje.format(formatador);
		System.out.println(valorFormatado);

		//horas
		LocalDateTime agora = LocalDateTime.now();
		
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorComHoras));
		
	}
}
