package com.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzer implements IRetryAnalyzer {

	//this method will check eac TestMethod, if it failed, retry Analyzer will return boolean value true and same test will be reran again.
	//if it returns false, it will move to next test method check
	//Diff ways to implement it, add rerty analyzer annotation at method level like
	// @Test(retryAnalyzer = RetryAnalyzer.class)
		// Example -> public void test3()	{		System.out.println("test3");
	// OR 
	//It can be placed in Annotation transformer listener class which will call it internally while pulling test methods from excel or any other logic
	//and decides based on logic which test methods to be triggered.
	
	@Override
	public boolean retry(ITestResult result) {
		int counter=0;
		int limit =2 ;
		if (counter<limit )
		{
			counter++;
			return true;
		}
		return false;
		
	}
	
	

}
