package com.testes.jvm.gc;

/*
 * When a reference id of one object is referenced to a reference id of some
 * other object, then the previous object will have no reference to it any longer.
 * The object becomes unreachable and eligible for GC.
 */

class Teste2 {
	public static void main(String[] args) {
		System.out.println("*** Case 2: Re-assigning the reference variable ***");
		
		System.out.println("Create two Person objects p1 and p2");
		Person p1 = new Person("John Doe");
		Person p2 = new Person("Jane Doe");
		
		System.out.println("make p1 eligible for gc");
		p1 = p2;// p1 now referred to p2
		
		System.out.println("calling garbage collector");
		System.gc(); // p1 will be garbage-collected		
	}
}
