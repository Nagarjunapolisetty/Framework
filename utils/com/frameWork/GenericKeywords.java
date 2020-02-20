package com.frameWork;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;



public class GenericKeywords {

	public WebDriver driver;

	// public GenericKeywords() {
	// this.driver = TestPages.driver;
	//
	// }
	public GenericKeywords(WebDriver driver) {
		this.driver = driver;

	}


	//private static Random random = new Random();



/*	public boolean checkLocator(String xpath) {

		Wait wait = new FluentWait(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		// FluentWait<WebDriver> wait = new WebDriverWait(driver,
		// 90).withTimeout(60, TimeUnit.SECONDS).pollingEvery(500,
		// TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		return true;

	}*/

/*	public boolean checkWebElement(WebElement webElement) {
		//Wait wait = new FluentWait(driver).withTimeout(120, TimeUnit.SECONDS)
//				.pollingEvery(5, TimeUnit.MILLISECONDS)
//				.ignoring(NoSuchElementException.class);
//		wait.until(ExpectedConditions.elementToBeClickable(webElement));

		// FluentWait<WebDriver> wait = new WebDriverWait(driver,
		// 90).withTimeout(60, TimeUnit.SECONDS).pollingEvery(500,
		// TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		// wait.until(ExpectedConditions.visibilityOf(webElement));

		return true;

	}
	
	public void elementClickable(WebElement Ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(Ele));
		wait.until(ExpectedConditions.elementToBeClickable(Ele));
	}
	

	public int getHTTPResponseCode() throws Exception {
		String currURL = driver.getCurrentUrl().trim();
		System.out.println("current URL: " + currURL);
		URL url = new URL(currURL);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setRequestMethod("GET");
		httpCon.connect();
		return httpCon.getResponseCode();
	}

	public void openNewTab(String URL) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("window.open('" + URL
				+ "','_blank');");

		Thread.sleep(3000);
	}

	public void switchToNewTab() throws InterruptedException {

		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		System.out.println("Number of Tab Present is: " + tabs.size());
		driver.switchTo().window(tabs.get(0));

	}

	public String createTimeStampStr() throws Exception {
		Calendar mycalendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_hhmmss");
		String timeStamp = formatter.format(mycalendar.getTime());

		return timeStamp;

	}

	public void switchToParentTab() throws InterruptedException {

		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());

		System.out.println("Number of Tab Present is: " + tabs.size());
		driver.switchTo().window(tabs.get(0));

	}

	public void clearAllCoockies() {

		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}

	public void closeParentTab() throws InterruptedException {

		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());

		System.out.println("Number of Tab Present is: " + tabs.size());
		driver.switchTo().window(tabs.get(0));
		driver.close();
	}

	public void closeNewTab() throws InterruptedException {

		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());

		System.out.println("Number of Tab Present is: " + tabs.size());
		driver.switchTo().window(tabs.get(1));
		driver.close();
	}

	public boolean assertCSSAttributeContains(String xpath,
			String attributeName, String cssPropertValue) {

		boolean flag;

		String propertyValue = driver.findElement(By.xpath(xpath))
				.getCssValue(attributeName).toString().trim();
		System.out.println(propertyValue);
		if (propertyValue.contains(cssPropertValue)) {

			flag = true;

		} else {

			flag = false;

		}

		return flag;

	}

	public void waitAndClick(WebElement webElement) {
		if (checkWebElement(webElement)) {
			System.out.println("Element Found");
			Reporter.log("Clicked on WebElement", true);

			webElement.click();

		} else {
			System.out.println("Element Not Found");
			Reporter.log("NOT Clicked on WebElement", true);
		}
	}

	public String getCurrentURL() {

		String currUrl = driver.getCurrentUrl();
		return currUrl;
	}

	public double roundOff(double value) {

		double roundedOffValue = Math.round(value * 100.0) / 100.0;
		return roundedOffValue;
	}

	public void enterFieldValue(WebElement webElement, String Value) {
		if (checkWebElement(webElement)) {
			System.out.println("Element Found");
			Reporter.log("Entered Value into Text field", true);
			webElement.clear();
			webElement.sendKeys(Value);
		} else {
			System.out.println("Element Not Found");
			Reporter.log("NOT Entered Value into Text field", true);
		}

	}

	public void mouseHoverAndSelect(WebElement ele1, WebElement ele2) throws InterruptedException {

		Actions act = new Actions(driver);
		act.moveToElement(ele1).build().perform();
		Thread.sleep(2000);
		ele2.click();

	}

	public void navigateToBackPage() throws InterruptedException {

		driver.navigate().back();

	}

	public void selectByIndex(String XpathSelectLocator, int index)
			throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath(XpathSelectLocator)));

		WebElement select = driver.findElement(By.xpath(XpathSelectLocator));
		// wait.until(ExpectedConditions.elementToBeClickable(By
		// .tagName("option")));

		if (select.findElements(By.tagName("option")).size() > 0) {
			Select sel = new Select(driver.findElement(By
					.xpath(XpathSelectLocator)));
			sel.selectByIndex(index - 1);
			Thread.sleep(2000);

			System.out.println(select.findElements(By.tagName("option")).size()
					+ " Options are available for" + XpathSelectLocator);
			Reporter.log(
					select.findElements(By.tagName("option")).size()
							+ " Options are available for"
							+ XpathSelectLocator.toString(), true);
			System.out.println("Selected option : " + (index) + "for"
					+ XpathSelectLocator);
			Reporter.log("Selected option : " + (index) + "for"
					+ XpathSelectLocator.toString(), true);

		}

	}

	public void waitAndClickById(String IDLocater) {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(IDLocater)));
		driver.findElement(By.id(IDLocater)).click();
	}

	public void waitAndClickByName(String NameLocater) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(NameLocater)));
		driver.findElement(By.name(NameLocater)).click();
	}

	public void waitAndClickByCssSelecter(String CssLocater) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector(CssLocater)));
		driver.findElement(By.cssSelector(CssLocater)).click();
	}

	public void mouseOverToElementByCssLocator(String parentElement)
			throws InterruptedException {
		WebElement wb = driver.findElement(By.cssSelector(parentElement));
		Actions act = new Actions(driver);
		act.moveToElement(wb).build().perform();
		Thread.sleep(500);

	}

	public void waitAndClickByLinkText(String linkTextLocater) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.linkText(linkTextLocater)));
		driver.findElement(By.linkText(linkTextLocater)).click();
	}

	public void waitAndClickByPartialLinkText(String PartialLinkTextLocater) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.partialLinkText(PartialLinkTextLocater)));
		driver.findElement(By.partialLinkText(PartialLinkTextLocater)).click();
	}

	public void waitAndClickByTagName(String TagNameLocater) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.tagName(TagNameLocater)));
		driver.findElement(By.tagName(TagNameLocater)).click();
	}

	public void waitAndClickByXpath(String elementXpath) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath(elementXpath)));
		driver.findElement(By.xpath(elementXpath)).click();
	}

	public void waitAndClickByClassName(String ClassNameLocater) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.className(ClassNameLocater)));
		driver.findElement(By.className(ClassNameLocater)).click();
	}

	// ****************Enter value to the edit box
	public void enterFieldValueByID(String IDLocater, String Value) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(IDLocater)));
		driver.findElement(By.id(IDLocater)).sendKeys(Value);
	}

	public void enterFieldValueByName(String NameLocater, String Value) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.name(NameLocater)));
		driver.findElement(By.name(NameLocater)).sendKeys(Value);
	}

	public void enterFieldValueByCssSelecter(String CssLocater, String Value) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector(CssLocater)));
		driver.findElement(By.cssSelector(CssLocater)).sendKeys(Value);
	}

	public void enterFieldValueByLinkText(String linkTextLocater, String Value) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.linkText(linkTextLocater)));
		driver.findElement(By.linkText(linkTextLocater)).sendKeys(Value);
	}

	public void enterFieldValueByPartialLinkText(String PartialLinkTextLocater,
			String Value) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.partialLinkText(PartialLinkTextLocater)));
		driver.findElement(By.partialLinkText(PartialLinkTextLocater))
				.sendKeys(Value);
	}

	public void enterFieldValueByTagName(String TagNameLocater, String Value) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.tagName(TagNameLocater)));
		driver.findElement(By.tagName(TagNameLocater)).sendKeys(Value);
	}

	public void enterFieldValueByXpath(String elementXpath, String Value) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(elementXpath)));
		driver.findElement(By.xpath(elementXpath)).sendKeys(Value);
	}

	public void enterFieldValueByClassName(String ClassNameLocater, String Value) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.className(ClassNameLocater)));
		driver.findElement(By.className(ClassNameLocater)).sendKeys(Value);
	}

	// ************ Select
	public void selectByXpathLocator(String XpathSelectLocator,
			String VisibleOption) {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(XpathSelectLocator)));

		WebElement select = driver.findElement(By.xpath(XpathSelectLocator));
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.tagName("option")));

		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (VisibleOption.equals(option.getText()))
				option.click();
		}
	}

	public void selectByIdLocator(String IdSelectLocator, String VisibleOption) {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.id(IdSelectLocator)));

		WebElement select = driver.findElement(By.id(IdSelectLocator));
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.tagName("option")));

		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (VisibleOption.equals(option.getText()))
				option.click();
		}
	}

	public void selectByNameLocator(String NameSelectLocator,
			String VisibleOption) {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.name(NameSelectLocator)));

		WebElement select = driver.findElement(By.name(NameSelectLocator));
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.tagName("option")));

		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (VisibleOption.equals(option.getText()))
				option.click();
		}
	}

	public void selectByClassNameLocator(String ClassNameSelectLocator,
			String VisibleOption) {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.className(ClassNameSelectLocator)));

		WebElement select = driver.findElement(By
				.className(ClassNameSelectLocator));
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.tagName("option")));

		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (VisibleOption.equals(option.getText()))
				option.click();
		}
	}

	public void selectByCssSelectorLocator(String CssSelectorSelectLocator,
			String VisibleOption) {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.cssSelector(CssSelectorSelectLocator)));

		WebElement select = driver.findElement(By
				.cssSelector(CssSelectorSelectLocator));
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.tagName("option")));

		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (VisibleOption.equals(option.getText()))
				option.click();
		}
	}

	public void selectByLinkTextLocator(String LinkTextSelectLocator,
			String VisibleOption) {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.linkText(LinkTextSelectLocator)));

		WebElement select = driver.findElement(By
				.linkText(LinkTextSelectLocator));
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.tagName("option")));

		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (VisibleOption.equals(option.getText()))
				option.click();
		}
	}

	public void selectByPartialLinkTextLocator(
			String PartialLinkTextSelectLocator, String VisibleOption) {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.partialLinkText(PartialLinkTextSelectLocator)));

		WebElement select = driver.findElement(By
				.partialLinkText(PartialLinkTextSelectLocator));
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.tagName("option")));

		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (VisibleOption.equals(option.getText()))
				option.click();
		}
	}

	public void selectByTagNameLocator(String TagNameSelectLocator,
			String VisibleOption) {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.tagName(TagNameSelectLocator)));

		WebElement select = driver
				.findElement(By.tagName(TagNameSelectLocator));
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.tagName("option")));

		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (VisibleOption.equals(option.getText()))
				option.click();
		}
	}

	
	 * public void maxmizeWindow()throws Exception {
	 * driver.manage().window().maximize(); }
	 

	public void mouseOverToElement(String parentElement)
			throws InterruptedException {
		WebElement wb = driver.findElement(By.xpath(parentElement));
		Actions act = new Actions(driver);
		act.moveToElement(wb).build().perform();
		Thread.sleep(500);

	}

	public void mouseOverOn(String XpathElement) throws InterruptedException {

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(XpathElement))).build()
				.perform();
		Thread.sleep(2000);

	}

	// Explicit wait
	public void webdriverwaitAndClick(String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();
	}
	public void webdriverwait(String locator) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

	// Implicit wait
	public void implicitwait(String locator) throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void assertChecked(String XpathCheckBox) {
		boolean checked = driver.findElement(By.xpath(XpathCheckBox))
				.isSelected();
		if (checked) {
			Assert.assertTrue(driver.findElement(By.xpath(XpathCheckBox))
					.isSelected());
			System.out.println("Checked");
		} else {
			System.out.println("NOT Checked");
		}

	}

	public void assertFieldNull(String XpathField) {

		if (driver.findElement(By.xpath(XpathField)).getText().isEmpty()) {
			Assert.assertTrue(driver.findElement(By.xpath(XpathField))
					.getText().isEmpty());
			System.out
					.println("fields contains information:: "
							+ driver.findElement(By.xpath(XpathField))
									.getText().trim());
		} else {
			System.out
					.println("fields does not contain any information:: "
							+ driver.findElement(By.xpath(XpathField))
									.getText().trim());
		}
	}

	public void assertFieldNotNull(String XpathField) {

		if (!driver.findElement(By.xpath(XpathField)).getText().isEmpty()) {
			Assert.assertFalse(driver.findElement(By.xpath(XpathField))
					.getText().isEmpty());
			System.out.println("fields contains information:: "
					+ driver.findElement(By.xpath(XpathField)).getText());
		} else {
			System.out
					.println("fields does not contain any information:: "
							+ driver.findElement(By.xpath(XpathField))
									.getText().trim());
		}
	}

	
	 * public void assertFieldContains(String XpathField, String FildData) {
	 * Assert.assertEquals(selenium.getValue(XpathField), FildData); }
	 * 
	 * public void verifyPassFieldContains(String XpathField) {
	 * Assert.assertEquals("123456", selenium.getValue(XpathField)); }
	 * 
	 * public void deleteAllVisibleCookies() {
	 * selenium.deleteAllVisibleCookies();
	 * 
	 * }
	 

	public void ClickOnDropDownLink(String XpathMenuLink, String XpathOptionLink)
			throws InterruptedException {
		driver.findElement(By.xpath(XpathMenuLink)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(XpathOptionLink)).click();
	}

	public void clickByJavascriptExecuter(String XpathElement)
			throws InterruptedException {
		waitForElement(XpathElement);
		WebElement element = driver.findElement(By.xpath(XpathElement));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	//	Thread.sleep(1000);

	}

	public boolean IsEnabled(String XpathElement) throws InterruptedException {
		Thread.sleep(1000);
		boolean isEnabled = false;
		if (driver.findElement(By.xpath(XpathElement)).isEnabled()) {
			System.out.println("Element is clickable");
			isEnabled = true;
		} else {
			System.out.println("Element is not clickable");
			isEnabled = false;
		}
		return isEnabled;

	}

	public boolean assertURLContains(String SubURL) {
		System.out.println(driver.getCurrentUrl().toString());
		boolean contain = driver.getCurrentUrl().toString().contains(SubURL);
		return contain;
	}

	public void clearFildText(String XpathTextField) {
		driver.findElement(By.xpath(XpathTextField)).clear();

	}

	public void clearFildTextById(String idTextField) {
		driver.findElement(By.id(idTextField)).clear();

	}

	public void openURL(String URL) {
		driver.get(URL);

	}

	public void clickByCssSelector(String CssPathLocator) {
		driver.findElement(By.cssSelector(CssPathLocator));

	}

	public void selectOption(String XpathSelect, String VisibleOption) {
		WebElement select = driver.findElement(By.xpath(XpathSelect));
		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (VisibleOption.equals(option.getText()))
				option.click();
		}

	}

	public String getFildText(String XpathElement) {
		String text = driver.findElement(By.xpath(XpathElement)).getText()
				.trim();
		return text;

	}

	public String getProductNamebyTitle(String XpathElement) {
		String text = driver.findElement(By.xpath(XpathElement))
				.getAttribute("title").trim();
		return text;

	}

	public String getTagName(String XpathTagField) {
		String tag = driver.findElement(By.xpath(XpathTagField)).getTagName();
		return tag;

	}

	public void displayErrorMessage() {
		System.out.println("ERROR::");

	}

	public void displayMessage(String message) {
		System.out.println("::" + message);

	}

	public void switchToFrame(String XpathFrame) {
		driver.switchTo().frame(driver.findElement(By.xpath(XpathFrame)));
	}

	public void AddToCart() {
		driver.findElement(By.cssSelector("button.btn-yellow.p-add-cart-btn"))
				.click();
	}

	public void clickUsingAction(String Xpath) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(Xpath))).click()
				.perform();
		// driver.findElement(By.xpath(Xpath)).click();

	}

	public void ESC() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE);

	}

	public void assertFieldIsNull(String elemXpath) {
		String str = driver.findElement(By.xpath(elemXpath)).getText();

		Assert.assertTrue(str.equals(""));

	}

	public boolean assertFiledValue(String elemXpath, String value) {
		boolean matched;

		matched = driver.findElement(By.xpath(elemXpath)).getAttribute("value")
				.contains(value);
		return matched;

	}

	public String getValue(String elemXpath) {
		String val = driver.findElement(By.xpath(elemXpath)).getAttribute(
				"value");
		return val;

	}

	public String getAttribute(String elemXpath, String attributename) {
		String attrVal = driver.findElement(By.xpath(elemXpath)).getAttribute(attributename);
		return attrVal;

	}

	public void switchFrameToDefaultWindow() {
		driver.switchTo().defaultContent();
	}

	public void wiatForPageToLoad(int TimeoutSeconds) {
		driver.manage().timeouts()
				.implicitlyWait(TimeoutSeconds, TimeUnit.SECONDS);
	}

	// >>>>>>>>>>>>>>>>>>

	public void deleteallcookies() {
		driver.manage().deleteAllCookies();
	}

	public boolean assertForCheck(String locater) {
		Boolean isChecked = false;

		isChecked = driver.findElement(By.xpath(locater)).isSelected();
		if (isChecked) {
			Assert.assertTrue(driver.findElement(By.xpath(locater))
					.isSelected());
			System.out.println("Checked");
			isChecked = true;
		}

		System.out.println(isChecked);
		return isChecked;

	}

	public boolean assertTextPresent(String expectedText) {
		boolean flag = false;
		String actualval = driver.getPageSource();
		if (actualval.contains(expectedText)) {
			flag = true;
			System.out.println("text present");

		} else {
			System.out.println("text not present");
		}

		return flag;
	}

	public boolean assertElementPresent(String locater) throws InterruptedException
			{

		Thread.sleep(1000);
		boolean isPresent = false;
		if (driver.findElements(By.xpath(locater)).size() > 0) {
			//Assert.assertTrue(driver.findElements(By.xpath(locater)).size() > 0);
			System.out.println("Element is Present");
			isPresent = true;
		} else {
			System.out.println("Element is NOT present");
		}
		System.out.println(isPresent);
		return isPresent;

		//Modified Code
		try{
			driver.findElement(By.xpath(locater)).isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Element is not present" + e.getMessage());
		}
		return false;
		
			}
		boolean isPresent = false;
		if (driver.findElement(By.xpath(locater))) {
			//Assert.assertTrue(driver.findElements(By.xpath(locater)).size() > 0);
			System.out.println("Element is Present");
			isPresent = true;
		} else {
			System.out.println("Element is NOT present");
		}
		System.out.println(isPresent);
		return isPresent;
 
		
		
		
		
	
	
	
		for(int i=0; i<5; i++)
		{
		try{
			if(driver.findElement(By.xpath(locater)).isDisplayed())
			{
				System.out.println("Element Displayed: "+locater);
				
				return true;
			
			}
		   }
		catch(Exception e)
		{
			System.out.println("Element Not Displayed");
			//Thread.sleep(1000);
		}
		}
		return false;
		

		for(int i=0; i<2; i++)
		{
			try{
				if(driver.findElement(By.xpath(locater)).isDisplayed())
				{
					System.out.println("Element Displayed: "+locater);
					
					return true;
				
				}	
			}
		
			catch(Exception e)
			{
				System.out.println("Element Not displayed");
			}
				
		 }
		
		
		return false;
		
	}
	
	
	
	
	
	
	
	public boolean assertElementPresent2(String locater)
			throws InterruptedException {
				
		return false;

	}
	
	

	public void setValueFromJSExecuter(WebElement webelementLocator,
			String attrName, String attrValue) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('" + attrName + "', '"
				+ attrValue + "')", webelementLocator);

	}

	
	 * public boolean assertElementPresent(String locater) { boolean isPresent =
	 * false; if (driver.findElements(By.xpath(locater)).size() > 0) {
	 * Assert.assertTrue(driver.findElements( By.xpath(locater)).size() > 0);
	 * System.out.println("Element is Present"); isPresent = true; } else {
	 * System.out.println("Element is not present"); }
	 * System.out.println(isPresent); return isPresent;
	 * 
	 * }
	 
	public boolean assertElementPresentById(String locater) {
		boolean isPresent = false;
		if (driver.findElements(By.id(locater)).size() > 0) {
			Assert.assertTrue(driver.findElements(By.id(locater)).size() > 0);
			System.out.println("Element is Present");
			isPresent = true;
		} else {
			System.out.println("Element is not present");
		}
		System.out.println(isPresent);
		return isPresent;

	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	public boolean assertTitle(String expectedTitle) {

		boolean flag;
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("title is present");
			System.out.println(actualTitle);
			flag = true;
		} else {
			System.out.println("title is not present");
			System.out.println(actualTitle);
			flag = false;
		}
		return flag;
	}

	public boolean assertVisible(String visibleElem) {
		boolean flag = false;
		WebElement wb = driver.findElement(By.xpath(visibleElem));
		if (wb.isDisplayed()) {
			System.out.println("Element is visible");
			return flag = true;
		} else {
			System.out.println("Element is not visible");
		}

		return flag;
	}

	public void waitForIdPresent(String elementId) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));

	}

	public void waitForxpathPresent(String elementXpath) {
		WebDriverWait wait = new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath(elementXpath)));

	}

	public void close() {
		driver.close();
	}

	public HashMap<String, String> assertWindowsId() {
		Set<String> set = driver.getWindowHandles();

		HashMap<String, String> windowId = new HashMap<String, String>();
		Iterator<String> it = set.iterator();

		windowId.put("parentId", it.next());
		windowId.put("childId", it.next());
		return windowId;
	}

	public void clickOnButton(String locater) {
		driver.findElement(By.xpath(locater)).click();
	}

	public void check(String elementXpath) {

		List<WebElement> checklist = driver.findElements(By
				.className(elementXpath));
		for (int i = 0; i < checklist.size(); i++) {
			checklist.get(i).clear();
			checklist.get(i).click();

		}

	}

	//
	public void doubleClick(String elementXpath) {
		WebElement wb = driver.findElement(By.xpath(elementXpath));
		Actions act = new Actions(driver);
		act.doubleClick(wb).build().perform();

	}

	public void clickOnCheck(String elemXpath) {

		driver.findElement(By.xpath(elemXpath)).click();
	}

	public void doubleClickAndWait(String elementXpath, int TimeInSecond) {

		WebElement wb = driver.findElement(By.xpath(elementXpath));

		Actions act = new Actions(driver);
		act.doubleClick(wb).build().perform();
		wiatForPageToLoad(30);

	}

	public void dragAndDrop(String xpath1, String xpath2) {
		WebElement wb = driver.findElement(By.xpath(xpath1));
		WebElement wb1 = driver.findElement(By.xpath(xpath2));
		Actions act = new Actions(driver);
		act.dragAndDrop(wb, wb1).build().perform();
	}

	public void clickAt(String parentElement, String subElement) {
		WebElement wb = driver.findElement(By.xpath(parentElement));
		Actions act = new Actions(driver);
		act.moveToElement(wb).build().perform();
		driver.findElement(By.xpath(subElement)).click();

	}

	public void goBack() {
		driver.navigate().back();
	}

	public void goBackAndWait() {
		driver.navigate().back();
		wiatForPageToLoad(10);

	}

	public void selectByvisibleElem(String elementLoc) {
		WebElement wb = driver.findElement(By.xpath(elementLoc));
		Select sel = new Select(wb);
		sel.selectByIndex(1);
	}

	public void selectByvisibleElemByText(String elementLoc) {
		WebElement wb = driver.findElement(By.xpath(elementLoc));
		Select sel = new Select(wb);
		sel.selectByVisibleText("India");
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public Boolean isPageRefreshed() {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
			return (false);
		} catch (Throwable error) {
			// assert.assertFalse("Timeout waiting for Page Load",true);
			return (true);
		}
	}

	public void goForword() {
		driver.navigate().forward();
	}

	public void removeAllSelections(String selElement) {
		WebElement wb = driver.findElement(By.xpath(selElement));
		Select sel = new Select(wb);
		sel.deselectAll();

	}

	public void selectFrame(String frame, String elementXpath,
			String expectedFrameid) {
		List<WebElement> listWb = driver.findElements(By.tagName(frame));
		for (int i = 0; i < listWb.size(); i++) {
			String actualFrameId = listWb.get(i).getAttribute("id");
			if (actualFrameId.equals(expectedFrameid)) {
				driver.switchTo().frame(actualFrameId);
				driver.findElement(By.xpath(elementXpath)).click();
			} else {
				System.out.println("frame id is not found");
				// driver.switchTo().defaultContent();
			}
		}
	}

	public void enterByUsingAction(String selElement) {
		WebElement wb = driver.findElement(By.xpath(selElement));
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER);
	}

	
	 * public void highlight(String highLightEle) {
	 * selenium.highlight(highLightEle);
	 * 
	 * }
	 
	
	 * public void highlightAndWait(String highlightElem) {
	 * selenium.highlight(highlightElem); wiatForPageToLoad(15); }
	 
	public void keyDown() {
		Actions action = new Actions(driver);
		// action.sendKeys(Keys.TAB);
		// keyDown(Keys.CONTROL).
		action.sendKeys(Keys.DOWN).build().perform();
	}

	public void storeAllLinks(String linkXpath) {

		List<WebElement> linksList = driver.findElements(By.tagName(linkXpath));
		for (int i = 0; i < linksList.size(); i++) {
			String linksName = linksList.get(i).getText();
			System.out.println(linksName);

		}

	}

	public void storeHtmlSource() {
		String str = driver.getPageSource();
		System.out.println(str);
	}

	//

	public void keyDownAndWait() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.DOWN).build().perform();
		wiatForPageToLoad(15);

	}

	public String getFacetProdCount(String xpathLocator) {

		String count;
		String facet = getFildText(xpathLocator);
		facet = facet.replace('(', '#');
		facet = facet.replace(')', '#');
		String[] num = facet.split("#");
		count = num[1];
		return count;
	}

	public boolean verifyTable(String tableName, String expectedTable) {
		List<WebElement> tableList = driver.findElements(By
				.tagName(expectedTable));
		Boolean flag = false;
		for (int i = 0; i < tableList.size(); i++) {
			String actualTable = tableList.get(i).getText();
			// System.out.println(actualTable);
			if (actualTable.equals(expectedTable)) {
				flag = true;

				break;

			}
		}
		if (flag = true) {
			System.out.println("table is present");
			return flag;

		} else {
			System.out.println("table is not present");
		}
		return flag;

	}

	public void loginWithCredentials(String xpathUser, String Username,
			String xpatPassword, String Password, String xpathLoginButton) {
		try {
			driver.findElement(By.xpath(xpathUser)).sendKeys(Username);
			driver.findElement(By.xpath(xpatPassword)).sendKeys(Password);
			driver.findElement(By.xpath(xpathLoginButton)).click();
		} catch (Exception e) {
			System.out.println("FAIL:: " + e.getMessage());

		}
		System.out.println("Pass:: loginWithCredentials");

	}

	public void printXLData(String user, String password) {
		System.out.println(user);
		System.out.println(password);
	}

	
	 * public void closselenium() throws Exception { // Thread.sleep(20000);
	 * selenium.close(); }
	 

	public void quit() throws Exception {
		// selenium.close();
		driver.quit();
	}

	private void inspect(WebElement elem) {
		System.out.println("Element name: " + elem.getTagName());
		System.out.println("Element text: " + elem.getText());
		System.out.println("Element CSS: " + elem.getAttribute("class"));
		System.out.println("Element size: " + elem.getSize());
		System.out.println("Element located at: " + elem.getLocation());
	}

	public void refreshbrowser() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// ((DefaultSelenium) driver).refresh();
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
	}

	public void url(String url) throws InterruptedException {
		driver.get(url);
	}

	public void refreshbrowser1() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// ((DefaultSelenium) driver).refresh();
		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
	}

	
	 * public void Gen_maxmizeWindow() { driver.manage().window().maximize(); }
	 

	public boolean isPageContainsMetaTag() throws Exception {

		boolean s = driver.getPageSource().contains("<meta>");
		return (s);
	}

	public boolean isPageContainhttpProtocol() throws Exception {
		boolean s = driver.getPageSource().contains("http");
		return (s);

	}

	public String randomemailAddress() {
		StringBuffer sb = new StringBuffer("autotest");
		// sb.append(Long.toString(random.nextInt()));
		sb.append(getRandomLong(0, 999999999, random));
		sb.append("@mailinator1.com");
		return sb.toString();
	}

	public String generateRandamName() {
		StringBuffer sb = new StringBuffer("autotest");
		// sb.append(Long.toString(random.nextInt()));
		return sb.toString();
	}

	// added by sandip 13th jan

	public void display_element(String XpathElement) {
		driver.findElement(By.xpath(XpathElement)).isDisplayed();
	}

	public void scroll_page_down() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scrollTo(0,3000)");
		// driver.findElement(By.id("shell")).sendKeys(Keys.END);
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scrollTo(0,3000)");
	}

	// added for Santosh's script 19th feb
	public void waitForPageToLoad() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void ScrollPage() throws Exception {
		((JavascriptExecutor) driver).executeScript("scrollTo(0,3000)");
		// driver.findElement(By.id("shell")).sendKeys(Keys.END);
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scrollTo(0,3000)");
	}

	public void openUrl(String url) {
		driver.get(url);

	}

	public String switchToNewWindow() {
		try {

			String winHandleBefore = driver.getWindowHandle();

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		} catch (Exception e) {
			return "Fail:: Unable to Switch to New Window" + e.getMessage();
		}
		return "Pass:: Switched to New Window";
	}

	public void pressArrowDownByKeyword() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
	}

	public void pressEnterByKeyword() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.RETURN).build().perform();
	}

	public void pressTabByKeyword() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
	}

	public void pressESCByKeyword() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).build().perform();
		// waitAndClickByXpath("//*");
	}

	public void mouseOverToElementBylinkText(String parentElement)
			throws InterruptedException {
		WebElement wb = driver.findElement(By.linkText(parentElement));
		Actions act = new Actions(driver);
		act.moveToElement(wb).build().perform();
		Thread.sleep(500);

	}

	public void maxmizeWindow() {
		// driver.manage().window().maximize();
	}

	public String generateRandomMobNo() {
		Random random = new Random();
		StringBuilder pass = new StringBuilder();
		pass.append(getRandomLong(9000000000L, 9999999999L, random));
		return pass.toString();
	}

	public String generateRandomCard() {
		Random random = new Random();
		StringBuilder pass = new StringBuilder();
		pass.append(getRandomLong(9000000000L, 9999999999L, random));
		return pass.toString();
	}

	private long getRandomLong(long aStart, long aEnd, Random aRandom) {
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * aRandom.nextDouble());
		long randomNumber = (long) (fraction + aStart);
		return randomNumber;
	}

	public void sessionTimeoutWait(long timeInMin) throws Exception {
		Thread.sleep(timeInMin * 1000 * 60);

	}

	public static final String TEST_ENVIRONMENT = "the-site.com";

	public void login(String uname, String pwd) {
		String URL = "http://" + uname + ":" + pwd + "@" + TEST_ENVIRONMENT;
		driver.get(URL);
	}

	public Set<Cookie> getCookies() {

		return driver.manage().getCookies();

	}

	public String getCookiesValue(String cookieName) {

		return driver.manage().getCookieNamed(cookieName).toString();

	}

	public List<WebElement> findElementsByXpath(String xPathlocator) {
		List<WebElement> webElementsList = driver.findElements(By
				.xpath(xPathlocator));
		return webElementsList;
	}*/

	

