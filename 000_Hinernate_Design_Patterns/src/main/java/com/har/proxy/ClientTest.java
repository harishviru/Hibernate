package com.har.proxy;

public class ClientTest {

	public static void main(String[] args) {
	
		//Here we are using proxy object instead of real object
		VeryExpensiveProcess veryExpensiveProcess = new VeryExpensiveProcessProxy();
		veryExpensiveProcess.process();
		veryExpensiveProcess.process();
		
	}

}
