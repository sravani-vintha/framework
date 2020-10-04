package com.ta.seleniumtest.pologin;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class pologin extends TestBase {
	private NavigatetoXero testData;

	public pologin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		this.testData = new NavigatetoXero();
	}

	@FindBy(xpath = "//input[@id='xl-form-email']")
	WebElement ph_email;
	@FindBy(xpath = "//input[@id='xl-form-password']")
	WebElement ph_password;
	@FindBy(xpath = "//button[@id='xl-form-submit']")
	WebElement btn_submit;
	@FindBy(xpath = "//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']")
	WebElement btn_login;

	public void loginToWebsite() {
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
	}

	public void correctLogin(String username, String password) throws FileNotFoundException, IOException {
		oBroUtil.ufClick(btn_login);
		oBroUtil.explicitWaitfunc(ph_email, 10);
		oBroUtil.ufClick(ph_email);
		oBroUtil.ufClear(ph_email);
		oBroUtil.ufSendKeys(ph_email, username);
		oBroUtil.explicitWaitfunc(ph_password, 10);
		oBroUtil.ufClick(ph_password);
		oBroUtil.ufClear(ph_password);
		oBroUtil.ufSendKeys(ph_password, password);
		oBroUtil.ufClick(btn_submit);
	}

}
