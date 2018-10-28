package br.com.alura.reflection;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Mapeador {
	private Map<Class<?>, Class<?>> mapa = new HashMap<>();
	
	public void load(String nomeArquivo) throws Exception{
		Properties p = new Properties();
		p.load(new FileInputStream(nomeArquivo));
		for (Object key : p.keySet()) {
			Class<?> interf = Class.forName(key.toString());
			Class<?> impl   = Class.forName(p.get(key).toString());
			
			if(!interf.isAssignableFrom(impl)) throw new RuntimeException("A classe "+impl.getName()+" não implementa "+interf.getName());
			
			mapa.put(interf, impl);
		}
	}
	
	public Class<?> getImplementacao(Class<?> interf){
		return mapa.get(interf);
	}

	public Object getInstancia(Class<?> interf) throws Exception {
		Class<?> impl = mapa.get(interf);
		return impl.newInstance();
	}

	@SuppressWarnings("unchecked")
	public <E> E getInstanciaE(Class<E> interf) throws Exception {
		Class<?> impl = mapa.get(interf);
		return (E) impl.newInstance();
	}
	

	//Usando construtor com parâmetros.
	@SuppressWarnings("unchecked")
	public <E> E getInstanciaE(Class<E> interf, Object... params) throws Exception {
		Class<?> impl = mapa.get(interf);
		//Buscar os construtores da classe
		Class<?>[] construtores = new Class<?>[params.length];
		for(int i=0;i<construtores.length;i++){
			construtores[i] = params[i].getClass();
		}
		Constructor<?> c = impl.getConstructor(construtores);
		return (E) c.newInstance(params);
	}
}
