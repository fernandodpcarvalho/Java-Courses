package com.testes.jvm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EscapingReferencesTests {

	public static void main(String[] args) {
		
		System.out.println("\n*****Fix Escaping References in object return");
		Customer fernando = new Customer("Fernando", new Endereco("Rua Maria Daffre", 52));
		System.out.println(fernando);
		fernando.getEndereco().setNumero(88);
		System.out.println(fernando);
		Endereco endereco = fernando.getEndereco();
		endereco.setNumero(77);
		System.out.println(fernando);
		System.out.println(endereco);
		
		
		System.out.println("\n*****Fix Escaping References in Collection return");
		CustomerList records = new CustomerList();
		records.addCustomer(new Customer("Fernando", new Endereco("Rua Maria Daffre", 52)));
		records.addCustomer(new Customer("Thais", new Endereco("Rua Luis Murat", 90)));
		
		List<Customer> customersList = records.getCustomers();
		customersList.forEach(System.out::println);
		
//		customersList.remove(0);
//		customersList.forEach(System.out::println);

		customersList.get(0).setName("Fabio");
		customersList.forEach(System.out::println);
		
		Endereco endereco2 = customersList.get(0).getEndereco();
		System.out.println(endereco2);
		
		endereco2.setNumero(1111);
		System.out.println(customersList.get(0).getEndereco());
		
		//This customer cannot be modified, because it doesn't have any set method.
		//But it can be converted to a Customer 
		CustomerReadOnly customer = records.getCustomerByIndex(0);
		System.out.println(customer);
		Customer c = (Customer) customer;
		c.setName("NovoNome");
		System.out.println(customer);
		System.out.println(records.getCustomerByIndex(0));
	}
}

class CustomerList {
	private List<Customer> customers;

	public CustomerList() {
		this.setCustomers(new ArrayList<>());
	}
	
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}

	public List<Customer> getCustomers() {
//		return this.customers;
		return Collections.unmodifiableList(this.customers);
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public CustomerReadOnly getCustomerByIndex(int index) {
		return this.customers.get(index);
	}

	@Override
	public String toString() {
		return "CustomerList [customers=" + customers + "]";
	}
}

interface CustomerReadOnly {
	public abstract String getName();
	public abstract Endereco getEndereco();
	public abstract String toString();
}

class Customer implements CustomerReadOnly{
	private String name;
	private Endereco endereco;
	
	public Customer(String name, Endereco endereco) {
		this.setName(name);
		this.setEndereco(endereco);
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Endereco getEndereco() {
		return new Endereco(this.endereco);
//		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return this.name + " - " + this.endereco;
	}
}

class Endereco {
	private String rua;
	private int numero;
	
	public Endereco(String rua, int numero) {
		this.rua = rua;
		this.numero = numero;
	}

	public Endereco(Endereco endereco) {
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Endereco: " + rua + ", numero: " + numero;
	}
}
