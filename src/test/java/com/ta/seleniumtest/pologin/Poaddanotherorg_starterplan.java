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

public class Poaddanotherorg_starterplan extends TestBase {
	private NavigatetoXero testData;

	public Poaddanotherorg_starterplan(WebDriver driver) {
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
	@FindBy(xpath = "//button[@class='xui-button xui-actions--secondary button__2_4F- xui-button-standard xui-button-medium xui-button-fullwidth']")
	WebElement btn_Buynow;
	@FindBy(xpath = "//div[@class='xui-padding-top xui-padding-left plancard-popular']//div[@class='xui-styledcheckboxradio--radio xui-styledcheckboxradio--radio-medium']")
	WebElement btn_checkbox;
	@FindBy(xpath = "//span[contains(text(),'Continue to select billing account')]")
	WebElement btn_continue;
	@FindBy(xpath = "//input[@name='contactAddress']")
	WebElement ph_streetaddress;
	@FindBy(xpath = "//input[@name='contactCity']")
	WebElement ph_town;
	@FindBy(xpath = "//div[@id='postalAddress']//div//div//button//div")
	WebElement drpdown_state;
	@FindBy(xpath = "//li[@id='California']//span[contains(text(),'California')]")
	WebElement btn_california;
	@FindBy(xpath = "//input[@name='contactPostalCode']")
	WebElement ph_zipcode;
	@FindBy(xpath = "//span[contains(text(),'Continue to review & pay')]")
	WebElement btn_continuetoreview;
	@FindBy(xpath = "//div[@id='stripe-card-number']//div//iframe")
	WebElement cc_iFrame;
    @FindBy(xpath = "//div[@id='stripe-card-expiry']//div//iframe")
	WebElement ce_iFrame;
	@FindBy(xpath = "//div[@id='stripe-card-cvc']//div//iframe")
	WebElement cvc_iFrame;
	
	@FindBy(xpath = "//span[contains(text(),'Credit card')]")
	WebElement btn_Creditcard;
	@FindBy(name = "cardnumber")
	WebElement ph_cardnumber;
	@FindBy(name = "exp-date")
	WebElement ph_expDate;
    @FindBy(name = "cvc")
	WebElement ph_cvc;
	@FindBy(xpath = "//input[@id='stripe-cardholder-name']")
	WebElement ph_Cardname;
	@FindBy(xpath = "//span[contains(text(),'Confirm purchase')]")
	WebElement btn_confirmPurchase;

	public void loginToWebsite() {
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
	}

	public void correctLogin(String username, String password, String business, String Industry)
			throws FileNotFoundException, IOException, InterruptedException {
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
		oBroUtil.explicitWaitfunc(btn_Buynow, 10);
		oBroUtil.ufClick(btn_Buynow);
		oBroUtil.explicitWaitfunc(btn_checkbox, 10);
		oBroUtil.ufClick(btn_checkbox);
		oBroUtil.explicitWaitfunc(btn_continue, 10);
		oBroUtil.ufClick(btn_continue);
	}
		public void address(String streetaddress, String town, String zipcode) {
		oBroUtil.explicitWaitfunc(ph_streetaddress, 10);
		oBroUtil.ufSendKeys(ph_streetaddress, streetaddress);
		oBroUtil.explicitWaitfunc(ph_town, 10);
		oBroUtil.ufSendKeys(ph_town, town);
		oBroUtil.explicitWaitfunc(drpdown_state, 10);
		drpdown_state.click();
		oBroUtil.ufClick(btn_california);
		oBroUtil.explicitWaitfunc(ph_zipcode, 10);
		oBroUtil.ufSendKeys(ph_zipcode, zipcode);
		oBroUtil.explicitWaitfunc(btn_continuetoreview, 10);
		oBroUtil.ufClick(btn_continuetoreview);
		}
	
	public void creditCard(String cardnumber, String expdate, String cvc, String name) {
		oBroUtil.explicitWaitfunc(btn_Creditcard, 10);
		oBroUtil.ufClick(btn_Creditcard);
		oBroUtil.switchToIframe1(cc_iFrame);
		oBroUtil.explicitWaitfunc(ph_cardnumber, 10);
		oBroUtil.ufSendKeys(ph_cardnumber, cardnumber);
		driver.switchTo().defaultContent();
		oBroUtil.switchToIframe1(ce_iFrame);
        oBroUtil.explicitWaitfunc(ph_expDate, 10);
		oBroUtil.ufSendKeys(ph_expDate, expdate);
		driver.switchTo().defaultContent();
		oBroUtil.switchToIframe1(cvc_iFrame);
        oBroUtil.explicitWaitfunc(ph_cvc, 10);
		oBroUtil.ufSendKeys(ph_cvc, cvc);
		driver.switchTo().defaultContent();
        oBroUtil.explicitWaitfunc(ph_Cardname, 10);
		oBroUtil.ufSendKeys(ph_Cardname, name);
        oBroUtil.explicitWaitfunc(btn_confirmPurchase, 10);
		oBroUtil.ufClick(btn_confirmPurchase);
	}

	

}
