package com.ta.seleniumtest.login;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ta.seleniumtest.pologin.posignuotoxdc;
import com.ta.seleniumtest.pologin.posignupseefulloffer;
import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class signupseefulloffer extends TestBase{
	 posignupseefulloffer osignupseefulloffer;
	private NavigatetoXero navigateToXero;

	@BeforeTest
	public void triggerDependency() {
		osignupseefulloffer = new posignupseefulloffer(driver);
		this.navigateToXero = new NavigatetoXero();
	}
	@Test
	public void signUpseeFullTestCase() throws InterruptedException
	{
		osignupseefulloffer.loginToWebsite();
		Thread.sleep(3000);
		osignupseefulloffer.signupseefulloffer();
	
	}



}
