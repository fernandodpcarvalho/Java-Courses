package com.testes.jvm.gc;

/*
 * When a reference variable of an object are changed to NULL, the object
 * becomes unreachable and eligible for GC.
 */

class Teste1 {
	public static void main(String[] args) {
		System.out.println("*** Case 1: Nullifying the reference variable ***");
		
		System.out.println("Create a Person object p1");
		Person p1 = new Person("John Doe");
		
		System.out.println("Making p1 eligible for gc");
		p1 = null;
		
		System.out.println("calling garbage collector");
		System.gc(); // p1 will be garbage-collected
		
//		another way to call gc:
//		Runtime.getRuntime().gc()
	}
}
