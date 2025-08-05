package com.group3.CRMpages;



import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;


import com.group3.CRMbasics.BasePage;
import org.testng.Assert;

public class OpportunityPage extends BasePage{

	public OpportunityPage(WebDriver driver) 
	{
		super(driver);
		

	}

//	public @FindBy(xpath="//a[@class='nav-link' and text()='Opportunities']")
//	WebElement opportunity;
//	
//	public @FindBy(xpath="//span[contains(text(),'Create Opportunity')]")
//	WebElement createoppo;
//	
//	public @FindBy(xpath="//input[@value='Auto Generated']")
//	WebElement oppoid;
//	
//	public @FindBy(xpath="//input[@name='opportunityName']")
//	WebElement opponame;
//	
//	public @FindBy(xpath="//button[@type='submit']")
//	WebElement submit;
//		
//	public @FindBy(xpath="//input[@name='amount']")
//	WebElement amount;
//	
//	public @FindBy(xpath="//input[@name='businessType']")
//	WebElement businesstype;
//	
//	public @FindBy(xpath="//input[@name='nextStep']")
//	WebElement nextstep;
//	
//	public @FindBy(xpath="//input[@name='salesStage']")
//	WebElement salesstage;
//	
//	public void clickOpportunity() throws InterruptedException
//	{
//		Thread.sleep(2000);
//		opportunity.click();
//		
//	}
//	
//	public void createopportunity()
//	{
//		createoppo.click();
//	}
//	
//	public void checkoppoid()
//	{
//		
//		 String actualValue = oppoid.getAttribute("value");  
//	        System.out.println("Opportunity ID Value: " + actualValue);
//	        Assert.assertEquals(actualValue, "Auto Generated", 
//	                "Opportunity ID is not auto-generated as expected.");
//	}
//
//
//		
//	}
//	
	public @FindBy(xpath="//a[@class='nav-link' and text()='Opportunities']")
	
	WebElement opportunity;
	
	public @FindBy(xpath="//span[contains(text(),'Create Opportunity')]")
	WebElement createoppo;
	
	public @FindBy(xpath="//input[@value='Auto Generated']")
	WebElement oppoid;
	
	public @FindBy(xpath="//input[@name='opportunityName']")
	WebElement opponame;
	
	public @FindBy(xpath="//button[@type='submit']")
	WebElement submit;
		
	public @FindBy(xpath="//input[@name='amount']")
	WebElement amount;
	
	public @FindBy(xpath="//input[@name='businessType']")
	WebElement businesstype;
	
	public@FindBy(xpath="//input[@name='nextStep']")
	WebElement nextstep;
	
	public @FindBy(xpath="//input[@name='salesStage']")
	WebElement salesstage;
	
	public @FindBy(xpath="//input[@name='probability']")
	WebElement probability;
	
	public @FindBy(xpath="//input[@type='text']")
	WebElement lead;
	
	public @FindBy(xpath="//input[@type='date']")
	WebElement closedate;
	
	public void clickOpportunity() throws InterruptedException
	{
		Thread.sleep(2000);
		opportunity.click();
		
	}
	
	public void createopportunity()
	{
		createoppo.click();
	}
	
	public void checkoppoid()
	{
		
		 String actualValue = oppoid.getAttribute("value");  
	        System.out.println("Opportunity ID Value: " + actualValue);
	        Assert.assertEquals(actualValue, "Auto Generated", 
	                "Opportunity ID is not auto-generated as expected.");
	}


	public void opponamecheck()
	{
		opponame.clear();
		opponame.sendKeys("");
		submit.click();
		String actualvalue=opponame.getText(); 
		System.out.println("Error message : Please fill out field" + actualvalue);
		Assert.assertEquals(actualvalue, "Name is empty", 
                "Error message");
	}
	
	public void amountcheck()
	{
		amount.clear();
		amount.sendKeys("");
		submit.click();
		String actualvalue=amount.getText();
		System.out.println("Error message : Please fill out field" + actualvalue);
		Assert.assertEquals(actualvalue, "Amount is empty", 
                "Error message");
		amount.sendKeys("abcd");
		String actualvalue2=amount.getText();
		System.out.println("Error message : Amount should be numeric" + actualvalue2);
		Assert.assertEquals(actualvalue, "Amount should be numeric", 
                "Error message");
	}
	
	public void businesstypecheck()
	{
		businesstype.clear();
		businesstype.sendKeys("");
		submit.click();
		String actualvalue=businesstype.getText();
		System.out.println("Error message : Please fill out field" + actualvalue);
		Assert.assertEquals(actualvalue, "businesstype is empty", 
                "Error message");
	}
	
	public void nextstep()
	{
		nextstep.clear();
		nextstep.sendKeys("");
		submit.click();
		String actualvalue=nextstep.getText();
		System.out.println("Error message : Please fill out field" + actualvalue);
		Assert.assertEquals(actualvalue, "nextstep is empty", 
                "Error message");
		
	}
	
	public void checksalesstage()
	{
		salesstage.clear();
		salesstage.sendKeys("");
		submit.click();
		String actualvalue=salesstage.getText();
		System.out.println("Error message : Please fill out field" + actualvalue);
		Assert.assertEquals(actualvalue, "salestage is empty", 
                "Error message");
	}






	
	public void checkLead()
	{
		lead.clear();
		lead.click();
		String actualvalue=nextstep.getText();
		System.out.println("Error message : Please fill out field" + actualvalue);
		Assert.assertEquals(actualvalue, "Lead is empty", 
                "Error message");
	}
	
	public void optionalProbability()
	{
	    probability.click();
		
		String defaultvalue=probability.getAttribute("value");
		
		if("0".equals(defaultvalue))
		{
			System.out.println("default value is zero");
		}
		else
		{
			System.out.println("Default value is not zero" + defaultvalue);
		}
		
		String required=probability.getAttribute("required");
		if(required==null || required.equals("false"))
		{
			System.out.println("Probability field is optional");
		}
		else
		{
			System.out.println("Probability field is not optional");
		}
	}
	
	public void probablityValidation()
	{
		probability.click();
		
		String actualvalue=probability.getAttribute("value");
		int num=Integer.parseInt(actualvalue);
		
		if(num >= 0 && num <=100)
		{
			System.out.println("Number is between 0 and 100");
		}
		else
		{
			System.out.println("Number is not valid");
		}
		
	}
	
	public void checkClosedate()
	{
		closedate.click();
		SimpleDateFormat sdf=new SimpleDateFormat("MM-DD-YYYY");
		closedate.clear();
		closedate.click();
		closedate.sendKeys("sdf");
	}
	
	public void saveWithallfields()
	{
		opponame.clear();
		opponame.sendKeys("abc");
		
		amount.clear();
		amount.sendKeys("1234");
		
		businesstype.clear();
		businesstype.sendKeys("Renewal");
		
		nextstep.clear();
		nextstep.sendKeys("Send proposal");
		
		salesstage.clear();
		salesstage.sendKeys("Qualification");
		
		
		
		submit.click();
		
		
	}
	
	public void saveWithmandatory()
	{
		opponame.clear();
		opponame.sendKeys("abc");
		
		amount.clear();
		amount.sendKeys("1234");
		
		businesstype.clear();
		businesstype.sendKeys("Renewal");
		
		nextstep.clear();
		nextstep.sendKeys("Send proposal");
		
		salesstage.clear();
		salesstage.sendKeys("Qualification");
		
		lead.clear();
		lead.sendKeys("Abcd");
		
		submit.click();
	}
}


