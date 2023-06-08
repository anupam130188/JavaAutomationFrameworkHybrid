package com.framework.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.framework.driver.DriverManager;
import com.framework.enums.ConfigProperties;
import com.framework.utils.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory()
	{
		
	}
	
	public static WebDriver getDriver(String browser) throws MalformedURLException
	{
		WebDriver driver= null;
		if (browser.equalsIgnoreCase("chrome")) {

			// System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromePath());
			// -> instead of defining chrome version we will use WebDrivermanager
			
			if(ReadPropertyFile.getValue(ConfigProperties.RUNMODE.toString()).equalsIgnoreCase("remote"))
			{
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(browser);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			}
			else
			{
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
			//drivr = new ChromeDriver(options);
			//DriverManager.setDriver(drivr);
				driver = new ChromeDriver(options);
				
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			
			if(ReadPropertyFile.getValue(ConfigProperties.RUNMODE.toString()).equalsIgnoreCase("remote"))
			{
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(browser);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			}
			else {
			// System.setProperty("webdriver.gecko.driver",
			// FrameworkConstants.getFirefoxPath());
			WebDriverManager.firefoxdriver().setup();
		//	drivr = new FirefoxDriver();
		//	System.out.println("Firefox " + drivr);
			driver = new FirefoxDriver();
		}	
		}
	 return driver;
	}
	
}
