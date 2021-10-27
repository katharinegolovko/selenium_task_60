package by.issoft.tests;

import by.issoft.pagefactory.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    void userShouldLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://mail.yandex.com");
        loginPage.clickGeneralLoginButton();
        loginPage.enterUsername("accountforautotest");
        loginPage.clickLoginButton();
        loginPage.enterPassword("Password1!");
        loginPage.clickLoginButton();
        Assertions.assertTrue(loginPage.isInboxPresent());
        Assertions.assertTrue(loginPage.isUsernamePresent());
        Assertions.assertTrue(loginPage.isEmailContainerPresent());
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
