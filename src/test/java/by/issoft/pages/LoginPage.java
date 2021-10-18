package by.issoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(String username){
        WebElement usernameElement = driver.findElement(By.id("passp-field-login"));
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password){
        WebElement passwordElement = driver.findElement(By.id("passp-field-passwd"));
        passwordElement.sendKeys("Password1!");
    }

    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(By.id("passp:sign-in"));
        loginButton.click();
    }

    public void clickGeneralLoginButton(){
        WebElement generalLoginButton = driver.findElement(By.xpath("//span[contains(text(), 'Log in')]//parent::a"));
        generalLoginButton.click();
    }

    public boolean isInboxPresent(){
        return driver.findElement(By.xpath("//*[@class='mail-NestedList-Item-Name' and contains(text(), 'Inbox')]")).isDisplayed();
    }

    public boolean isUsernamePresent(){
        return driver.findElement(By.xpath("//*[@target='_parent']//*[@class='user-account__name' and contains(text(), 'accountforautotest')]")).isDisplayed();
    }

    public boolean isEmailContainerPresent(){
        return driver.findElement(By.xpath("//*[@class='mail-Layout-ContentWrapper']")).isDisplayed();
    }
}

