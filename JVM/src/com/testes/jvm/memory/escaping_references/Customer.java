package com.testes.jvm.memory.escaping_references;

public class Customer implements CustomerReadOnly {
	private String name;

	//Strings are immutable. Won't be modified from outside 
	public Customer(String name) {
		this.name = name;
	}
	//To allow protect the object name on CustomerRecords class
	public Customer(CustomerReadOnly oldCustomer) {
		this.name = oldCustomer.getName();
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
