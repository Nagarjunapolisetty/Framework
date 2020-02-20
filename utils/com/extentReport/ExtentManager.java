package com.extentReport;


import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentManager {
	
	static ExtentReports extent;
	private  static String testContext = new String();
	private static String exeEnv = new String();
	private static String exeBrand = new String();
	public static ExtentTest logger;
	
	public static ExtentReports getInstance() {
		return extent;
	}
	
	/**
	 * Method to return test context as a suite name
	 * This suite name will be displayed on extent report header per brand(Catherines, dressbarn, maurices, justice, lanebryant etc.)
	 * @return testContext
	 */
	public  static String getTestSuiteName() {
		return testContext;
	}
	
	public  static String getTestEnvName() {
		return exeEnv.toUpperCase();
	}
	
	public  static String getTestBrandName() {
		return exeBrand;
	}
	
	
	public synchronized static void getSuiteName(ITestContext ctx){
		testContext = ctx.getCurrentXmlTest().getSuite().getName();
	}
	
	public synchronized static void getEnvName(ITestContext ctx){
		exeEnv = ctx.getCurrentXmlTest().getLocalParameters().get("env");
	}
	
	public synchronized static void getBrandName(ITestContext ctx){
		exeBrand = ctx.getCurrentXmlTest().getLocalParameters().get("brand");
	}
	
	public static synchronized ExtentReports createInstance(String extentHtmlFileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(extentHtmlFileName);
		htmlReporter.loadXMLConfig("C:\\Users\\Admin\\workspace\\Framework\\extenthtmlreporter.xml");
		//htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\extenthtmlreporter.xml"), null);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
//		extent.setSystemInfo("OS", Platform.getCurrent().toString());
//		extent.setSystemInfo("Host Name", "Ascena");
		//extent.setSystemInfo("Environment", "QA");
		
		extent.setSystemInfo("Environment", ExtentManager.getTestEnvName().toUpperCase());
		extent.setSystemInfo("User Name", System.getProperty("user.name"));

		//htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle(getTestSuiteName() + " Automation Status Report");
		htmlReporter.config().setReportName(getTestSuiteName() + " Automation Status Report");
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
		return extent;
	}

	
}
