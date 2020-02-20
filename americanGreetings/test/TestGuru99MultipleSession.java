package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGuru99MultipleSession {

	@Test(testName = "To verify TC_001", enabled = true)
	public void TC_001() throws InterruptedException {
		Assert.assertEquals(true, true);
	}
}
