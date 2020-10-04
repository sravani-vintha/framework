package com.ta.seleniumtest.login;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ta.seleniumtest.pologin.Paddanotherorgver1;
import com.ta.seleniumtest.pologin.po_addanotherorg;
import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class Addanotherorgver1 extends TestBase {
	Paddanotherorgver1 oAddanotherorgver1;
	private NavigatetoXero navigateToXero;

	@BeforeTest
	public void triggerDependency() {
		oAddanotherorgver1 = new Paddanotherorgver1(driver);
		this.navigateToXero = new NavigatetoXero();
	}

	@Test(dataProvider = "add_organization")
	public void loginToWebsite(String username, String password, String business, String Industry)
			throws FileNotFoundException, IOException, InterruptedException {
		oAddanotherorgver1.loginToWebsite();
		oAddanotherorgver1.correctLogin(username, password, business, Industry);
	}

	@DataProvider(name = "add_organization")
	private Object[][] getLoginData() throws FileNotFoundException, IOException {
		return this.navigateToXero.getDataforFile("add_organization");
	}

}
