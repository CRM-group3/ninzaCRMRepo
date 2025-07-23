package com.group3.CRMbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	WebDriver driver;
	
	public WebDriver getDriver()
	{
		if(driver==null)
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("");
			driver.manage().window().maximize();
		}
		return driver;
	}

	@AfterMethod
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
