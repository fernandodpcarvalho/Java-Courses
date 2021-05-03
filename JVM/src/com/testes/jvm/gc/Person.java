package com.testes.jvm.gc;

class Person {
	String name;

	public Person(String name) {
		this.name = name;
		System.out.println("New person created: " + this.name);
	}

	@Override
	// Overriding finalize method to check which object is garbage collected
	protected void finalize() throws Throwable {
		System.out.println("Person object - " + this.name + " -> successfully garbage collected");
	}
}
