package com.testes.jvm.semanticsquare;

class Superclass2 {
	static { System.out.println("Superclass: static initializer"); }	
    Superclass2 () {
    	System.out.println("Superclass: constructor");
	}    
}
class Subclass2 extends Superclass2 {
	static final int STATIC_FINAL = 47;	
	static final int STATIC_FINAL2 = (int) (Math.random() * 5);
	static { System.out.println("Subclass: static initializer"); }		
	Subclass2 () { System.out.println("Subclass: constructor"); }	
}

public class ClassInitializationDemo2 {
	static { System.out.println("\nClassInitializationDemo: static initializer"); }
	{ System.out.println("\nClassInitializationDemo: instance initializer"); }
	public static void main(String[] args) throws Exception { 		
	    System.out.println("Subclass.STATIC_FINAL: " + Subclass2.STATIC_FINAL);
		System.out.println("Subclass.STATIC_FINAL2: " + Subclass2.STATIC_FINAL2);		
		new Subclass2();		
	}
}
