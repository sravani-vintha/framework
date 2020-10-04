package com.ta.seleniumtest.xero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.ta.seleniumtest.utilities.GlobalConfig;

public class NavigatetoXero extends TestBase {
	@BeforeMethod
	public void login() throws InterruptedException {
		oBroUtil.loginToWebsite();
		Thread.sleep(3000);
	}

	static int count = 0;

	@Test(dataProvider = "UserDataLogin")
	public void NavigateToXero(String sUserName, String sPassword, String sxpath) throws Exception {
		count++;
		logger = reports.startTest("NavigateToXero_" + count);
		oBroUtil.correctLogin(sUserName, sPassword);
		logger.log(LogStatus.INFO, "Login button clicked");
		oBroUtil.explicitWaitfunc(driver.findElement(By.xpath(sxpath)), 10);
		Assert.assertEquals(driver.findElement(By.xpath(sxpath)).isDisplayed(), true);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String sPathOfScreenshot = System.getProperty("user.dir") + "//screenshot/screenshot_" + "NavigateToXero_"
				+ count + ".png";
		File dest = new File(sPathOfScreenshot);
		FileUtils.copyFile(source, dest);
		logger.log(LogStatus.INFO, "TestCase is passed");
		logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOfScreenshot));
		reports.endTest(logger);
	}

//	public Object[][] getDataforLogin() throws FileNotFoundException, IOException {
//		return readExcelAndReturnObject(System.getProperty("user.dir") + GlobalConfig.getInstance().getTestDataFileUrl());
//	}

	public Object[][] getDataforFile(String sheetName) throws FileNotFoundException, IOException {
		HSSFWorkbook myExcelBook = new HSSFWorkbook(
				new FileInputStream(System.getProperty("user.dir") + GlobalConfig.getInstance().getTestDataFileUrl()));
		HSSFSheet worksheet = myExcelBook.getSheet(sheetName);// get my sheet from workbook
		HSSFRow Row = worksheet.getRow(0); // get my Row which start from 0
		DataFormatter formatter= new DataFormatter();

		int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
		int ColNum = Row.getLastCellNum(); // get last ColNum

		Object Data[][] = new Object[RowNum - 1][ColNum]; // pass my count data in array

		for (int i = 0; i < RowNum - 1; i++) // Loop work for Rows
		{
			HSSFRow row = worksheet.getRow(i + 1);

			for (int j = 0; j < ColNum; j++) // Loop work for colNum
			{
				if (row == null)
					Data[i][j] = "";
				else {
					HSSFCell cell = row.getCell(j);
					if (cell == null)
						Data[i][j] = ""; // if it get Null value it pass no data
					else {
						String value = formatter.formatCellValue(cell);
						Data[i][j] = value; 
					}
				}
			}
		}

		return Data;

	}

}
