package com.hrm.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.framework.constants.WaitStrategy;
import com.framework.driver.DriverManager;
import com.framework.reports.ExtentLogger;
import com.framework.reports.ExtentReport;
import com.framework.reports.ExtentReportManager;
import com.framework.utils.DecodeUtils;

public final class LoginPage extends BasePage{

	private final By textbox_username = By.name("username"); 
	private final By textbox_password = By.name("password"); 
	private final By button_login = By.xpath("//button[@type='submit']");
 
//	 private final By textbox_username =By.xpath("//input[@id='edit-name']");
//	 private final By textbox_password = By.xpath("//input[@id='edit-pass']");
//	 private final By button_login =By.id("edit-submit");
//	

	public LoginPage enterUserName(String username) {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		/*
		 * try { new WebDriverWait(DriverManager.getDriver(),
		 * Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//div[@class='ts-cookies__close']"))); new
		 * Actions(DriverManager.getDriver()).click(DriverManager.getDriver().
		 * findElement(By.xpath("//div[@class='ts-cookies__close']"))).perform(); }
		 * catch (Exception e) { System.out.println("popUp not found"); }
		 */
		
		sendKeys(textbox_username, username,WaitStrategy.CLICKABLE,"UserName");
		//sendKeys(textbox_username, username,WaitStrategy.CLICKABLE);
		//ExtentReport.test.pass("Username enter success"); // this is fix to handle parallel run
		//ExtentReportManager.getExtentTest().pass("Username enter success");  -> this is removed for code optimization and limit the no of extent methods user needs
		//Way to overcome by creating extentlogger and creating and calling methods from their by limit the scope to protected of ExtentReportManager methods
		//ExtentLogger.extentPass("Username enter success");
		return this;
	}

	public LoginPage enterPassword(String password) {
		
		sendKeys(textbox_password, DecodeUtils.getDecodedString(password),WaitStrategy.CLICKABLE, "Password");
		//sendKeys(textbox_password, password,WaitStrategy.CLICKABLE);
		//ExtentReport.test.pass("password enter success");
		//ExtentReportManager.getExtentTest().pass("password enter success");
		//ExtentLogger.extentPass("password enter success");
		return this;
	}

	public HomePage clickLogin() {
		click(button_login,WaitStrategy.CLICKABLE,"loginButton");
		//click(button_login,WaitStrategy.CLICKABLE);
		//ExtentReport.test.pass("Click button enter success");
		//ExtentReportManager.getExtentTest().pass("Click button enter success");
		//ExtentLogger.extentPass("Click button enter success");
		return new HomePage();
	}
	
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	

	public String getLoginPageUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}

}
