package com.framework.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.annotations.FrameworkAnnotation;
import com.framework.reports.ExtentLogger;
import com.framework.reports.ExtentReport;

public class ProjectListener implements ITestListener,ISuiteListener {

	/*
	 * After moving all the Extent logger from BaseTest to ProjectListener class. We have to make testng.xml to listen to the listener class to get results
	 */
	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initiateReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createtest(result.getMethod().getMethodName());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	//ExtentLogger.extentPass(result.getMethod().getMethodName() + " is passed");
	
			ExtentLogger.extentPass(result.getMethod().getMethodName() + " is passed",true);
		}

	@Override
	public void onTestFailure(ITestResult result) {
		//ExtentLogger.extentFail(result.getMethod().getMethodName() + " is Failed");
	
			ExtentLogger.extentFail(result.getMethod().getMethodName() + " is Failed",true);
			ExtentLogger.extentFail(result.getThrowable().toString());
			ExtentLogger.extentFail(Arrays.toString(result.getThrowable().getStackTrace()));	
			}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		//try {
			ExtentLogger.extentSkip(result.getMethod().getMethodName() + " is skipped",true);
			ExtentLogger.extentFail(result.getThrowable().toString());
			ExtentLogger.extentFail(Arrays.toString(result.getThrowable().getStackTrace()));
			/*//exception handled by custom exception class for read property file
			 * } catch (Exception e) { e.printStackTrace(); }
			 */
	}
	
	

}
