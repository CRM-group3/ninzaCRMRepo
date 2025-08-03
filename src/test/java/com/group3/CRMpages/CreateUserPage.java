package com.group3.CRMpages;



import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bsh.ParseException;
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
    @FindBy(xpath = "//table[@class='table table-striped table-hover']//tbody//tr")
    private List<WebElement> tableRows;
    @FindBy(xpath = "//table[@class='table table-striped table-hover']//tbody/tr[1]/td[1]")
    private WebElement firstCell;
 // In CreateUserPage.java or relevant Page class
    @FindBy(name = "dob")
    private WebElement dateOfBirthInput;

    @FindBy(css = "div.error-message") // Adjust selector based on your actual DOM
    private WebElement passErrorMessage;
    @FindBy(css = "div.error-message") // Adjust selector based on your actual DOM
    private WebElement userErrorMessage;
    @FindBy(css = "div.error-message") // Adjust selector based on your actual DOM
    private WebElement dobErrorMessage;
    @FindBy(xpath="//div[@class='Toastify__toast-body'and contains(text(), 'already exists')]")
    private WebElement duplicateUserMessage;
    @FindBy(xpath="//div[@class='user-icon']")
    private WebElement sigouthover;
    @FindBy(xpath="//div[contains(@class, 'logout') and normalize-space(text())='Logout']")
    private WebElement logout;
  
    
    public WebElement getLogout() {
		return logout;
	}

	public void setLogout(WebElement logout) {
		this.logout = logout;
	}

	public WebElement getSigouthover() {
		return sigouthover;
	}

	public void setSigouthover(WebElement sigouthover) {
		this.sigouthover = sigouthover;
	}

	public WebElement getDuplicateUserMessage() {
		return duplicateUserMessage;
	}

	public void setDuplicateUserMessage(WebElement duplicateUserMessage) {
		this.duplicateUserMessage = duplicateUserMessage;
	}

	public String getpasswordErrorMessage() {
        return passErrorMessage.getText().trim();
    }
    
    
    public String getuserNameErrorMessage() {
        return userErrorMessage.getText().trim();
    }
    public String getDobErrorMessage() {
        return dobErrorMessage.getText().trim();
    }
    public WebElement getDateOfBirthInput() {
        return dateOfBirthInput;
    }

    public boolean isDobErrorVisible() {
        return dobErrorMessage.isDisplayed();
    }
    public WebElement getLastRow() {
        return tableRows.get(tableRows.size() - 1);
    }

    public String getFirstCellTextFromLastRow() {
        WebElement lastRow = getLastRow(); // from previous method
        if (lastRow != null) {
            return lastRow.findElement(By.xpath("./td[1]")).getText();
        }
        return "";
    }

    
    public List<WebElement> getTableRows() {
		return tableRows;
	}

	public void setTableRows(List<WebElement> tableRows) {
		this.tableRows = tableRows;
	}

	public WebElement getFirstCell() {
		return firstCell;
	}

	public void setFirstCell(WebElement firstCell) {
		this.firstCell = firstCell;
	}

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
    public  String getRandomAlphaString(int length) {
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder result = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			result.append(letters.charAt(random.nextInt(letters.length())));
		}
		return result.toString();
	}
	
	 public  String generateMobileNumber() {
	        Random random = new Random();

	        // First digit shouldn't be 0 or 1 (common restriction in real mobile numbers)
	        int firstDigit = 6 + random.nextInt(4);  // Generates 6, 7, 8, or 9
	        StringBuilder mobileNumber = new StringBuilder(String.valueOf(firstDigit));

	        // Generate remaining 9 digits
	        for (int i = 0; i < 9; i++) {
	            mobileNumber.append(random.nextInt(10));
	        }return mobileNumber.toString();
	    }
	 private  final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

	    public  boolean isValidEmail(String email) {
	        return Pattern.matches(EMAIL_REGEX, email);
	    }
    public void createUser(String firstName, String mobilenumber, String email, String username,String password) {
        enterFirstName(firstName);
        entermobileNumber(mobilenumber);
        enterEmail(email);
        enterUserName(username);
        enterPassword(password);
        clickSubmit();
    }
    public  boolean isValidDate(String dateStr) throws java.text.ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.setLenient(false); // disables lenient parsing (e.g., 32-01-2025 won't pass)
        sdf.parse(dateStr);
		return true; // valid format and valid date
    }
}
