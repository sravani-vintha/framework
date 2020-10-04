package com.ta.seleniumtest.pologin;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class PO_addorg_quickbookuser extends TestBase{
	private NavigatetoXero testData;

	public PO_addorg_quickbookuser(WebDriver driver) {
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
	@FindBy(xpath = "//span[@class='xrh-appbutton--text']")
	WebElement btn_self;
	@FindBy(xpath = "//a[contains(text(),'My Xero')]")
	WebElement btn_Myxero;
	@FindBy(xpath = "//a[@id='ext-gen1042']")
	WebElement btn_addorg;
	@FindBy(xpath = "//input[@class='xui-textinput--input xui-textinput--input-medium']")
	WebElement ph_business;
	@FindBy(xpath = "//input[@placeholder='eg: professional services, construction, retail']")
	WebElement ph_industry;
	@FindBy(xpath = "//div[@class='xui-textinput--sideelement xui-textinput--sideelement-align-center xui-textinput--sideelement-icon']")
	WebElement drpdown_country;
	@FindBy(xpath = "//div[@class='clickable__3S64J xui-textinputwrapper']//div//*[local-name()='svg']")
	WebElement drpdown_time;
	@FindBy(xpath = "//div[@class='panel-width-max__3w8jt xui-panel--section box-shadow-remove__3juP5']//div[2]//label[1]//div[1]")
	WebElement eleselect;
	@FindBy(xpath = "//a[@id='conversion-footer-link']")
	WebElement btn_seeDetails;



	public void loginToWebsite() {
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
	}

	public void correctLogin(String username, String password, String business, String Industry) throws FileNotFoundException, IOException, InterruptedException {
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
		oBroUtil.ufClick(btn_self);
		oBroUtil.explicitWaitfunc(btn_Myxero, 10);
		oBroUtil.ufClick(btn_Myxero);
		Thread.sleep(3000);
		oBroUtil.switchTab();
		oBroUtil.explicitWaitfunc(btn_addorg, 10);
		oBroUtil.ufClick(btn_addorg);
		oBroUtil.explicitWaitfunc(ph_business, 10);
		oBroUtil.ufSendKeys(ph_business, business);
		oBroUtil.explicitWaitfunc(ph_industry, 10);
		oBroUtil.ufSendKeys(ph_industry, Industry);
		oBroUtil.explicitWaitfunc(drpdown_country, 10);
		drpdown_country.click();
		oBroUtil.explicitWaitfunc(driver.findElement(By.id("CNTRY/US")), 10);
		WebElement eleToSelect = driver.findElement(By.id("CNTRY/US"));
		oBroUtil.ufCustomDrpdownSelect(drpdown_country, eleToSelect);
		oBroUtil.explicitWaitfunc(driver.findElement(By.className("trigger-text__18E4o")), 10);
		WebElement eleToSelect1 = driver.findElement(By.className("trigger-text__18E4o"));
		oBroUtil.ufCustomDrpdownSelect(drpdown_time, eleToSelect1);
        oBroUtil.explicitWaitfunc(eleselect, 10);
		oBroUtil.ufClick(eleselect);
		oBroUtil.explicitWaitfunc(btn_seeDetails, 10);
		oBroUtil.ufClick(btn_seeDetails);
}
}