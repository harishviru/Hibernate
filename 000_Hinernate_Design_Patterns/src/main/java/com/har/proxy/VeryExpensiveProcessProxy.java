package com.har.proxy;
// This class is responsible to utilize the Proxy design pattern and initialize our object on demand
public class VeryExpensiveProcessProxy implements VeryExpensiveProcess {

	private static VeryExpensiveProcess veryExpensiveObject;
	 
	/*    Now we will utilize the Proxy pattern and initialize
		   our Expansive object on demand
		*/
	    @Override
	    public void process() {
	        if (veryExpensiveObject == null) {
	            veryExpensiveObject = new VeryExpensiveProcessImpl();
	        }
	        veryExpensiveObject.process();
	    }
}
