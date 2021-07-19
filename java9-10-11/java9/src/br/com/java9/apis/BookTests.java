package br.com.java9.apis;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BookTests {

	public static void main(String[] args) {
//		Books.all().forEach(System.out::println);

		// Filtrar livros de programação e agrupar por autor
		System.out.println("### Não exibe os vazios ###");
		Books.all().stream().filter(b -> b.getCategories().contains(Category.PROGRAMMING))
				.collect(Collectors.groupingBy(Book::getAuthor)) // retorna um mapa <String, List<Book>>
				.forEach((s, b) -> System.out.println(s + b + "\n"));

		System.out.println("\n\n\n### Aqui exibe os vazios ###");
		Books.all().stream().collect(Collectors.groupingBy(Book::getAuthor,
				Collectors.filtering(b -> b.getCategories().contains(Category.PROGRAMMING), Collectors.toList())))
		.forEach((s, b) -> System.out.println(s + b + "\n"));
		
		//Ver:
		//flatMapping
		//Optional ifPresentOrElse
		//Optional.stream
		//Optional.or
	}
}

class Book {
	private final String name;
	private final String author;
	private final List<Category> categories;

	public Book(String name, String author, Category... categories) {
		this.name = name;
		this.author = author;
		this.categories = List.of(categories);
	}

	public String getAuthor() {
		return author;
	}

	public String getName() {
		return name;
	}

	public List<Category> getCategories() {
		return categories;
	}

	@Override
	public String toString() {
		return "\nlivro: " + name + "\nautor: " + author + "\ncategorias: " + categories;
	}
}

enum Category {
	PROGRAMMING, DESIGN, AGILE, CERTIFICATION, BUSINESS
}

class Books {
	public static List<Book> all() {
		return List.of(new Book("Desbravando Java", "Rodrigo Turini", Category.PROGRAMMING),
				new Book("APIs Java", "Rodrigo Turini", Category.PROGRAMMING),
				new Book("Certificação Java", "Guilherme Silveira", Category.PROGRAMMING, Category.CERTIFICATION),
				new Book("TDD", "Mauricio Aniche", Category.PROGRAMMING, Category.AGILE),
				new Book("SOLID", "Mauricio Aniche", Category.PROGRAMMING),
				new Book("Guia da Startup", "Joaquim Torres", Category.BUSINESS));
	}
}
