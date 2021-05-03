package com.testes.jvm.memory.escaping_references;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomerRecords implements Iterable<Customer>{
	private Map<String, Customer> records;
	
	public CustomerRecords() {
		this.records = new HashMap<String, Customer>();
	}
	
	public void addCustomer(Customer c) {
		this.records.put(c.getName(), c);
	}
	
	//This way allow escaping references
	public Map<String, Customer> getCustomers() {
		return this.records; 
	}	
	
	//This way protect the internal map from escaping references
	public Map<String, Customer> getProtectedCustomers() {
		return Collections.unmodifiableMap(this.records);
	}	
	
	//This way does not protect the internal map from escaping references
	//Because it only returns a copy of the map, but this map still points to the same Customer objects  
	public Map<String, Customer> getCustomersMapCopy() {
		return new HashMap<String, Customer>(this.records);
	}
	
	public Customer getCustomerByName(String name) {
//		return this.records.get(name); //unprotected return
		return new Customer(this.records.get(name)); //protected - return only a copy
	}

	//Better way to protect
	public CustomerReadOnly getReadOnlyCustomerByName(String name) {
		return this.records.get(name);
	}

	@Override
	public Iterator<Customer> iterator() {
		return records.values().iterator();
	}
}
