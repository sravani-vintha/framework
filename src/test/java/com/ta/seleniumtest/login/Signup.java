package com.ta.seleniumtest.login;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ta.seleniumtest.pologin.posignup;
import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class Signup extends TestBase {
	posignup osignup;
	private NavigatetoXero navigateToXero;

	@BeforeTest
	public void triggerDependency() {
		osignup = new posignup(driver);
		this.navigateToXero = new NavigatetoXero();
	}

	@Test(dataProvider = "sign-up")
	public void signUp(String firstname, String lastname, String emailaddress, String phonenumber, String country)
			throws FileNotFoundException, IOException {
		osignup.loginToWebsite();
		osignup.signUp(firstname, lastname, emailaddress, phonenumber, country);

	}

	@DataProvider(name = "sign-up")
	private Object[][] getLoginData() throws FileNotFoundException, IOException {
		return this.navigateToXero.getDataforFile("sign-up");
	}

}
