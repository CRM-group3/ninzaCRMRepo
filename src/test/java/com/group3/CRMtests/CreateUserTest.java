package com.group3.CRMtests;


import com.group3.CRMbasics.BaseTest;
import com.group3.CRMpages.CreateUserPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateUserTest extends BaseTest {

	CreateUserTest userPage;
	WebDriver driver;//=userPage.getDriver();
	//driver=
	@Test
	public void login() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		// Initialize WebDriver
		//driver = new ChromeDriver();

		// Maximize browser window
		//driver.manage().window().maximize();

		// Set implicit wait
		driver=userPage.getDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Navigate to application URL
		driver.get("http://49.249.28.218:8098/");

		// Locate username field and enter username
		WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
		usernameField.sendKeys("rmgyantra");
		Thread.sleep(3000);

		// Locate password field and enter password
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='inputPassword']"));
		passwordField.sendKeys("rmgy@9999");

		// Locate login button and click
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
	}

	@Test
	public void testCreateUserValidData() throws InterruptedException {
		LoginTest ltn=new LoginTest();
		driver=ltn.login();
		CreateUserPage cuserpage= new CreateUserPage(driver);
		Actions actions= new Actions(driver);
		Thread.sleep(3000);
		WebElement adminMenu=	driver.findElement(By.xpath("//div[@class='nav-link' and contains(., 'Admin Console')]"));
		actions.moveToElement(adminMenu).perform();
		WebElement createUserLink=driver.findElement(By.xpath("//div[@class='dropdown-item' and text()='Create User']")); 
		actions.moveToElement(createUserLink).click().perform();	
		cuserpage.createUser("Chitra", "1239670901", "chitrate@stmail.com","ci7hhhhh");

		
		// Add assertion here based on success message or redirection
	}
	public void userIdAutoGenerate()
	{
		
	}
}
