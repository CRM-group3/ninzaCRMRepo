package com.group3.CRMbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
WebDriver driver;
	
	public WebDriver getDriver() {
		if(driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	
	public void close() {
		driver.close();
		driver = null;
	}

}
