package com.testes.jvm.memory.gc;

public class Main {
	
	public static void main(String[] args) 
	{
		Runtime runtime = Runtime.getRuntime();

		long availableBytes = runtime.freeMemory();
		System.out.println("1)Available memory: " + availableBytes / 1024 + "k");

		// let's create a ton of garbage....
		Customer c;
		for (int i=0; i<1000000; i++)
		{
			c = new Customer("John");	
		}
		
		availableBytes = runtime.freeMemory();
		System.out.println("2)Available memory: " + availableBytes / 1024 + "k");
		
		System.gc();
		
		availableBytes = runtime.freeMemory();
		System.out.println("3)Available memory: " + availableBytes / 1024 + "k");
	}

	
}
