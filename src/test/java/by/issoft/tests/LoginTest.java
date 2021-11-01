package by.issoft.tests;

import by.issoft.pagefactory.LoginPage;
import by.issoft.utils.ScreenshotMaker;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
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
    @Issue("1233")
    @Step("User can successfully login")
    @Description("User can successfully login with valid credentials")
    void userShouldLoginWithValidCredentials() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://mail.yandex.com");
        ScreenshotMaker.takeSnapShot(driver, "./src/test/resources/homepage.png");
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
