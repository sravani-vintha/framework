package com.ta.seleniumtest.login;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ta.seleniumtest.pologin.posignuotoxdc;
import com.ta.seleniumtest.pologin.posignup;
import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class signuptoxdc extends TestBase{
	 posignuotoxdc osignuptoxdc;
//	private NavigatetoXero navigateToXero;

	@BeforeTest
	public void triggerDependency() {
		osignuptoxdc = new posignuotoxdc(driver);
		
//		this.navigateToXero = new NavigatetoXero();
	}
	@Test
	public void signUpTestCase()
	{
		osignuptoxdc.loginToWebsite();
		osignuptoxdc.signuptoxdc();
	
	}


}
