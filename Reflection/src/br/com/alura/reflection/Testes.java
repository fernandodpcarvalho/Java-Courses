package br.com.alura.reflection;
import java.util.List;
import java.util.Map;

public class Testes {
	
	public static void main(String[] args) throws Exception {
		Mapeador m = new Mapeador();
		m.load("classes.prop");
		System.out.println(m.getImplementacao(List.class));
		System.out.println(m.getImplementacao(Map.class));
		
		Class<?> clazz = Class.forName("Mapeador");
		System.out.println(clazz.getFields());
		System.out.println(clazz.getMethods());

		List lista = (List) m.getInstancia(List.class);
		System.out.println(lista.getClass());
		
		lista = m.getInstanciaE(List.class);
		System.out.println(lista.getClass());
		
		InterfaceExemplo i = m.getInstanciaE(InterfaceExemplo.class, "teste");
		System.out.println(i.getClass());
		
		Usuario usuario = new Usuario("fe", "123456789", "fe@gmail.com", "Oxe", true);
		GeradorXML g = new GeradorXML();
		System.out.println(g.getXML(usuario));
		
		System.out.println("\n");
		
		Validador validador = new Validador();
		System.out.println("Validador = "+validador.ValidarObjeto(usuario));
		
		System.out.println("\n");
		
		usuario.setEmail("semArroba");
		System.out.println("Validador = "+validador.ValidarObjeto(usuario));
		
		
	}
}
