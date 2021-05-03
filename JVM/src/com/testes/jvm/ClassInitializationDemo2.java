package com.testes.jvm;

/*
 * 1)Blocos estáticos: Uma vez, quando a classe é carregada pela primeira vez, antes da chamada do construtor.
 * 2)Blocos de instância: Todas as vezes em que um objeto é instanciado. 
 * 3)Construtores: 
 * Em todos os casos, inicializa toda a hierarquia, iniciando pelas superclasses.
 * Interfaces: São carregadas. E só são inicializadas se possuir métodos estáticos e estes forem acessados (A partir do java 8).
 */

class Superclass2 {
	static { System.out.println("3)Superclass: static initializer"); } //3	
    Superclass2 () {System.out.println("6)Superclass: constructor"); } //6    
}
class Subclass2 extends Superclass2 {
	static final int STATIC_FINAL = 47;	
	static final int STATIC_FINAL2 = (int) (Math.random() * 5);
//	static final int STATIC_FINAL2 = 188; //Here it runs just after STATIC_FINAL
	static { System.out.println("4)Subclass: static initializer"); } //4
	Subclass2 () { System.out.println("7)Subclass: constructor"); } //7
}

public class ClassInitializationDemo2 {
	static { System.out.println("\n1)ClassInitializationDemo: static initializer"); } //1
	{ System.out.println("8)ClassInitializationDemo: instance initializer"); } //8
	public static void main(String[] args) throws Exception { 		
	    System.out.println("2)Subclass.STATIC_FINAL: " + Subclass2.STATIC_FINAL); //2
		System.out.println("5)Subclass.STATIC_FINAL2: " + Subclass2.STATIC_FINAL2);	//5	
		new Subclass2();
		new ClassInitializationDemo2();
	}
}
