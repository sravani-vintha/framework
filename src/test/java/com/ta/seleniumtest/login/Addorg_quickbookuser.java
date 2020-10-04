package com.ta.seleniumtest.login;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ta.seleniumtest.pologin.PO_addorg_quickbookuser;
import com.ta.seleniumtest.pologin.Paddanotherorgver1;
import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class Addorg_quickbookuser extends TestBase{
	 PO_addorg_quickbookuser oAddanotherorg_quickbookuser;
		private NavigatetoXero navigateToXero;

		@BeforeTest
		public void triggerDependency() {
			oAddanotherorg_quickbookuser = new PO_addorg_quickbookuser(driver);
			this.navigateToXero = new NavigatetoXero();
		}

		@Test(dataProvider = "add_organization")
		public void loginToWebsite(String username, String password, String business, String Industry)
				throws FileNotFoundException, IOException, InterruptedException {
			oAddanotherorg_quickbookuser.loginToWebsite();
			oAddanotherorg_quickbookuser.correctLogin(username, password, business, Industry);
		}

		@DataProvider(name = "add_organization")
		private Object[][] getLoginData() throws FileNotFoundException, IOException {
			return this.navigateToXero.getDataforFile("add_organization");
		}



}
