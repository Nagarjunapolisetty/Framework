package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.frameWork.TestBase;

import pages.Page_Home;

public class HomePage_Test extends TestBase {
	Page_Home homePage=new Page_Home(driver);

	@Test(testName = "To verify TC_001", enabled = true)
	public void TC_001() throws InterruptedException {
		driver.navigate().to("https://www.vitamix.com/us/en_us/Shop/Shopping-Cart");
		
		String selector = "#remove-item-0";
		
		boolean status= isElementPresent(By.cssSelector(selector), driver);
		System.out.println("status: "+status);
		Assert.assertEquals(status, false);
	}
	
	@Test(testName = "To verify TC_001", enabled = true)
	public void TC_002() throws InterruptedException {
		driver.navigate().to("https://www.vitamix.com/us/en_us/shop/a3500");
		driver.findElement(By.cssSelector("button[type=submit]")).click();
		
		String selector = "#remove-item-0";
		
		boolean status= isElementPresent(By.cssSelector(selector), driver);
		System.out.println("status: "+status);
		Assert.assertEquals(status, true);
	}
	
	protected boolean isElementPresent(By selector, SearchContext searchContext) {
        try {
        	 driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return searchContext.findElements(selector).size() > 0;
        } finally {
        	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }

	
	
}
