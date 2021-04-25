package com.testes.jvm.gc;

/*
 * Island of Isolation: Two objects points internally to each other and lose all their external references
 */

class PersonX {
	String name;
	PersonX partner;

	public PersonX(String name) {
		this.name = name;
		System.out.println("New personX created: "+this.name);
	}
	
	public void setPartner(PersonX partner) {
		this.partner = partner; 
		System.out.println("PersonX partner: "+this.partner.name);
	}

	@Override
	//	Overriding finalize method to check which object is garbage collected
	protected void finalize() throws Throwable {
	System.out.println("Person object - " + this.name + " -> successfully garbage collected");
	}
}

class Teste5 {

	public static void main(String args[]) {
		System.out.println("*** Case 5: Objects with only internal references (Island of Isolation) ***");

		System.out.println("Create a PersonX object p1");
		PersonX p1 = new PersonX("John Doe");
		System.out.println("Create a PersonX object p2");
		PersonX p2 = new PersonX("Jane Doe");

		System.out.println("Set p1 partner as p1");
		p1.setPartner(p2);		
		System.out.println("Set p2 partner as p1");
		p2.setPartner(p1);
		

		System.out.println("Set null to p1 and p1");
		p1 = null;
		p2 = null;

		System.out.println("calling garbage collector");
		System.gc(); // object will be garbage-collected
	}
}
