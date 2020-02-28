package com.testes.jvm;

class Person {
	Person p = null;
	String nome;
	
	public Person(String nome) {
		this.nome = nome;
		System.out.println("Creating object: "+nome);
	}
	@Override
	protected void finalize() {
		System.out.println("Destroying object: "+this+"");
	}
	@Override
	public String toString() {
		return this.nome;
	}
}

public class GarbageCollectionTest {
	
	static void gc() {
		System.out.println("Garbage Collection Calling Start ");
		try {
			System.gc();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Garbage Collection Calling Finished ");
	}
	
	public static void main(String[] args) {

		System.out.println("***INICIO***");
		System.out.println("1)Nullifying the reference variable");
		Person person = new Person("Fernando");
		System.out.println("01-"+person);
		gc();
		System.out.println("02-"+person);
		person = null;
		gc();
		

		System.out.println("\n2)Re-assigning the reference variable");
		person = new Person("Thais");
		System.out.println("03-"+person);
		gc();
		System.out.println("04-"+person);
		person = new Person("Isabela");
		System.out.println("05-"+person);
		gc();
		System.out.println("06-"+person);

		
		System.out.println("\n3)Object created inside method");
		createObject();
		System.out.println("08-"+person);
		gc();
		
		
		System.out.println("\n4)Anonymous object");
		new Person("Anonymous");
		gc();
		
		System.out.println("\n5)Objects with only internal references (Island of Isolation)");
		Person p1 = new Person("Person1");
		Person p2 = new Person("Person2");
		p1.p = p2;
		p2.p = p1;
		gc();

		p1 = null;
		gc();
		
		p2 = null;
		gc();
		

		System.out.println("\n6)Test: Object referenced many times are deleted too)");
		Person pp = new Person("Famous Person");
		for(int i=0;i<=200;i++) {
			System.out.println(pp);
		}
		gc();
		pp = null;
		gc();
		
		
		System.out.println("---FIM---");
	}

	private static void createObject() {
		Person personInsideMethod = new Person("Object inside a method");
		gc();
		System.out.println("07-"+personInsideMethod);
	}
}
