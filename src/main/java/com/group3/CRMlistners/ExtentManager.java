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

public class ExtentManager{

    private static ExtentReports extent;

    // Thread-safe ExtentTest storage
    private static final ThreadLocal<ExtentTest> testlog = new ThreadLocal<>();

    static Date currentDate = new Date();
    static String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(currentDate);

    private static final String reportFileName = "NinzaCRM_Report_" + timestamp + ".html";
    private static final String fileSeparator = System.getProperty("file.separator");
    private static final String reportDir = System.getProperty("user.dir") + fileSeparator + "ExtentReport";
    private static final String reportPath = reportDir + fileSeparator + reportFileName;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    private static void createInstance() {
        createReportDirectory(reportDir);

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("NinzaCRM Test Execution");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", System.getProperty("user.name"));
    }

    private static void createReportDirectory(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    // ---------- Logging Methods ----------

    public static void setTest(ExtentTest test) {
        testlog.set(test);
    }

    public static ExtentTest getTest() {
        return testlog.get();
    }

    public static void logTestInfo(String text) {
        System.out.println("ObjectLogger-> " + testlog.get());
        getTest().info(text);
    }

    public static void logTestwithPassed(String text) {
        System.out.println("ObjectLogger-> " + testlog.get());
        getTest().pass(MarkupHelper.createLabel(text, ExtentColor.GREEN));
    }

    public static void logTestwithFailed(String text) {
        System.out.println("ObjectLogger-> " + testlog.get());
        getTest().fail(MarkupHelper.createLabel(text, ExtentColor.RED));
    }

    public static void logTestfailwithException(Throwable e) {
        System.out.println("ObjectLogger-> " + testlog.get());
        getTest().fail(e);
    }

    public static void logTestfailwithScreenshot(String filepath) {
        System.out.println("ObjectLogger-> " + testlog.get());
        try {
            getTest().fail(MediaEntityBuilder.createScreenCaptureFromPath(filepath).build());
        } catch (Exception ex) {
            getTest().fail("Screenshot path invalid or not found.");
        }
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}

