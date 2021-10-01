package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SampleHook {
	
	@Before("@amazon")
	public void beforeFirst() {
		System.out.println("amazon");
	}
	
	@Before("@lic")
	public void beforesecond() {
		System.out.println("lic");
	}
	
	@Before("@firstcry")
	public void beforethird() {
		System.out.println("firstcry");
	}
	
	

}
