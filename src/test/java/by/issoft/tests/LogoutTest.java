package by.issoft.tests;

import by.issoft.pagefactory.LogoutPage;
import by.issoft.utils.TestResultLogger;
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

public class LogoutTest {

    private WebDriver driver;
    TestResultLogger testResultLogger = new TestResultLogger();


    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    @Issue("1234")
    @Step("User can successfully logout")
    @Description("User can successfully logout")
    void userShouldSuccessfullyLogout() {
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.preparationStep();
        //logoutPage.clickOnUsername();
        logoutPage.clickOnLogoutButton();
        Assertions.assertTrue(logoutPage.isLoginButtonPresent());
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
