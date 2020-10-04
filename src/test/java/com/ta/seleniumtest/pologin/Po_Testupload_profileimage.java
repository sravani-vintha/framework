package com.ta.seleniumtest.pologin;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class Po_Testupload_profileimage extends TestBase{
	private NavigatetoXero testData;

	public Po_Testupload_profileimage(WebDriver driver) {
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
	@FindBy(xpath = "//abbr[@class='xrh-avatar xrh-avatar-color-2']")
	WebElement btn_usermenu;
	@FindBy(xpath = "//h4[@class='xrh-verticalmenuitem--heading']")
	WebElement btn_profile;
	@FindBy(xpath = "//span[contains(text(),'Upload Image')]")
	WebElement btn_uploadImage;
	@FindBy(xpath = "//input[@name='file']")
	WebElement file_input;
	@FindBy(xpath = "//div[@class='x-btn x-exclude x-unselectable x-btn-default-small x-noicon x-btn-noicon x-btn-default-small-noicon']")
	WebElement btn_browse; 

	@FindBy(xpath = "//div[@class='x-btn blue x-exclude x-unselectable x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']//span[@class='x-btn-inner x-btn-inner-center'][contains(text(),'Upload')]")
	WebElement btn_upload;
	


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
		oBroUtil.ufClick(btn_usermenu);
		oBroUtil.ufClick(btn_profile);
		oBroUtil.ufClick(btn_uploadImage);
		oBroUtil.explicitWaitfunc(btn_browse, 10);
//		oBroUtil.ufClick(btn_browse);
		file_input.sendKeys("C:\\Users\\REDDY\\Pictures\\butterfly.jpg");
		oBroUtil.explicitWaitfunc(btn_upload, 10);
		oBroUtil.ufClick(btn_upload);

	}



}
