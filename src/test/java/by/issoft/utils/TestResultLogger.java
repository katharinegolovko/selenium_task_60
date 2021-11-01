package by.issoft.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TestResultLogger implements TestWatcher {

    public TestResultLogger(WebDriver driver) {
        this.driver = driver;
    }

    private List<TestResultStatus> testResultsStatus = new ArrayList<>();
    private WebDriver driver;

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        testResultsStatus.add(TestResultStatus.FAILED);
        try {
            ScreenshotMaker.takeSnapShot(driver, "./src/test/resources/failed.png");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

