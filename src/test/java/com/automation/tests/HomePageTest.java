package com.automation.tests;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftlyExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.framework.driver.Driver;
import com.framework.driver.DriverManager;
import com.framework.reports.ExtentLogger;
import com.framework.reports.ExtentReport;
import com.framework.reports.ExtentReportManager;

public final class HomePageTest extends BaseTest {

	private HomePageTest() {

	}

	/*
	 * @Test public void test3() { String expectedTitle="Google Search";
	 * DriverManager.getDriver().findElement(By.name("q")).sendKeys("Human",Keys.
	 * ENTER); String title = DriverManager.getDriver().getTitle();
	 * 
	 * 
	 * Assertion is done using assertion core library instead of Testng Assertions.
	 * Hard Assertion
	 * 
	 * assertThat(title) //Make the assertions static by making the package static
	 * for code optimization. .isNotEmpty()
	 * .as("Expecting the String not to be blank").isNotBlank() //custom description
	 * in the assertion needs be added first with as keyword //.isNotBlank()
	 * .doesNotContain("\\d.*") .contains(expectedTitle);
	 * //.overridingErrorMessage(()-> "please pass expected data correctly"); List
	 * <WebElement> elements =
	 * DriverManager.getDriver().findElements(By.xpath("//a//h3"));
	 * System.out.println("List of Webelements is : "+ elements);
	 * 
	 * for (WebElement e: elements) { //Assertions.assertThat(e) assertThat(e)
	 * .isNotNull(); }
	 * 
	 * }
	 */

	@Test
	public void test4() {
		ExtentReport.createtest("HomePagetest");
		String s = "Anupam";
		SoftAssertions sft = new SoftAssertions();
		sft.assertThat(s).isNotBlank().isNotEmpty().as(() -> "Character missmatch").contains("p").hasSizeBetween(1, 6);
		//ExtentReportManager.getExtentTest().pass("Character Match");-> this is removed for code optimization and limit the no of extent methods 
		//user need and Way to overcome by creating extentlogger and creating and calling methods from their by limit the scope to protected of ExtentReportManager methods
		ExtentLogger.extentPass("Character Match");
		
		sft.assertAll();
	}
}
