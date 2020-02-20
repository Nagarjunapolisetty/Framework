package test;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGuru99MultipleSession {

	@Test(testName = "To verify TC_001", enabled = true)
	public void TC_001() throws InterruptedException {
		Assert.assertEquals(true, true);
	}
}
