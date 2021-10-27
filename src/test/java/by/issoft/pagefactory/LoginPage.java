package by.issoft.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    @FindBy(id = "passp-field-login")
    private WebElement usernameElement;

    @FindBy(id = "passp-field-passwd")
    private WebElement passwordElement;

    @FindBy(id = "passp:sign-in")
    private WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(), 'Log in')]//parent::a")
    private WebElement generalLoginButton;

    @FindBy(xpath = "//*[@class='mail-NestedList-Item-Name' and contains(text(), 'Inbox')]")
    private WebElement inboxLabel;

    @FindBy(xpath = "//*[@target='_parent']//*[@class='user-account__name' and contains(text(), 'accountforautotest')]")
    private WebElement usernameLabel;

    @FindBy(xpath = "//*[@class='mail-Layout-ContentWrapper']")
    private WebElement emailContainer;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void clickGeneralLoginButton(){
        generalLoginButton.click();
    }

    public boolean isInboxPresent(){
        return inboxLabel.isDisplayed();
    }

    public boolean isUsernamePresent(){
        return usernameLabel.isDisplayed();
    }

    public boolean isEmailContainerPresent(){
        return emailContainer.isDisplayed();
    }
}

