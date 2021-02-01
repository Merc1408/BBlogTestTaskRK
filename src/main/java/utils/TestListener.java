package utils;

import applogicdetails.ApplicationManagerDetails;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends ApplicationManagerDetails implements ITestListener {

    private final WebDriver driver = ApplicationManagerDetails.getInstance().getWebDriver();
    private final Logger logger = TestLogger.getInstance().getLogger();

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String className = iTestResult.getName();
        logger.info("--- " + className + " test is started ---");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        String className = iTestResult.getName();
        logger.info("--- " + className + " test is passed successfully ---");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        logger.info("--- onTestFailure method" + getTestMethodName(iTestResult) + " failed ---");
        logger.info("--- Screenshot captured for test case: " + getTestMethodName(iTestResult) + " ---");

        saveScreenshotPNG(driver);
        saveTextLog("--- " + getTestMethodName(iTestResult) + " failed and screenshot taken! ---");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("--- Maybe Execute Again? ---");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info("--- Let's Start ---");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("--- That's All? ---");
    }
}
