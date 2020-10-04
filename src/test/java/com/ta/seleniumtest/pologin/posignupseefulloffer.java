package com.ta.seleniumtest.pologin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.seleniumtest.xero.TestBase;

public class posignupseefulloffer extends TestBase {
	public posignupseefulloffer(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//header/nav[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
	WebElement btn_Freetrail;
	@FindBy(xpath="//a[contains(text(),'offer details')]")
	WebElement btn_Offerdetails;

	public void loginToWebsite() {
		driver.manage().window().maximize();
		driver.get("https://www.xero.com/us/");
	}

	public void signupseefulloffer() throws InterruptedException {
   oBroUtil.explicitWaitfunc(btn_Freetrail, 10);
		oBroUtil.ufClick(btn_Freetrail);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",btn_Offerdetails);
     Thread.sleep(3000);
    oBroUtil.explicitWaitfunc(btn_Offerdetails, 10);
    oBroUtil.ufClick(btn_Offerdetails);
	}
}
