package com.frameWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.extentReport.ExtentManager;

public class TestBase {

	public WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlReporter;

	@BeforeSuite
	public void beforeSuite() throws IOException {
		 FileInputStream fis = new
				  FileInputStream(System.getProperty("user.dir") +
				  "\\resources\\config.properties"); prop = new Properties();
				  prop.load(fis); System.out.println("Property File loaded");

		if (ExtentManager.getInstance() == null)
			extent = ExtentManager.createInstance("C:\\Users\\Admin\\workspace\\Framework\\report\\ExecutionReport.html");

		/*
		 * ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
		 * "C:\\Users\\Admin\\workspace\\Framework\\report\\repo.html");
		 * htmlReporter.loadXMLConfig(
		 * "C:\\Users\\Admin\\workspace\\Framework\\extenthtmlreporter.xml");
		 * extent = new ExtentReports(); extent.attachReporter(htmlReporter);
		 * extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		 * extent.setSystemInfo("Environment", "Production");
		 * extent.setSystemInfo("User Name", "Nagarjuna");
		 * htmlReporter.config().
		 * setDocumentTitle("Title of the Report Comes here ");
		 * htmlReporter.config().setReportName("Name of the Report Comes here "
		 * ); htmlReporter.config().setTheme(Theme.STANDARD);
		 * 
		 * FileInputStream fis = new
		 * FileInputStream(System.getProperty("user.dir") +
		 * "\\resources\\config.properties"); prop = new Properties();
		 * prop.load(fis); System.out.println("Property File loaded");
		 * System.out.println("Created extent manager instance"); // return;
		 */
	}

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser, Method method) throws IOException {
		logger = extent.createTest(method.getName(), method.getAnnotation(Test.class).testName())
				.assignCategory(this.getClass().getSimpleName()).assignCategory("Smoke Test");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","D:\\Softwares\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case failed", ExtentColor.RED));
			setCellData(Status.FAIL.toString(), result.getName(), 1);
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
			setCellData(Status.SKIP.toString(), result.getName(), 1);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			setCellData(Status.PASS.toString(), result.getName().toString(), 1);
		}
		driver.quit();
	}

	public void setCellData(String result, String testName, int column) {
		try {
			File file = new File(prop.getProperty("smoketestsuite"));
			InputStream is = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheet("Smoke");
			boolean flag = Boolean.TRUE;
			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				XSSFRow row = sheet.getRow(i);
				if (row.getCell(1).getStringCellValue().equalsIgnoreCase(testName)) {
					Cell cell = row.createCell(4);
					cell.setCellValue(result);
					flag = Boolean.FALSE;
					continue;
				}
			}
			if (flag) {
				System.err.println("No Test found");
			}
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() throws Exception {
		System.out.println("in after suite............");
		extent.flush();
	}

}
