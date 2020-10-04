package com.ta.seleniumtest.login;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ta.seleniumtest.pologin.po_addanotherorg;
import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class Addanotherorg extends TestBase{
	po_addanotherorg oAddanotherorg;
	private NavigatetoXero navigateToXero;

	@BeforeTest
	public void triggerDependency() {
		oAddanotherorg = new po_addanotherorg(driver);
		this.navigateToXero = new NavigatetoXero();
	}

	@Test(dataProvider = "add_organization")
	public void loginToWebsite(String username, String password, String business, String Industry) throws FileNotFoundException, IOException, InterruptedException {
		oAddanotherorg.loginToWebsite();
		oAddanotherorg.correctLogin(username, password, business, Industry);
	}

	@DataProvider(name = "add_organization")
	private Object[][] getLoginData() throws FileNotFoundException, IOException {
		return this.navigateToXero.getDataforFile("add_organization");
	}
 
}
