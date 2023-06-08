package com.automation.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.framework.driver.DriverManager;
import com.framework.reports.ExtentReport;
import com.google.common.util.concurrent.Uninterruptibles;
import com.hrm.pages.HomePage;
import com.hrm.pages.LoginPage;

public final class LoginTests extends BaseTest{
	
	//LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	private LoginTests()
	{
		
	}

@Test
public void loginLogOutTest()
{
	
		//ExtentReport.createtest("Logintest"); -> this line is impacting code quality and tight coupling of project with logger. So, to dynamically get the Test Method name, we will use java
		//reflection API in BaseTest class which wil dynamically print the running method for the extent report
		//Check ExtentReport.createtest(testMethodName.getName()) -> implemented in BaseTest class -> Setup Method
		
		HomePage homePage = new LoginPage().enterUserName("Admin").enterPassword("admin123").clickLogin();
	//homePage.clickProfile().clickLogout();
		//new LoginPage().enterUserName("anupam.chandan@yahoo.com").enterPassword("Jammu@02");
		homePage.clickProfile();
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);//this class part of commons lang 3 library will stop the script for 3 seconds similar to Thread but without exception or try catch
		
		
//		try {
//			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
//		//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ts-cookies__close']"))); //old wait before java 8
//			wait.until(d->d.findElement(By.xpath("//div[@class='ts-cookies__close']")).isEnabled()); 
//			//this is new wait to implement WebDriver 8 using java 8 concepts. 
//			//In this d-> d(this is variable for driver we can use driver-> d as well)
//			new Actions(DriverManager.getDriver()).click(DriverManager.getDriver().findElement(By.xpath("//div[@class='ts-cookies__close']"))).perform();
//		} catch (Exception e) {
//			System.out.println("popUp not found");
//		}
		String loginPageTitle = homePage.clickLogout().getLoginPageTitle();
		
		String loginUrl=new LoginPage().getLoginPageUrl();
		
	Assertions.assertThat(loginPageTitle)
	.contains("OrangeHRM");
	Assertions.assertThat(loginUrl)
	.contains("orangehrm");
}


//@Test
public void loginLogOutTest1()
{
		HomePage homePage = new LoginPage().enterUserName("Admin").enterPassword("admin1234").clickLogin();
		homePage.clickProfile();
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);//this class part of commons lang 3 library will stop the script for 3 seconds similar to Thread but without exception or try catch	
		String loginPageTitle = homePage.clickLogoutwithText("Logout").getLoginPageTitle(); //changed the xpath method to use string replace logic to reduce coding verbosity
		// in this case, the instered string will create dynamic xpath during execution.
		
		String loginUrl=new LoginPage().getLoginPageUrl();
		
	Assertions.assertThat(loginPageTitle)
	.contains("OrangeHRM");
	Assertions.assertThat(loginUrl)
	.contains("orangehrm");
}
}

