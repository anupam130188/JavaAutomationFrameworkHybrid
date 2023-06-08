package com.framework.reports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DummyTest {

	public static void main(String[] args) {
		
		//String RESOURCEPATH1 =System.getProperty("user.dir")+"/src/test/resources/";
		String fireFoxpath= "C:/Users/anupam.chandan/Downloads/geckodriver-v0.33.0-win-aarch64/geckodriver.exe";
		System.out.println(fireFoxpath);
		
		System.setProperty("webdriver.gecko.driver",fireFoxpath); 
	//	FirefoxOptions options = new FirefoxOptions();
		//options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
				driver.manage().window().maximize();
				//driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get("https://www.google.com/");
				driver.findElement(By.name("q")).sendKeys("Browserstack Guide"); //name locator for text box
				WebElement searchbutton = driver.findElement(By.name("btnK"));//name locator for google search
				searchbutton.click();
				driver.quit();
				}
	

	}

