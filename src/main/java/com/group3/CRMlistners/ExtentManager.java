package com.group3.CRMlistners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	

	public static ExtentReports extent;

	public static ExtentTest testlog;
	  
 	static Date currentDate = new Date();
  	static String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
  	
    private static String reportFileName = "NinzaCRM" +timestamp+ ".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "ExtentReport";
    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
  
 
	public static ExtentTest startExtentCreateReport(String str) {
		 extent = ExtentManager.getInstance();
		// this will return methodname to the testlog
		testlog = extent.createTest(str);
		return testlog;
	}
    
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilepath);
       
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
 
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //Set environment details
		extent.setSystemInfo("OS", "Mac");
		extent.setSystemInfo("AUT", "Prod");
 
        return extent;
    }
     
    //Create the report path
    private static String getReportPath (String path) {
    	File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }
    
    public static void logTestInfo(String text) {

		System.out.println("ObjectLogger->" + testlog);// here we are trying to print methodname
		testlog.info(text);
		
    }


	public static void logTestwithPassed(String text) {
		System.out.println("ObjectLogger->" + testlog);// here we are trying to print methodname
		testlog.pass(MarkupHelper.createLabel(text, ExtentColor.GREEN));
	}
	
	public static void logTestfailwithException(Throwable e) {
		System.out.println("ObjectLogger->" + testlog);// here we are trying to print methodname
		testlog.fail(e);

	}

	public static void logTestwithFailed(String text) {
		System.out.println("ObjectLogger->" + testlog);// here we are trying to print methodname
		testlog.fail(MarkupHelper.createLabel(text, ExtentColor.RED));

	}

	public static void logTestfailwithScreenshot(String filepath) {
		System.out.println("ObjectLogger->" + testlog);// here we are trying to print methodname
		testlog.fail(MediaEntityBuilder.createScreenCaptureFromPath(filepath).build());

	}
	
}