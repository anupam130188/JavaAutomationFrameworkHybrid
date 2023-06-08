package com.hrm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.framework.constants.WaitStrategy;
import com.framework.driver.DriverManager;
import com.framework.reports.ExtentLogger;
import com.framework.reports.ExtentReport;
import com.framework.reports.ExtentReportManager;

public class HomePage extends BasePage{

	
	
	  private final By profile_option =  By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon"); 
	  private final By logout_option = By.xpath("//a[contains(@href,'logout')]");
	 
	  
//	private final By profile_option = By.xpath("//span[@class='user-menu__name']");
//	private final By logout_option = By.xpath("(//a[@href='/user/logout'])[1]");
	
	public HomePage clickProfile() {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(profile_option,WaitStrategy.CLICKABLE,"Profile Button");
		//DriverManager.getDriver().findElement(profile_option).click();
		//ExtentReport.test.pass("Click profile enter success");
		//ExtentReportManager.getExtentTest().pass("Click profile enter success");-> this is removed for code optimization and limit the no of extent methods 
		//user need and Way to overcome by creating extentlogger and creating and calling methods from their by limit the scope to protected of ExtentReportManager methods
		//ExtentLogger.extentPass("Click profile enter success");
		return this;
	}
	
	public LoginPage clickLogout() {
		click(logout_option,WaitStrategy.CLICKABLE,"Logout Button");
	//	DriverManager.getDriver().findElement(logout_option).click();
		//ExtentReport.test.pass("Click Logout enter success");
		//ExtentReportManager.getExtentTest().pass("Click Logout enter success");
		//ExtentLogger.extentPass("Click Logout enter success");
		return new LoginPage();
	}
	
	public LoginPage clickLogoutwithText(String item) {
		clickItem(item);
		//click(logout_option,WaitStrategy.CLICKABLE,item);
	//	DriverManager.getDriver().findElement(logout_option).click();
		//ExtentReport.test.pass("Click Logout enter success");
		//ExtentReportManager.getExtentTest().pass("Click Logout enter success");
		//ExtentLogger.extentPass("Click Logout enter success");
		return new LoginPage();
	}
}
