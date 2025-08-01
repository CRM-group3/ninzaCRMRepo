package com.group3.CRMpages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class CreateUserPage {
    public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public Actions getActions() {
		return actions;
	}

	public void setActions(Actions actions) {
		this.actions = actions;
	}

	public WebElement getFirstNameInput() {
		return firstNameInput;
	}

	public void setFirstNameInput(WebElement firstNameInput) {
		this.firstNameInput = firstNameInput;
	}

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(WebElement mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public WebElement getEmailInput() {
		return emailInput;
	}

	public void setEmailInput(WebElement emailInput) {
		this.emailInput = emailInput;
	}

	public WebElement getUserName() {
		return userName;
	}

	public void setUserName(WebElement userName) {
		this.userName = userName;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public void setPasswordInput(WebElement passwordInput) {
		this.passwordInput = passwordInput;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void setSubmitBtn(WebElement submitBtn) {
		this.submitBtn = submitBtn;
	}

	public WebElement getAdminMenu() {
		return adminMenu;
	}

	public void setAdminMenu(WebElement adminMenu) {
		this.adminMenu = adminMenu;
	}

	public WebElement getCreateUserLink() {
		return createUserLink;
	}

	public void setCreateUserLink(WebElement createUserLink) {
		this.createUserLink = createUserLink;
	}

	public WebElement getAlertMsg() {
		return alertMsg;
	}

	public void setAlertMsg(WebElement alertMsg) {
		this.alertMsg = alertMsg;
	}

	WebDriver driver;
    Actions actions;

    public CreateUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    @FindBy(name = "empName")
    private WebElement firstNameInput;

    @FindBy(name = "mobileNo")
    private WebElement mobileNumber;

    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath="//button[text()='Create User']")
    private WebElement submitBtn;
    @FindBy(xpath = "//div[@class='nav-link' and contains(., 'Admin Console')]")
    private WebElement adminMenu;

    @FindBy(xpath = "//div[@class='dropdown-item' and text()='Create User']")
    private WebElement createUserLink;
    @FindBy(xpath ="//div[contains(text(), 'Successfully')]")
    private WebElement alertMsg;
   
    
    public void navigateToCreateUser() {
        actions.moveToElement(adminMenu).perform();       // Hover on Admin menu
        actions.moveToElement(createUserLink).click().perform(); // Click Create User
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void entermobileNumber(String mobile) {
        mobileNumber.sendKeys(mobile);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }
    public void enterUserName(String username) {
        userName.sendKeys(username);
    }
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }
	/* public String getAlertMessage(String alertMsg) { 
	return"";
	
}*/
    public void clickSubmit() {
        submitBtn.click();
    }

    public void createUser(String firstName, String mobilenumber, String email, String username,String password) {
        enterFirstName(firstName);
        entermobileNumber(mobilenumber);
        enterEmail(email);
        enterUserName(username);
        enterPassword(password);
        clickSubmit();
    }
}
