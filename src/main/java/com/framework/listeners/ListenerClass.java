package com.framework.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Before suite in listener");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("after suite in listener");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Before method in listener");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("After method in listener: pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("After method in listener: Failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("After method in listener: skipped");
	}

}
