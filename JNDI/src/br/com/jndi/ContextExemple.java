package br.com.jndi;

import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.CompositeName;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import br.com.jndi.model.Pessoa;

public class ContextExemple {

	public static void main(String[] args) throws NamingException {
		//Pode-se criar um hashtable ou referenciar um arquivo properties 
		Hashtable<String, String> environment = new Hashtable<String, String>();

		environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
		environment.put(Context.PROVIDER_URL, "file:/home/fernando/Documents/TI/temp/");
		Context context = new InitialContext(environment);
		context.destroySubcontext("newSubContext");
		context.createSubcontext("newSubContext");
		
		Pessoa fernando = new Pessoa("Fernando Carvalho", 36, "Rua Maria Daffre 52");
		context.unbind("pessoa");
		context.bind("pessoa", fernando);
		recoverObject(context, "pessoa");

		Pessoa fabio = new Pessoa("Fabio Carvalho", 37, "Rua Engenheiro Cesar Polilo");
		context.rebind("pessoa", fabio);
		recoverObject(context, "pessoa");
		context.unbind("pessoa");
		
		context.unbind("Fernando");
		context.bind("Fernando", fernando);
		recoverObject(context, "Fernando");
		
		context.unbind("Fabio");
		context.bind("Fabio", fabio);
		recoverObject(context, "Fabio");
		
		System.out.println("------------");
		
		NamingEnumeration<Binding> contextData = context.listBindings("");
		while(contextData.hasMore()) {
			Binding binding = contextData.next();
			System.out.format("%s | %s", binding.getName(), binding.getClassName());
			if(binding.getObject() instanceof File) {
				System.out.format(" | size %s bytes", ((File) binding.getObject()).length());
			}
		}

		System.out.println("------------");
		Name objectName = new CompositeName("java:comp/env/jdbc");
		Enumeration<String> elements = objectName.getAll();
		while(elements.hasMoreElements()) {
		  System.out.println(elements.nextElement());
		}
		
		objectName.add("example");
		elements = objectName.getAll();
		while(elements.hasMoreElements()) {
		  System.out.println(elements.nextElement());
		}
	}

	private static void recoverObject(Context context, String objectName) throws NamingException {
		Object objectLookup = context.lookup(objectName);
		Pessoa pessoaLookup = (Pessoa) objectLookup;
		System.out.println(pessoaLookup.getClass().getName());
		System.out.println(pessoaLookup);
	}

}
