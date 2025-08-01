package com.group3.CRMlistners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.group3.CRMbasics.BasePage;
import com.group3.CRMlogs.Logs;
import com.group3.CRMutilities.ScreenShots;
//import com.salesforce.utility.Constants;
import com.group3.CRMbasics.*;
import com.group3.CRMlistners.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

public class TestListner extends BaseTest implements ITestListener {
	
	ScreenShots ss = new ScreenShots();
	private static ExtentReports report = ExtentManager.getInstance();


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
		//ExtentManager.logTestwithPassed("NinaCRMpass");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		Logs.error("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		ss.takescreenshot(driver);
		//String filename = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		//String path = constants.screenshotsFilepath + filename + ".png";
		//report.logTestfailwithScreenshot(path);
		//report.logTestfailwithException(result.getThrowable());
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