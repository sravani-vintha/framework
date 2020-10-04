package com.ta.seleniumtest.xero;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestID01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sPath = System.getProperty("user.dir")+"/ExtentReport/samplereport.html";
         ExtentReports reports = new ExtentReports(sPath);
         ExtentTest logger;
         logger = reports.startTest("Test Case1");
         logger.log(LogStatus.INFO, "Test case started");
         logger.log(LogStatus.INFO, "username = sravani");
         logger.log(LogStatus.PASS, "Login success");
         reports.endTest(logger);
         reports.flush();
         System.out.println("Report successful");

         
	}

}
