package com.blazedemo.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.blazedemo.utils.ExtentManager;

public class TestListener implements ITestListener {
	private static ExtentReports extent = ExtentManager.getReport();

	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {

		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());

		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.get().pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.get().fail(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();
	}

}
