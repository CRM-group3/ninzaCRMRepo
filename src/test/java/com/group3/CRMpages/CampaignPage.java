package com.group3.CRMpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.group3.CRMbasics.BasePage;

public class CampaignPage extends BasePage{
	static WebDriver driver;

	public CampaignPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
//	public class CampaignPage {
//	    WebDriver driver;
//
//	    @FindBy(id = "campaignName")
//	    WebElement campaignName;
//
//	    public CampaignPage(WebDriver driver) {
//	        this.driver = driver;
//	        PageFactory.initElements(driver, this);
//	    }
//	}
//	
	@FindBy(xpath = "//button[@id='proceed-button']")
	public WebElement continueToSite;
	
	@FindBy(linkText = "Create Account")
	public WebElement createAccount;
	
	@FindBy(linkText = "Forgot password?")
	public WebElement forgotPassword;
	
	@FindBy(xpath = "//a[text()='Campaigns']")
	public WebElement campaigns;
	
	@FindBy(xpath = "//span[normalize-space()='Create Campaign']")
	public WebElement createCampaign;
	
	@FindBy(xpath = "//input[@name='campaignId']")
	public WebElement campaignId;
	
	@FindBy(xpath = "//input[@name='campaignName']")
	public WebElement campaignName;
	
	@FindBy(xpath = "//input[@name='campaignStatus']")
	public WebElement campaignStatus;
	
	@FindBy(xpath = "//input[@name='targetSize']")
	public WebElement targetSize;
	
	@FindBy(xpath = "//input[@name='expectedCloseDate']")
	public WebElement expectedClosedDate;
	
	@FindBy(xpath = "//input[@name='targetAudience']")
	public WebElement targetAudience;
	
	@FindBy(xpath = "//textarea[@name='description']")
	public WebElement description;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	public WebElement create_Campaign;
	
	@FindBy(xpath = "//a[@class='edit']")
	public WebElement editIcon;
	
	@FindBy(xpath = "//a[@class='delete']")
	public WebElement deleteIcon;
	
	@FindBy(xpath = "//button[text()='Update Campaign']")
	public WebElement updateCampaign;
	
	
	public void clickOnCreateCampaign() throws InterruptedException {
		
		try {
		    WebElement collapseNav = driver.findElement(By.id("navbarNav"));
		    if (collapseNav.isDisplayed()) {
		        WebElement closeButton = driver.findElement(By.cssSelector(".navbar-toggler")); // adjust selector as needed
		        closeButton.click();
		        Thread.sleep(500); // wait for collapse animation
		    }
		} catch (NoSuchElementException e) {
		    // navbar not found, ignore
		}
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info']//span[text()='Create Campaign']")));
	//	element.click();
		
		WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Create Campaign']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scr'llIntoView(true);", element);
		element.click();

	//	"//*[@id='content']/div[2]/div[1]/div/div[1]/div/div[2]/button/span"
	}
	
}
