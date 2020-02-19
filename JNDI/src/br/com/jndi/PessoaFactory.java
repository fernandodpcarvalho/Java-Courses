package br.com.jndi;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

import br.com.jndi.model.Pessoa;

public class PessoaFactory implements ObjectFactory{

	@Override
	public Object getObjectInstance(Object obj, Name name, Context context, Hashtable<?, ?> environment) throws Exception {
		if(!(obj instanceof Reference)) return null;
		
		Reference reference = (Reference) obj;
		
		if(!Pessoa.class.getName().equals(reference.getClassName())) return null;
		
		Pessoa pessoa = new Pessoa();
		Enumeration<RefAddr> addresses = reference.getAll();
		while(addresses.hasMoreElements()) {
			RefAddr address = addresses.nextElement();
			switch (address.getType()) {
			case Pessoa.NAME:
				pessoa.setName(address.getContent().toString());
				break;
			case Pessoa.AGE:
				pessoa.setAge(Integer.parseInt(address.getContent().toString()));
				break;
			case Pessoa.ADDRESS:
				pessoa.setAddress(address.getContent().toString());
				break;
			}
		}
		return pessoa;
	}
}
