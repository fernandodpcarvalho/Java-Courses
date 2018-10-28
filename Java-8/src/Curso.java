import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}


class TestaCurso {	
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));	
		
		//Ordenação 1
		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		//Stream
		Stream<Curso> streamDeCurso = cursos.stream();
		
		//Ex: Filtro
		//Exemplo 1: Não funciona, pois o stream não modifica o objeto. As ações devem ser veitas numa tacada só.
		streamDeCurso = cursos.stream().filter(c -> c.getAlunos() > 100);
		cursos.forEach(c -> System.out.println(c.getNome()));
		
		//Aqui funciona
		cursos.stream()
			  .filter(c -> c.getAlunos() > 100)
			  .forEach(c -> System.out.println(c.getNome()));
		
		
		
		cursos.stream()
		   	  .filter(c -> c.getAlunos() > 100)
		   	  .map(c -> c.getAlunos())
		      .forEach(x -> System.out.println(x));
		
		int soma = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso::getAlunos)
				   .sum();	
		
		//Optional permite trabalhar com possíveis nulos sem necessidade de validar com if
		Optional<Curso> curso = cursos.stream()
									  .filter(c -> c.getAlunos() > 100)
									  .findAny();
		
		
		//Gerando uma coleção a partir de um stream
		List<Curso> resultados = cursos.stream()
				   						.filter(c -> c.getAlunos() > 100)
				   						.collect(Collectors.toList());
		
		Map mapa = cursos.stream() 
					 	 .filter(c -> c.getAlunos() > 100) 
					 	 .collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
		cursos.stream().filter(c -> c.getAlunos() > 50).findFirst();
		
		cursos.stream().mapToInt(c -> c.getAlunos()).average();
		
	}
}
