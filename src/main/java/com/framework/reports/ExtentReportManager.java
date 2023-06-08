package com.framework.reports;


import com.aventstack.extentreports.ExtentTest;

public class ExtentReportManager {

	
	private ExtentReportManager(){
		
	}
	
	public static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();
	
	public static ExtentTest getExtentTest() // changed the scope from protected to public as this method is used by Test class to 
	//add author and other details for a test. Check the loging test class with data provider.
	{
		return extTest.get();
	}
	
	protected static void setExtentTest(ExtentTest testref)
	{
		extTest.set(testref);
	}
	
	protected static void unload ()
	{
		extTest.remove();
	}
}
