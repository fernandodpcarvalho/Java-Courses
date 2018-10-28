package br.com.alura.reflection;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Validador {
	
	public static boolean ValidarObjeto(Object obj) throws Exception{
		boolean resultado = true;
		
		Class<?> clazz = obj.getClass();
		
		for(Method m : clazz.getMethods()){
			if(m.getName().startsWith("validar") && 
					m.getReturnType() == boolean.class &&
					m.getParameterTypes().length == 0){
				Boolean retorno = (Boolean) m.invoke(obj);
				System.out.println("Resultado = "+retorno.booleanValue());
				resultado = resultado && retorno.booleanValue();
			}
		}
		
		return resultado;
	}

}
