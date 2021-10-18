package by.issoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {

    WebDriver driver;

    public LogoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void preparationStep(){
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
        WebElement username = driver.findElement(By.xpath("//a//*[@class='user-account__name' and contains(text(), 'accountforautotest')]"));
        username.click();
    }

    public void clickOnLogoutButton(){
        WebElement logoutButton = driver.findElement(By.xpath("//*[@class='menu__text' and contains(text(), 'Log out')]"));
        logoutButton.click();
    }

    public boolean isLoginTitlePresent(){
        return driver.findElement(By.xpath("//*[contains(text(), 'Log in with Yandex ID to access Yandex.Mail')]")).isDisplayed();
    }

    public boolean isLoginButtonPresent(){
        return driver.findElement(By.id("passp:sign-in")).isDisplayed();
    }
}
