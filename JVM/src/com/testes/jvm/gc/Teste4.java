package com.testes.jvm.gc;

/*
 * An object becomes unreachable and eligible for GC when its reference id is
 * not assigned to a variable.
 */

class Teste4 {

	public static void main(String args[]) {
		System.out.println("*** Case 4: Anonymous object ***");

		System.out.println("Create a Person object without assignment to a variable");
		new Person("John Doe");

		// object cannot be used since no variable assignment, thus it becomes eligible for gc

		System.out.println("calling garbage collector");
		System.gc(); // object will be garbage-collected
	}
}
