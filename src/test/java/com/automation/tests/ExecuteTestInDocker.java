package com.automation.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExecuteTestInDocker {
	
//	@Test(dataProvider = "getData")
	@Test
	public void localTest() throws MalformedURLException, InterruptedException
	{
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		
		 DesiredCapabilities cap = new DesiredCapabilities();
		 cap.setBrowserName("chrome");
		 		
	//	ClientConfig config = ClientConfig.defaultConfig().connectionTimeout(Duration.ofMinutes(20)).readTimeout(Duration.ofMinutes(20)); // I change this 3 minute(Default) to 20 minutes.

		//		WebDriver driver = RemoteWebDriver.builder().oneOf(cap).address("http://localhost:4444/wd/hub").config(config).build(); // now you can use this remoteWebDriver.
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("https://www.google.com/");		
		System.out.println("Title is "+ driver.getTitle());
		//Thread.sleep(10000);
		driver.close();
		driver.quit();
	}
	
	/*
	 * @DataProvider(parallel=false) public Object[][] getData() { return new
	 * Object[][] {{"chrome"}}; }
	 */
	
	
	/*
	 * @Test public void localTest1() throws MalformedURLException,
	 * InterruptedException { WebDriverManager.chromedriver().setup(); //WebDriver
	 * driver = new ChromeDriver();
	 * 
	 * DesiredCapabilities cap = new DesiredCapabilities();
	 * cap.setBrowserName("firefox");
	 * 
	 * // ClientConfig config =
	 * ClientConfig.defaultConfig().connectionTimeout(Duration.ofMinutes(20)).
	 * readTimeout(Duration.ofMinutes(20)); // I change this 3 minute(Default) to 20
	 * minutes.
	 * 
	 * // WebDriver driver =
	 * RemoteWebDriver.builder().oneOf(cap).address("http://localhost:4444/wd/hub").
	 * config(config).build(); // now you can use this remoteWebDriver.
	 * 
	 * WebDriver driver = new RemoteWebDriver(new
	 * URL("http://localhost:4445/wd/hub"), cap);
	 * driver.get("https://www.google.com/"); //Thread.sleep(10000);
	 * System.out.println("Title is "+ driver.getTitle()); //driver.close();
	 * driver.quit(); }
	 */	
}