	/*public void enablePopup() throws Exception {
		driver.get("chrome://settings/");
		driver.switchTo().frame(
				driver.findElement(By.xpath("//iframe [@name='settings']")));
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(
				"pop");
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(
				Keys.ENTER);
		clickByJavascriptExecuter("//button[@id='privacyContentSettingsButton']");
		clickByJavascriptExecuter("//input[@value='allow'][@name='popups']");
		driver.findElement(By.id("content-settings-overlay-confirm")).click();
		System.out.println("Enabled");
	}
*/
	public void waitForPageLoadJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			if (js.executeScript("return document.readyState").toString()
					.equals("complete"))
				break;
		}
	}
	
	public boolean waitForElement(String element) 
	{
		for(int i=0; i<2; i++)
		{
		try{
			Thread.sleep(1000);
			if(driver.findElement(By.xpath(element)).isDisplayed())
			{
				System.out.println("Element Found : "+element);
				return true;
			
			}
		   }
		catch(Exception e)
		{
			//System.out.println(e.getMessage());
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		}
		return false;
	}

	
	
	
/*public boolean checkElementPresense(String element)
{
	

	
	for(int i=0; i<5; i++)
	{
	try{
		if(driver.findElement(By.xpath(element)).isDisplayed())
		{
			
			return true;
		
		}
	   }
	catch(Exception e)
	{
		//System.out.println(e.getMessage());
	}
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	return false;
	
}
*/

	public void selectSavedBillingAddress(String text)
	{
		
		Select select=new Select(driver.findElement(By.xpath("//select[@id='billing-address-dropdown']")));
		for(int i=0; i<select.getOptions().size();i++)
		{
			if(select.getOptions().get(i).getText().contains(text))
					{
					select.selectByIndex(i);
					}
		}
	}
	
	public boolean elementPresent(String locater) throws InterruptedException
	{
		Thread.sleep(3000);
		try{
			if(driver.findElement(By.xpath(locater)).isDisplayed())
			{
				return true;
			}
			else
				return false;
			
			}
			catch(Exception e)
			{
				System.out.println(locater+ "Element Not Present");
			}
			return false;
	}
	
	
	
}
