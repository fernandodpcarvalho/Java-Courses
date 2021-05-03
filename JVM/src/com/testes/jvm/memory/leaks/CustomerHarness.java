package com.testes.jvm.memory.leaks;

//JVM Argments: -Xmx10m
//Will cause a java.lang.OutOfMemoryError exception
//Install and use visualvm

public class CustomerHarness {
	
	public static void main(String[] args)  {
		CustomerManager cm = new CustomerManager();
		GenerateCustomerTask task = new GenerateCustomerTask(cm);
		for (int user = 0; user < 10; user++) {
			Thread t = new Thread(task);
			t.start();
		}
		
		//main thread is now acting as the monitoring thread
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cm.howManyCustomers();
			System.out.println("Available memory: " + Runtime.getRuntime().freeMemory() / 1024 + "k");
			
		}
	}

}
