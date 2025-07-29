package com.group3.CRMpages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateUserPage {
    WebDriver driver;
    Actions actions;

    public CreateUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submitBtn")
    private WebElement submitBtn;
    @FindBy(xpath = "//div[@class='nav-link' and contains(., 'Admin Console')]")
    private WebElement adminMenu;

    @FindBy(xpath = "//div[@class='dropdown-item' and text()='Create User']")
    private WebElement createUserLink;
    
    public void navigateToCreateUser() {
        actions.moveToElement(adminMenu).perform();       // Hover on Admin menu
        actions.moveToElement(createUserLink).click().perform(); // Click Create User
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSubmit() {
        submitBtn.click();
    }

    public void createUser(String firstName, String lastName, String email, String password) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }
}
