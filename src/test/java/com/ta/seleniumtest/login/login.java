package com.ta.seleniumtest.login;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ta.seleniumtest.pologin.pologin;
import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class login extends TestBase {
	pologin oLogin;
	private NavigatetoXero navigateToXero;

	@BeforeTest
	public void triggerDependency() {
		oLogin = new pologin(driver);
		this.navigateToXero = new NavigatetoXero();
	}

	@Test(dataProvider = "login-data")
	public void loginToWebsite(String username, String password) throws FileNotFoundException, IOException, InterruptedException {
		oLogin.loginToWebsite();
		Thread.sleep(3000);
		oLogin.correctLogin(username, password);
	}

	@DataProvider(name = "login-data")
	private Object[][] getLoginData() throws FileNotFoundException, IOException {
		return this.navigateToXero.getDataforFile("login");
	}
}
