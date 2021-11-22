package by.issoft.tests;

import by.issoft.pagefactory.LoginPage;
import by.issoft.utils.MyTestWatcher;
import by.issoft.utils.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyTestWatcher.class)
public class LoginTest extends TestBase {

    @Test
    @Issue("1233")
    @Step("User can successfully login")
    @Description("User can successfully login with valid credentials")
    void userShouldLoginWithValidCredentials() throws Exception {
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
}
