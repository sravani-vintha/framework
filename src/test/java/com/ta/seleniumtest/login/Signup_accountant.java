package com.ta.seleniumtest.login;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ta.seleniumtest.pologin.PosignUp_accountant;
import com.ta.seleniumtest.xero.TestBase;

public class Signup_accountant extends TestBase{
	 PosignUp_accountant osignup_accountant;
//		private NavigatetoXero navigateToXero;

		@BeforeTest
		public void triggerDependency() {
			osignup_accountant = new PosignUp_accountant(driver);
			
//			this.navigateToXero = new NavigatetoXero();
		}
		@Test
		public void signUp_accountant() throws InterruptedException
		{
			osignup_accountant.loginToWebsite();
			Thread.sleep(3000);
			osignup_accountant.signup_accountant();
		
		}


}
