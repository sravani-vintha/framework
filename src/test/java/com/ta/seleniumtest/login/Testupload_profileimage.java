package com.ta.seleniumtest.login;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ta.seleniumtest.pologin.Po_Testupload_profileimage;
import com.ta.seleniumtest.pologin.pologin;
import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class Testupload_profileimage extends TestBase{
	Po_Testupload_profileimage oTestupload_profileimage;
	private NavigatetoXero navigateToXero;

	@BeforeTest
	public void triggerDependency() {
		oTestupload_profileimage = new Po_Testupload_profileimage(driver);
		this.navigateToXero = new NavigatetoXero();
	}

	@Test(dataProvider = "login_re")
	public void loginToWebsite(String username, String password) throws FileNotFoundException, IOException {
		oTestupload_profileimage.loginToWebsite();
		oTestupload_profileimage.correctLogin(username, password);
	}

	@DataProvider(name = "login_re")
	private Object[][] getLoginData() throws FileNotFoundException, IOException {
		return this.navigateToXero.getDataforFile("login_re");
	}


}
