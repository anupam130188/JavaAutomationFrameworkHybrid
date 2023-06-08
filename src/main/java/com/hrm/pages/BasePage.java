package com.hrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.constants.FrameworkConstants;
import com.framework.constants.WaitStrategy;
import com.framework.driver.DriverManager;
import com.framework.reports.ExtentLogger;
import com.framework.utils.DynamicXpathUtils;
import com.framework.utils.WebElementWaitConditions;

public class BasePage {

	//private String linkSubMenu = "//a[text()='%replace%']"; //more optimized way to replace value in string, check inside getDynamicXpath function
	private String linkSubMenu = "//a[text()='%s']";
	public void clickItem(String item) {
		String newxPath = DynamicXpathUtils.getDynamicXpath(linkSubMenu,item);
		System.out.println("newxPath "+newxPath );
		click(By.xpath(newxPath), WaitStrategy.CLICKABLE);
	}
	
	protected void click (By by, WaitStrategy waitStrategy) {
	
		WebElement element = WebElementWaitConditions.WebElementWait(WaitStrategy.CLICKABLE, by);
				element.click();	
		//DriverManager.getDriver().findElement(by).click();
	}
	
	protected void click(By by, WaitStrategy waitStrategy, String elementName) {
		
		WebElement element = WebElementWaitConditions.WebElementWait(WaitStrategy.CLICKABLE, by);
				element.click();	
		//		try {
					ExtentLogger.extentPass(elementName + " is clicked successfully", true);
					/*
					 * } catch (Exception e) { e.printStackTrace(); }
					 */
	}
	
	protected void sendKeys(By by,String value,WaitStrategy waitStrategy) {
		WebElementWaitConditions.WebElementWait(WaitStrategy.VISIBLE, by).sendKeys(value);
		//DriverManager.getDriver().findElement(by).sendKeys(value);
	}
	
	protected void sendKeys(By by,String value,WaitStrategy waitStrategy, String elementName) {
		WebElementWaitConditions.WebElementWait(WaitStrategy.VISIBLE, by).sendKeys(value);
	//	try {
			ExtentLogger.extentPass(value + " is entered successfully in "+ elementName, true);
			/*
			 * } catch (Exception e) { e.printStackTrace(); }
			 */
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	
//	private void waitForElementToBeVisibile(By by)
//	{
////			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()));
////			wait.until(ExpectedConditions.elementToBeClickable(by)); //old wait before java 8
////			//wait.until(d->d.findElement(By.xpath("//div[@class='ts-cookies__close']")).isEnabled()); //java 8 approach
//	}
	
//	private void waitForElementToBePresent(By by)
//	{
////			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()));
////			wait.until(ExpectedConditions.presenceOfElementLocated(by)); //old wait before java 8
////			//wait.until(d->d.findElement(By.xpath("//div[@class='ts-cookies__close']")).isEnabled()); //java 8 approach
//	}
//	
}
