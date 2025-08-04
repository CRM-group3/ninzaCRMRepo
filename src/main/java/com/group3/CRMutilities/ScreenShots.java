package com.group3.CRMutilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenShots {
	
	public static String takescreenshot(WebDriver driver) {
		//Take screen shot object
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		
		//Store this object in a file object
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		Date current = new Date();
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(current);
		
		//path for storing a file
		String userDir = System.getProperty("user.dir");
		String fileseparator = System.getProperty("file.separator");
		String filepath = userDir + fileseparator + "Screenshots" + fileseparator + "NinzaCRM_" + timestamp + ".jpeg";
		
		//Convert file path to file object
		File destFile = new File(filepath);
		
		//copy source file into destination file 
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filepath;
	
	}

}