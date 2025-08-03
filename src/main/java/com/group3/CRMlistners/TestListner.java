package com.group3.CRMlistners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.group3.CRMlogs.Logs;
import com.group3.CRMutilities.ScreenShots;
import com.group3.CRMbasics.*;
import com.aventstack.extentreports.Status;

public class TestListner extends BaseTest implements ITestListener {
	
	ScreenShots ss = new ScreenShots();


	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
		Logs.info("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		Logs.info(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		Logs.info(("*** Running test method " + result.getMethod().getMethodName() + "..."));	
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		Logs.info("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");		
	}

	public void onTestFailure(ITestResult result) {
	    String testName = result.getMethod().getMethodName();
	    System.out.println("*** Test " + testName + " failed...");
	    Logs.error("*** Test " + testName + " failed...");

	    Throwable throwable = result.getThrowable();
	    ExtentManager.logTestfailwithException(throwable);

	    try {
	        //WebDriver driver = null;
	        Object testClass = result.getInstance();
	        if (testClass instanceof BaseTest) {
	            driver = ((BaseTest) testClass).getDriver(); // Safely get driver
	        }

	        if (driver != null) {
	            String screenshotPath = ss.takescreenshot(driver);  
	            ExtentManager.logTestfailwithScreenshot(screenshotPath);
	        } else {
	            Logs.error("WebDriver instance is null, cannot take screenshot.");
	        }
	    } catch (Exception e) {
	        Logs.error("Failed to capture or attach screenshot: " + e.getMessage());
	    }
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		Logs.info("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
		Logs.error("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

}