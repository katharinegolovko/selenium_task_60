package by.issoft.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    WebDriver driver;

    @FindBy(xpath = "//a//*[@class='user-account__name' and contains(text(), 'accountforautotest')]")
    private WebElement usernameLabel;

    @FindBy(xpath = "//*[@class='menu__text' and contains(text(), 'Log out')]")
    private WebElement logOutButton;

    @FindBy(id = "passp:sign-in")
    private WebElement logInButton;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void preparationStep() {
        driver.get("https://mail.yandex.com");
        WebElement generalLoginButton = driver.findElement(By.xpath("//span[contains(text(), 'Log in')]//parent::a"));
        generalLoginButton.click();
        WebElement username = driver.findElement(By.id("passp-field-login"));
        username.sendKeys("accountforautotest");
        WebElement loginButton = driver.findElement(By.id("passp:sign-in"));
        loginButton.click();
        WebElement password = driver.findElement(By.id("passp-field-passwd"));
        password.sendKeys("Password1!");
        WebElement loginButton2 = driver.findElement(By.id("passp:sign-in"));
        loginButton2.click();
    }

    public void clickOnUsername(){
        usernameLabel.click();
    }

    public void clickOnLogoutButton(){
        logOutButton.click();
    }

    public boolean isLoginButtonPresent(){
        return logInButton.isDisplayed();
    }
}
