package br.com.book.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReflectionTestes {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Pessoa fernando = new Pessoa("Fernando", 37);
		Carro fit = new Carro("Fit", "Prata", 80.00);

		System.out.println("---Listando variáveis---");
		Map<String, Object> props = GeradorMapa.gerarMapa(fernando);
		for (String prop : props.keySet()) {
			System.out.println(prop + " = " + props.get(prop));
		}

		System.out.println("\n---Listando variáveis e anotações---");
		props = GeradorMapa.gerarMapa(fit);
		for (String prop : props.keySet()) {
			System.out.println(prop + " = " + props.get(prop));
		}

		System.out.println("\n---Obter instância de Class a partir de uma referência estática de classes---");
		Class<String> classeString = String.class;
		System.out.println(classeString.getName());
		System.out.println(classeString.getModifiers());
		// Usando Class com tipo genérico
		Class<?> classeInteger = Integer.class;
		System.out.println(classeInteger.getName());

		System.out.println("\n---Obter instância de Class a partir de um Objeto---");
		String nome = "Fernando";
		System.out.println("Class name: " + nome.getClass().getName());

		
		System.out.println("\n---Obter instância de Class a partir arquivo de propriedades---");
		try {
			FornecedorImplementacoes f = new FornecedorImplementacoes("properties.properties");
			Class<?> impl = f.getImplementacao(Animal.class);
			System.out.println("Implementação recuperada: " + impl.getName());
			//criar obj
			Animal gato = (Animal) impl.newInstance();
			System.out.println("Objeto: "+gato);			
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Problemas ao obter implementações:" + e.getMessage());
		}

	}

}

class GeradorMapa {
	public static Map<String, Object> gerarMapa(Object o) {
		Class<?> classe = o.getClass();
		Map<String, Object> mapa = new HashMap<>();
		for (Method m : classe.getMethods()) {
			try {
				if (isGetter(m)) {
					String propriedade = null;
					if (m.isAnnotationPresent(NomePropriedade.class)) {
						propriedade = m.getAnnotation(NomePropriedade.class).value();
					} else {
						propriedade = deGetterParaPropriedade(m.getName());
					}
					Object valor = m.invoke(o);
					mapa.put(propriedade, valor);
				}
			} catch (Exception e) {
				throw new RuntimeException("Problema ao gerar o mapa", e);
			}
		}
		return mapa;
	}

	private static boolean isGetter(Method m) {
		return m.getName().startsWith("get") && m.getReturnType() != void.class && m.getParameterTypes().length == 0
				&& !m.isAnnotationPresent(Ignorar.class);
	}

	private static String deGetterParaPropriedade(String nomeGetter) {
		StringBuffer retorno = new StringBuffer();
		retorno.append(nomeGetter.substring(3, 4).toLowerCase());
		retorno.append(nomeGetter.substring(4));
		return retorno.toString();
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface Ignorar {
}

@Retention(RetentionPolicy.RUNTIME)
@interface NomePropriedade {
	String value();
}

class FornecedorImplementacoes {
	private Map<Class<?>, Class<?>> implementacoes = new HashMap<>();

	public FornecedorImplementacoes(String nomeArquivo) throws IOException, ClassNotFoundException {
		Properties p = new Properties();
		p.load(new FileInputStream(nomeArquivo));
		System.out.println(p);
		for (Object interf : p.keySet()) {
			Class<?> interfType = Class.forName(interf.toString());
			Class<?> implType = Class.forName(p.get(interf).toString());
			implementacoes.put(interfType, implType);
		}
	}

	public Class<?> getImplementacao(Class<?> interf) {
		return implementacoes.get(interf);
	}
}
