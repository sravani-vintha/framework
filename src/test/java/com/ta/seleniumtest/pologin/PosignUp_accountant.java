package com.ta.seleniumtest.pologin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.seleniumtest.xero.TestBase;

public class PosignUp_accountant extends TestBase{
	public PosignUp_accountant(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='btn btn-primary global-ceiling-bar-btn']")
	WebElement btn_signup;
	@FindBy(xpath = "//a[contains(text(),'accountant or bookkeeper')]")
	WebElement btn_accountant;
	public void loginToWebsite() {
		driver.manage().window().maximize();
		driver.get("https://www.xero.com/us/");
	}

	public void signup_accountant() {
		oBroUtil.ufClick(btn_signup);
		oBroUtil.ufClick(btn_accountant);
		

	}

	

}
