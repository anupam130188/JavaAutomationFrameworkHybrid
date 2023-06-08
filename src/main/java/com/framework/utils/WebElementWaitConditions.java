package com.framework.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.constants.FrameworkConstants;
import com.framework.constants.WaitStrategy;
import com.framework.driver.DriverManager;

public class WebElementWaitConditions {

	
	
	public static WebElement  WebElementWait(WaitStrategy waitStrategy, By by)
	{
		WebElement element = null;
		if(waitStrategy==WaitStrategy.PRESENCE)
		{
			element= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.presenceOfElementLocated(by)); 
			//old wait before java 8
			//wait.until(d->d.findElement(By.xpath("//div[@class='ts-cookies__close']")).isEnabled()); //java 8 approach
			
		}
		else if (waitStrategy==WaitStrategy.VISIBLE)  {
			element=	new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.visibilityOfElementLocated(by)); 
		
		}
		else if (waitStrategy==WaitStrategy.CLICKABLE)  {
			element=	new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.elementToBeClickable(by)); 
		}

		else if (waitStrategy==WaitStrategy.NONE)  {
			element=	DriverManager.getDriver().findElement(by);
		}
	return element;
	}
}
