package com.ta.seleniumtest.login;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ta.seleniumtest.pologin.PO_addanotherorg_premiumplan;
import com.ta.seleniumtest.pologin.Poaddanotherorg_starterplan;
import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class Addanotherorg_premiumplan extends TestBase{
	PO_addanotherorg_premiumplan oAddanotherorg_premiumplan;
	private NavigatetoXero navigateToXero;

	@BeforeTest
	public void triggerDependency() {
		oAddanotherorg_premiumplan = new PO_addanotherorg_premiumplan(driver);
		this.navigateToXero = new NavigatetoXero();
	}

	@Test(dataProvider = "credit_card")
	public void loginToWebsite(String username, String password, String business,String Industry, String streetaddress, String town, String zipcode,String cardnumber, String expdate, String cvc, String name)
			throws FileNotFoundException, IOException, InterruptedException {
		oAddanotherorg_premiumplan.loginToWebsite();
		oAddanotherorg_premiumplan.correctLogin(username, password, business, Industry);
		oAddanotherorg_premiumplan.address(streetaddress, town, zipcode);
		oAddanotherorg_premiumplan.creditCard(cardnumber, expdate, cvc, name);

	}

	@DataProvider(name = "credit_card")
	private Object[][] getLoginData() throws FileNotFoundException, IOException {
		return this.navigateToXero.getDataforFile("credit_card");
	}



}
