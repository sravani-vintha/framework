package com.ta.seleniumtest.xero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.ta.seleniumtest.utilities.GlobalConfig;

public class TestBase {
	public static BrowserUtility oBroUtil = new BrowserUtility();
	public WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest logger;
	String sPath = System.getProperty("user.dir") + "/ExtentReport/samplereportBrowser.html";

	@BeforeSuite
	public void launch() throws InterruptedException, IOException {
		reports = new ExtentReports(sPath);
		Properties configProp = new Properties();

		String path = System.getProperty("user.dir");

		configProp.load(new FileInputStream(path + "/resources/properties/config.properties"));
		
		GlobalConfig.getInstance().configureInstance(configProp);
		
		driver = oBroUtil.launchBrowser("ch");
//		Thread.sleep(3000);
	}

	@AfterSuite
	public void closingTest() throws InterruptedException {
		oBroUtil.tearDownBrowser();
		reports.flush();
	}
	
	@BeforeTest
	public void loadDriver() {
		if (driver == null) {
			driver = oBroUtil.launchBrowser("ch");
		}
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
