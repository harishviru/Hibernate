package com.har.proxy;
//Implementation of VeryExpensiveProcess interface with a large initial configuration:
public class VeryExpensiveProcessImpl implements VeryExpensiveProcess {

	public VeryExpensiveProcessImpl() {
        heavyInitialConfigurationSetup();
    }
    @Override
    public void process() {
        System.out.println("Processing is done");
    }
     
    private void heavyInitialConfigurationSetup() {
    	System.out.println("Setting up heavy initial configuration");
    }
}
