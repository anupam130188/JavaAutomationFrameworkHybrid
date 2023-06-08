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

import com.framework.annotations.FrameworkAnnotation;
import com.framework.driver.DriverManager;
import com.framework.enums.CategoryType;
import com.framework.listeners.ProjectRetryAnalyzer;
import com.framework.reports.ExtentReport;
import com.framework.reports.ExtentReportManager;
import com.framework.utils.DataProviderUtils;
import com.google.common.util.concurrent.Uninterruptibles;
import com.hrm.pages.HomePage;
import com.hrm.pages.LoginPage;

public final class LoginTestsWithDataProvider extends BaseTest{
	
	private LoginTestsWithDataProvider()
	{
		
	}

//@Test(dataProvider ="getDataFromExcel",dataProviderClass = DataProviderUtils.class,retryAnalyzer = ProjectRetryAnalyzer.class)
	@FrameworkAnnotation(author={"anupam","chandan"},category = {CategoryType.REGRESSION,CategoryType.SMOKE})//framework annotation will be called by ExtentReport methods which will add
	//data by hittin OnTestStart in Project LIstener class
	@Test
	public void loginLogOutTest(Map<String,String> data)
{
	//	ExtentReportManager.getExtentTest().assignAuthor("Anupam").assignAuthor("Chandan").assignCategory("Smoke").assignCategory("Regression");
		//As we have created our own custom annotation, we dont need to call ExtentReport manager in each Test Method.
		HomePage homePage = new LoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
		homePage.clickProfile();
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);//this class part of commons lang 3 library will stop the script for 3 seconds similar to Thread but without exception or try catch
		
		String loginPageTitle = homePage.clickLogout().getLoginPageTitle();
		
		String loginUrl=new LoginPage().getLoginPageUrl();
		
	Assertions.assertThat(loginPageTitle)
	.contains("OrangeHRM");
	Assertions.assertThat(loginUrl)
	.contains("orangehrm");
}


//@Test(dataProvider ="getDataFromExcel",dataProviderClass = DataProviderUtils.class,retryAnalyzer = ProjectRetryAnalyzer.class)
//@Test
public void loginLogOutTest1(Map<String,String> data)
{
	ExtentReportManager.getExtentTest().assignAuthor("Anupam").assignAuthor("Chandan").assignCategory("Smoke").assignCategory("Regression");
		HomePage homePage = new LoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
		homePage.clickProfile();
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);//this class part of commons lang 3 library will stop the script for 3 seconds similar to Thread but without exception or try catch	
		String loginPageTitle = homePage.clickLogout().getLoginPageTitle();
		
		String loginUrl=new LoginPage().getLoginPageUrl();
		
	Assertions.assertThat(loginPageTitle)
	.contains("OrangeHRM");
	Assertions.assertThat(loginUrl)
	.contains("orangehrm");
}

//@Test
public void loginLogOutTest2(Map <String,String> data)
{
		System.out.println("data" + data);
		HomePage homePage = new LoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
		homePage.clickProfile();
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);//this class part of commons lang 3 library will stop the script for 3 seconds similar to Thread but without exception or try catch	
		String loginPageTitle = homePage.clickLogoutwithText(data.get("action")).getLoginPageTitle(); //changed the xpath method to use string replace logic to reduce coding verbosity
		// in this case, the instered string will create dynamic xpath during execution.
		
		String loginUrl=new LoginPage().getLoginPageUrl();
		
		/*
		 * Assertions.assertThat(loginPageTitle) .contains("OrangeHRM");
		 * Assertions.assertThat(loginUrl) .contains("orangehrm");
		 */
		
		Assertions.assertThat(loginPageTitle).isNotEmpty().isNotNull().isNotBlank();
}

}

