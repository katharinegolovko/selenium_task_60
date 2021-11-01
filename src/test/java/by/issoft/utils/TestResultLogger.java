package by.issoft.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.ArrayList;
import java.util.List;

public class TestResultLogger implements TestWatcher {

    private List<TestResultStatus> testResultsStatus = new ArrayList<>();

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        testResultsStatus.add(TestResultStatus.FAILED);

    }
}

