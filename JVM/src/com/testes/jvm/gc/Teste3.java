package com.testes.jvm.gc;

/*
 * Methods are stored inside a Stack in LIFO (Last In — First Out) order. When
 * such method is popped out from the Stack, all its members die and if some
 * objects were created inside it, then these objects also become unreachable,
 * thus eligible for GC.
 */

class Teste3 {

	static void createMale() {
		// object p1 inside method becomes unreachable after createMale() completes
		System.out.println("Method createMale(): Create a Person object p1");
		Person p1 = new Person("John Doe");

		createFemale();

		System.out.println("GC Call inside createMale()");
		System.gc(); // p2 will be garbage-collected
	}

	static void createFemale() {
		// object p2 inside method becomes unreachable after createFemale() completes
		System.out.println("Method createFemale: Create a Person object p2");
		Person p2 = new Person("Jane Doe");
	}

	public static void main(String args[]) {
		System.out.println("*** Case 3: Object created inside method ***");

		createMale();

		System.out.println("\nGC Call inside main()");
		System.gc(); // p1 will be garbage-collected

	}
}
