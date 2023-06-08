package com.framework.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DummyExtentReportTest {

	//@Test
	public void test() throws IOException {
		/*	ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
		extentReports.attachReporter(spark);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ExecutionReport");
		spark.config().setReportName("Automation Test Execution");
		
		ExtentTest test1 = extentReports.createTest("First Test");
		test1.pass("Checking logs First Test");
		
		ExtentTest test2 = extentReports.createTest("Second Test");
		test1.fail("Checking logs Second Test");
		
		extentReports.flush();
		
		Desktop.getDesktop().browse(new File("index.html").toURI()); //open the report in desktop using default browser
		*/
		
	}
	
	
}
