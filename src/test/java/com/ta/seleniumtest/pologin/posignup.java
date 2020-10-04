package com.ta.seleniumtest.pologin;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class posignup extends TestBase {
	private NavigatetoXero testData;

	public posignup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		this.testData = new NavigatetoXero();
	}

	@FindBy(xpath = "//a[@class='btn btn-primary global-ceiling-bar-btn']")
	WebElement btn_signup;
	@FindBy(xpath = "//input[@name='FirstName']")
	WebElement ph_firstname;
	@FindBy(xpath = "//input[@name='LastName']")
	WebElement ph_lastname;
	@FindBy(xpath = "//input[@name='EmailAddress']")
	WebElement ph_email;
	@FindBy(xpath = "//input[@name='PhoneNumber']")
	WebElement ph_PhoneNumber;
	@FindBy(xpath = "//select[@name='LocationCode']")
	WebElement ph_locationcode;
	@FindBy(xpath = "//div[@class='g-recaptcha form-group invalid']")
	WebElement btn_captcha;
	@FindBy(xpath = "//span[@class='g-recaptcha-submit']")
	WebElement btn_submit;

	public void loginToWebsite() {
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
	}

	public void signUp(String firstname, String lastname, String emailaddress, String phonenumber, String country)
			throws FileNotFoundException, IOException {

		oBroUtil.ufClick(btn_signup);
		oBroUtil.explicitWaitfunc(ph_firstname, 10);
		oBroUtil.ufClick(ph_firstname);
		oBroUtil.ufClear(ph_firstname);
		oBroUtil.ufSendKeys(ph_firstname, firstname);
		oBroUtil.explicitWaitfunc(ph_lastname, 10);
		oBroUtil.ufClick(ph_lastname);
		oBroUtil.ufClear(ph_lastname);
		oBroUtil.ufSendKeys(ph_lastname, lastname);
		oBroUtil.explicitWaitfunc(ph_email, 10);
		oBroUtil.ufClick(ph_email);
		oBroUtil.ufClear(ph_email);
		oBroUtil.ufSendKeys(ph_email, emailaddress);
		oBroUtil.explicitWaitfunc(ph_PhoneNumber, 10);
		oBroUtil.ufClick(ph_PhoneNumber);
		oBroUtil.ufClear(ph_PhoneNumber);
		oBroUtil.ufSendKeys(ph_PhoneNumber, phonenumber);
		oBroUtil.ufDrpdownSelect(ph_locationcode, country);
		oBroUtil.ufClick(btn_captcha);
		oBroUtil.ufClick(btn_submit);

	}
}
