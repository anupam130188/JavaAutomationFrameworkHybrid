package com.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.framework.enums.ConfigProperties;
import com.framework.utils.ReadPropertyFile;

public class ProjectRetryAnalyzer implements IRetryAnalyzer{

	private int counter = 0;
	private int maxRetryCount=1;
	@Override
	public boolean retry(ITestResult result) {
		/*
		 * if(counter <maxRetryCount ) { counter++; return true; } return false; //more optimized code below
		 */
		boolean value=false;
		
		//try {
			if(ReadPropertyFile.getValue(ConfigProperties.RETRYFAILEDTESTS.toString()).equalsIgnoreCase("yes"))
			{
			value = counter<maxRetryCount;
			counter++;
			return value;
}
/*
 * } catch (Exception e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 */
		return value;
}
}
