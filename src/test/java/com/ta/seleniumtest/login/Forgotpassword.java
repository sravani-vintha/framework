package com.ta.seleniumtest.login;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ta.seleniumtest.pologin.Poforgotpassword;
import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class Forgotpassword extends TestBase {
	Poforgotpassword oForgotpassword;
	private NavigatetoXero navigateToXero;

	@BeforeTest
	public void triggerDependency() {
		oForgotpassword = new Poforgotpassword(driver);
		this.navigateToXero = new NavigatetoXero();
	}

	@Test(dataProvider = "forgot-password")
	public void loginToWebsite(String email) throws FileNotFoundException, IOException {
		oForgotpassword.loginToWebsite();
		oForgotpassword.Forgotpassword(email);

	}
	
	@DataProvider(name = "forgot-password")
	private Object[][] getLoginData() throws FileNotFoundException, IOException {
		return this.navigateToXero.getDataforFile("forgot-password");
	}

}
