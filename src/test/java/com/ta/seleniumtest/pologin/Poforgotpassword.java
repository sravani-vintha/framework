package com.ta.seleniumtest.pologin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class Poforgotpassword extends TestBase {
	private NavigatetoXero testData;

	public Poforgotpassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		this.testData = new NavigatetoXero();
	}

	@FindBy(xpath = "//a[contains(text(),'Forgot password?')]")
	WebElement btn_forgotpassword;
	@FindBy(xpath = "//input[@id='Email']")
	WebElement ph_email;
	@FindBy(xpath = "//button[@id='submit-reset-password']")
	WebElement btn_sendlink;
	@FindBy(xpath = "//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']")
	WebElement btn_login;

	public void loginToWebsite() {
		driver.manage().window().maximize();
		driver.get("https://www.xero.com/us/");
	}

	public void Forgotpassword(String email) {
		oBroUtil.ufClick(btn_login);
		oBroUtil.explicitWaitfunc(btn_forgotpassword, 10);
		oBroUtil.ufClick(btn_forgotpassword);
		oBroUtil.explicitWaitfunc(ph_email, 10);
		oBroUtil.ufClick(ph_email);
		oBroUtil.ufSendKeys(ph_email, email);
		oBroUtil.ufClick(btn_sendlink);
	}

}
