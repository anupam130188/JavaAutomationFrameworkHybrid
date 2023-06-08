package com.framework.listeners;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestRunner {
	@BeforeSuite
	public void setupSuite()	{		System.out.println("before suite in runner");}
	@AfterSuite
	public void tearDownSuite()	{		System.out.println("after suite in runner");	}
	@BeforeMethod
	public void setUp()	{		System.out.println("before method in runner");	}	
	@AfterMethod
	public void tearDown()	{		System.out.println("after method in runner");	}
	
	//@Test(description="test1", enabled=true,priority=1)
//	@Test //(enabled=false)
	public void test1()	{		System.out.println("test1");
	//Assert.assertTrue(false);
	}
	
	@Test
	public void test2()	{		System.out.println("test2");Assert.assertTrue(false);	}
	
	//@Test(retryAnalyzer = RetryAnalyzer.class)
	@Test
	public void test3()	{		System.out.println("test3");	}
		
}
