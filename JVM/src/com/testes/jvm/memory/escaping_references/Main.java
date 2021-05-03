package com.testes.jvm.memory.escaping_references;

import java.util.Set;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();

		records.addCustomer(new Customer("John"));
		records.addCustomer(new Customer("Simon"));
		for (CustomerReadOnly next : records) {
			System.out.println(next);
		}

		Set<String> customerNames = records.getCustomers().keySet();

		System.out.println("1)Get the private records map from CustomerRecords and try to modify its values");
		for (String cn : customerNames) {
			records.getCustomers().put(cn, new Customer("Modified " + cn));
		}
		for (CustomerReadOnly next : records) {
			System.out.println(next);
		}

//		System.out.println("2)Get the private protectedRecords map from CustomerRecords and try to modify its values");
//		System.out.println("Cause the java.lang.UnsupportedOperationException");
//		for (String cn : customerNames) {
//			records.getProtectedCustomers().put(cn, new Customer("UnModified " + cn));
//		}
//		for (Customer next : records) {
//			System.out.println(next);
//		}
		
		System.out.println("3)Getting a customer name and try modify it");
		Customer john = records.getCustomerByName("John");
		System.out.println(john.getName());
		john.setName("Derek");
		System.out.println(john.getName());
		for (CustomerReadOnly next : records) {
			System.out.println(next);
		}
		
		//Read only Customer - Without set method.
		CustomerReadOnly johnReadOnly = records.getReadOnlyCustomerByName("John");		
		System.out.println(johnReadOnly.getName());
	}
}
