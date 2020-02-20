package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PFDP {
	
	@Test(testName = "To verify TC_002", enabled = true)
	public void TC_003() {
		System.out.println("Test start................");
		Assert.assertEquals(true, true);
		System.out.println("Test end...................");
	}
	
	@Test(testName = "To verify TC_002", enabled = true)
	public void TC_004() {
		System.out.println("Test start................");
		Assert.assertEquals(true, false);
		System.out.println("Test end...................");
	}

}
