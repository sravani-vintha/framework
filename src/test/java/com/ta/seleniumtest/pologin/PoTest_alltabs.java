package com.ta.seleniumtest.pologin;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.seleniumtest.xero.NavigatetoXero;
import com.ta.seleniumtest.xero.TestBase;

public class PoTest_alltabs extends TestBase{
	private NavigatetoXero testData;

	public PoTest_alltabs(WebDriver driver) {
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
	@FindBy(xpath="//a[@class='xrh-banner--returnaction']")
	WebElement btn_gobacktoself;
	@FindBy(xpath = "//a[@name='navigation-menu/dashboard']")
	WebElement btn_dashboard;
	@FindBy(xpath = "//button[@name='navigation-menu/accounting']")
	WebElement btn_accounting;
	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	WebElement btn_reports;
	@FindBy(xpath = "//button[@name='navigation-menu/contacts']")
	WebElement btn_contacts;
	@FindBy(xpath = "//div[@class='xrh-appbutton--body']//*[local-name()='svg']")
	WebElement btn_self;
	@FindBy(xpath = "//a[contains(text(),'Files')]")
	WebElement btn_files;
    @FindBy(xpath = "//a[contains(text(),'Settings')]")
	WebElement btn_settings;
    @FindBy(xpath = "//li[1]//button[1]//div[1]//*[local-name()='svg']")
	WebElement btn_quicklaunch;
    @FindBy(xpath = "//button[@class='xrh-button xrh-addon--iconbutton xrh-header--iconbutton xrh-focusable--parent xrh-focusable--parent-is-active']//div[@class='xrh-focusable--child xrh-iconwrapper']")
	WebElement btn_notification;
    @FindBy(xpath = "//li[2]//button[1]//div[1]//*[local-name()='svg']")
	WebElement btn_search;
    @FindBy(xpath = "//li[4]//button[1]//div[1]//*[local-name()='svg']//*[name()='path' and contains(@d,'M7.5 15a7.')]")
	WebElement btn_help;
  

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
		oBroUtil.explicitWaitfunc(btn_gobacktoself, 10);
		oBroUtil.ufClick(btn_gobacktoself);
        oBroUtil.explicitWaitfunc(btn_dashboard, 10);
		oBroUtil.ufClick(btn_dashboard);
		oBroUtil.explicitWaitfunc(btn_accounting, 10);
		oBroUtil.ufClick(btn_accounting);
		oBroUtil.explicitWaitfunc(btn_reports, 10);
		oBroUtil.ufClick(btn_reports);
		oBroUtil.explicitWaitfunc(btn_contacts, 10);
		oBroUtil.ufClick(btn_contacts);
		oBroUtil.explicitWaitfunc(btn_self, 10);
		oBroUtil.ufClick(btn_self);
		oBroUtil.explicitWaitfunc(btn_files, 10);
		oBroUtil.ufClick(btn_files);
		oBroUtil.explicitWaitfunc(btn_self, 10);
		oBroUtil.ufClick(btn_self);
		oBroUtil.explicitWaitfunc(btn_settings, 30);
		oBroUtil.ufClick(btn_settings);
		oBroUtil.explicitWaitfunc(btn_quicklaunch, 10);
		oBroUtil.ufClick(btn_quicklaunch);
		oBroUtil.explicitWaitfunc(btn_search, 10);
		oBroUtil.ufClick(btn_search);
        oBroUtil.explicitWaitfunc(btn_notification, 10);
		oBroUtil.ufClick(btn_notification);
		oBroUtil.explicitWaitfunc(btn_help, 10);
		oBroUtil.ufClick(btn_help);



	}



}
