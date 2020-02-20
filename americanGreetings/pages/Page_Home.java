package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.extentReport.ExtentManager;
import com.frameWork.GenericKeywords;
import com.frameWork.TestBase;

public class Page_Home {
	
	WebDriver driver;
	GenericKeywords gen;
	ExtentTest logger;
	public Page_Home(WebDriver driver) {

		this.driver = driver;
		gen = new GenericKeywords(driver);
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//span[@class='dropdown-header-container']//a[contains(text(),'replaceText')]")
	public By lineItem;
	
	public static final String megaMenu ="//span[@class='dropdown-header-container']//a[contains(text(),'replaceText')]";
	@FindBy(how = How.XPATH, using = megaMenu )
	public static WebElement MEGAMENU;
	
	public static final String subMenu ="//div[@class='submenu-container submenu-large']//a[contains(text(),'replaceText')]";
	@FindBy(how = How.XPATH, using = subMenu )
	public static WebElement SUBMENU;
	
	public void selectSubmenu(String menu, String submenu){
		
		
//		WebElement we1 = 		;		
//				gen.mouseHoverAndSelect(, );
//		testBase.logger.log("", markup)
	}
	
	public void log(){
		logger.log(Status.PASS, "Clicked on 'Proceed to checkout' on Shopping Bag successfully.");
	}
	

}
