package com.framework.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.constants.FrameworkConstants;
import com.framework.enums.CategoryType;
public final class ExtentReport {

	private ExtentReport () 
	{
		
	}
	private static ExtentReports extentReports;
//	public static ExtentTest test; // this will fail in parallel run, so we are using local varibale call (ExtentTest	test =	extentReports.createTest(testcasename);) 
	//in each run to handle as mentioned in method createtest
	
	
	public static void initiateReport()
	{
		if (Objects.isNull(extentReports))
		{
		//Report Setup Code
			extentReports = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportfilepath());
		extentReports.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ExecutionReport");
		spark.config().setReportName("Automation Test Execution");
		}
		
	}
	
	public static void flushReport() throws Exception
	{
		if (Objects.nonNull(extentReports))
		{
		 extentReports.flush() ;
		}
		//System.out.println("File path "+FrameworkConstants.createExtentReportPath());
		ExtentReportManager.unload();
		
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportfilepath()).toURI()); //open the report in desktop using default browser
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}	
		}

	public static void createtest(String testcasename)
	{
		//test =	extentReports.createTest(testcasename); // in case of multi threading, this will fail as only one instance will be used by two threads
		//causing issues as second test will override report of 1st Test. to handle this , we use Report manager here as well like driver manager
		// usage is given as below
		ExtentTest	test =	extentReports.createTest(testcasename);
		ExtentReportManager.setExtentTest(test);
	}
	
	public static void addAuthors(String [] authors)
	{
		for(String temp: authors)
		{
			ExtentReportManager.getExtentTest().assignAuthor(temp);
		}
	}
	

	public static void addCategories(CategoryType [] categories)
	{
		for(CategoryType temp: categories)
		{
			ExtentReportManager.getExtentTest().assignCategory(temp.toString());
		}
	}
	
}
