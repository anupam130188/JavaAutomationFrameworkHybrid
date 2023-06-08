package com.framework.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.framework.constants.FrameworkConstants;
import com.framework.constants.WaitStrategy;
import com.framework.enums.ConfigProperties;
import com.framework.exceptions.FrameworkException;
import com.framework.factories.DriverFactory;
import com.framework.utils.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {

	private Driver() {

	}

	// private static WebDriver drivr;

	public static void initDriver(String browser) {
		//WebDriver drivr = null;
		//String runmode="Remote";
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (MalformedURLException e) {
				throw new FrameworkException("Browser initialization failed. Please check capabilities"); 
			}
			
		}
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(ReadPropertyFile.getValue(ConfigProperties.URL.toString()));
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
