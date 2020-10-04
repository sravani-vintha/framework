package com.ta.seleniumtest.xero;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility extends TestBase {

	public WebDriver launchBrowser(String sBrowserName) {

		switch (sBrowserName) {
		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ch":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			break;
		}
		return driver;

	}

	public void explicitWaitfunc(WebElement ele, int iTime) {
		WebDriverWait wait1 = new WebDriverWait(driver, iTime);
		wait1.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForElementLocated(By path, int iTime) {
		WebDriverWait wait1 = new WebDriverWait(driver, iTime);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(path));
	}

	public void waitForElementToBeClickable(By path, int iTime) {
		WebDriverWait wait1 = new WebDriverWait(driver, iTime);
		wait1.until(ExpectedConditions.elementToBeClickable(path));
	}

	public void waitForElementToBeVisible(By path, int iTime) {

		WebDriverWait wait = new WebDriverWait(driver, iTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(path));
	}

	public void loginToWebsite() {
		driver.manage().window().maximize();
		driver.get("https://www.xero.com/us/");
		driver.findElement(By.xpath("//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']")).click();
	}


	public void correctLogin(String sUsername, String sPassword) {
		explicitWaitfunc(driver.findElement(By.xpath("email")), 10);
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(sUsername);
		driver.findElement(By.id("password"));
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(sPassword);
		driver.findElement(By.id("submitButton")).click();

	}

	public void tearDownBrowser() {
		driver.quit();
	}

	public void ufClick(WebElement ele) {
		ele.click();
	}

	public void ufClear(WebElement ele) {
		ele.clear();
	}

	public void ufSendKeys(WebElement ele, String te) {
		ele.sendKeys(te);
	}

	public void ufDrpdownSelect(WebElement ele, String te) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
		actions.perform();
		Select countryDropdown = new Select(ele);
		if (!countryDropdown.getFirstSelectedOption().equals(te)) {
			countryDropdown.selectByVisibleText(te);
		}

	}
	
	public void ufCustomDrpdownSelect(WebElement ele, WebElement eleToSelect) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
		actions.perform();
		eleToSelect.click();
	}

	public void ufRadiobutton(WebElement ele) {
		ele.click();
	}

	public void switchTab() {
		String currentTabHandle = driver.getWindowHandle();
		String newTabHandle = driver.getWindowHandles().stream().filter(handle -> !handle.equals(currentTabHandle))
				.findFirst().get();
		driver.switchTo().window(newTabHandle);

	}
	public void switchToIframe(WebElement iFrameEle) {
		oBroUtil.explicitWaitfunc(iFrameEle, 10);
		driver.switchTo().frame(iFrameEle);
	}

	public void switchToIframe1(WebElement ele) {
		// TODO Auto-generated method stub
		oBroUtil.explicitWaitfunc(ele, 10);
		driver.switchTo().frame(ele);
	}


}
