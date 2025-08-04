package com.group3.CRMlistners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	
	
	private static final ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<>();
    private static final ExtentReports extent = ExtentManager.getInstance();

    public static synchronized ExtentTest startTest(String testName) {
        if (extentTestThread.get() == null) {
            ExtentTest test = extent.createTest(testName);
            extentTestThread.set(test);
            ExtentManager.setTest(test);
        }
        return extentTestThread.get();
    }

    public static synchronized ExtentTest getTest() {
        return extentTestThread.get();
    }

    public static synchronized void endTest() {
        extentTestThread.remove();     
        extent.flush();
	
    }
}