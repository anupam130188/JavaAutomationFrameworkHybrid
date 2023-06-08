package com.automation.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.framework.driver.Driver;


/**
 * 
 * @author anupam.chandan
 *
 */
public class BaseTest {

	protected BaseTest()
	{
		
	}

	@BeforeMethod
	//protected void driverSetup(Method testMethodName) throws Exception -> TestMethod name is handled by listener class
	protected void driverSetup(Object [] data)
	{
		Map <String,String> map = (Map <String,String>) data[0];
		//System.out.println("map.get(browser) "+ map.get("browser"));
		//ExtentReport.createtest(testMethodName.getName()); //1. this will help to get the testMethod Name dynamically
		//2. -> Creating and calling ExtentReport.createtest here is tightly coupling Test methods with logger. so to handle this, listeners are implemented
		// listeners Itest and ISuite will handle the status of pass and fail and which will be logged in Extent report by custom listener class ProjectListener
		Driver.initDriver(map.get("browser"));
	}
	
	@AfterMethod
	protected void driverDisconnect()
	{
		Driver.quitDriver();
	}
	
	
	
	//Both @Before and After Suite methods moved to override methods in listener class ProjectListenr calling ISuite and ITest to get the same output
	/*
	 * @BeforeSuite protected void reportSetup() throws Exception {
	 * 
	 * ExtentReport.initiateReport();////this is also impacting coupling of test
	 * with extent, so this will be handled by ISuite listener in Project listener
	 * class }
	 * 
	 * @AfterSuite protected void reportTearDown() throws Exception {
	 * 
	 * ExtentReport.flushReport(); //this is also impacting coupling of test with
	 * extent,so this will be handled by ISuite listener in Project listener class }
	 */
	
}
