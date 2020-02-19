package br.com.jndi.model;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

import br.com.jndi.PessoaFactory;

public class Pessoa implements Referenceable {
	
	public static final String NAME = "name";
	public static final String AGE = "age";
	public static final String ADDRESS = "address";

	private String name;
	private int age;
	private String address;
	
	public Pessoa() {}
	
	public Pessoa(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public Reference getReference() throws NamingException {
//		To return only the class references (fields, name, etc) 
//		Reference reference = new Reference(Pessoa.class.getName());
		//To return an object of Pessoa 
		Reference reference = new Reference(Pessoa.class.getName(), PessoaFactory.class.getName(), null);
		reference.add(new StringRefAddr("name", this.name));
		reference.add(new StringRefAddr("age", Integer.toString(this.age)));
		reference.add(new StringRefAddr("address", this.address));
		return reference;
	}

	@Override
	public String toString() {
		return "Pessoa [name=" + name + ", age=" + age + ", address=" + address + "]\n";
	}
}
