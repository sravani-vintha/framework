package com.ta.seleniumtest.login;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ta.seleniumtest.pologin.PO_addanotherorg_standardplan;
import com.ta.seleniumtest.pologin.Poaddanotherorg_starterplan;
import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class Addanotherorg_standardplan extends TestBase{
	PO_addanotherorg_standardplan oAddanotherorg_standardplan;
	private NavigatetoXero navigateToXero;

	@BeforeTest
	public void triggerDependency() {
		oAddanotherorg_standardplan = new PO_addanotherorg_standardplan(driver);
		this.navigateToXero = new NavigatetoXero();
	}

	@Test(dataProvider = "credit_card")
	public void loginToWebsite(String username, String password, String business,String Industry, String streetaddress, String town, String zipcode,String cardnumber, String expdate, String cvc, String name)
			throws FileNotFoundException, IOException, InterruptedException {

		oAddanotherorg_standardplan.loginToWebsite();
        oAddanotherorg_standardplan.correctLogin(username, password, business, Industry);
        oAddanotherorg_standardplan.address(streetaddress, town, zipcode);
        oAddanotherorg_standardplan.creditCard(cardnumber, expdate, cvc, name);

	}

	@DataProvider(name = "credit_card")
	private Object[][] getLoginData() throws FileNotFoundException, IOException {
		return this.navigateToXero.getDataforFile("credit_card");
	}


	}
