package com.ta.seleniumtest.login;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ta.seleniumtest.pologin.PoLogout;
import com.ta.seleniumtest.pologin.pologin;
import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class LogOut extends TestBase{
	PoLogout oLogout;
	private NavigatetoXero navigateToXero;

	@BeforeTest
	public void triggerDependency() {
		oLogout = new PoLogout(driver);
		this.navigateToXero = new NavigatetoXero();
	}

	@Test(dataProvider = "login_re")
	public void loginToWebsite(String username, String password) throws FileNotFoundException, IOException {
		oLogout.loginToWebsite();
		oLogout.correctLogin(username, password);
	}

	@DataProvider(name = "login_re")
	private Object[][] getLoginData() throws FileNotFoundException, IOException {
		return this.navigateToXero.getDataforFile("login_re");
	}


}
