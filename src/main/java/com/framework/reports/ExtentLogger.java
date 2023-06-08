package com.framework.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.framework.enums.ConfigProperties;
import com.framework.utils.ReadPropertyFile;
import com.framework.utils.ScreenshotUtils;

public class ExtentLogger {
	
	private ExtentLogger()
	{
		
	}
	
	public static void extentPass(String value)
	{
		ExtentReportManager.getExtentTest().pass(value);
	}

	public static void extentFail(String value)
	{
		ExtentReportManager.getExtentTest().fail(value);
	}
	
	public static void extentSkip(String value)
	{
		ExtentReportManager.getExtentTest().skip(value);
	}
	
	public static void extentPass(String message, boolean isScreenshotRequired)
	{
		if(ReadPropertyFile.getValue(ConfigProperties.PASSEDSTEPSCREENSHOT.toString()).equalsIgnoreCase("yes") && isScreenshotRequired)
		{ 
		ExtentReportManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else
		{
			extentPass(message);
		}
	}
	
	public static void extentFail(String message, boolean isScreenshotRequired)
	{
		if(ReadPropertyFile.getValue(ConfigProperties.FAILEDSTEPSCREENSHOT.toString()).equalsIgnoreCase("yes") && isScreenshotRequired)
		{ 
		ExtentReportManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else
		{
			extentFail(message);
		}
	}
	
	//no need to throw exception, as Readproperty file is having a custom exception class which is handling and extending runtime exception
	//public static void extentSkip(String message, boolean isScreenshotRequired) throws Exception
	public static void extentSkip(String message, boolean isScreenshotRequired)
	{
		if(ReadPropertyFile.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOT.toString()).equalsIgnoreCase("yes") && isScreenshotRequired)
		{ 
		ExtentReportManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else
		{
			extentSkip(message);
		}
	}
	
	
	
	
}
