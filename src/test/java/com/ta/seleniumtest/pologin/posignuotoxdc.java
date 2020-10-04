package com.ta.seleniumtest.pologin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.seleniumtest.xero.TestBase;

public class posignuotoxdc extends TestBase {

	public posignuotoxdc(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-primary global-ceiling-bar-btn']")
	WebElement btn_signup;
	@FindBy(xpath = "//input[@name='TermsAccepted']")
	WebElement btn_checkbox;
	@FindBy(xpath = "//span[@class='g-recaptcha-submit']")
	WebElement btn_submit;

	public void loginToWebsite() {
		driver.manage().window().maximize();
		driver.get("https://www.xero.com/us/");
	}

	public void signuptoxdc() {
		oBroUtil.ufClick(btn_signup);
		oBroUtil.ufClick(btn_checkbox);
		oBroUtil.ufClick(btn_submit);

	}

}
