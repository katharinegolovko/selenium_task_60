package by.issoft.tests;

import by.issoft.pagefactory.LogoutPage;
import by.issoft.utils.MyTestWatcher;
import by.issoft.utils.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyTestWatcher.class)
public class LogoutTest extends TestBase {

    @Test
    @Issue("1234")
    @Step("User can successfully logout")
    @Description("User can successfully logout")
    void userShouldSuccessfullyLogout() {
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.preparationStep();
        logoutPage.clickOnUsername();
        logoutPage.clickOnLogoutButton();
        Assertions.assertTrue(logoutPage.isLoginButtonPresent());
    }
}
