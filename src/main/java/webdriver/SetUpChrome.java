package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static webdriver.WebDriverFactory.getUserDir;

public class SetUpChrome {

    public static WebDriver setUpChrome() {

        System.setProperty("webdriver.chrome.driver", getUserDir() + "/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless.mode", "false"));
        options.setHeadless(headless);
        return new ChromeDriver(options);

    }
}
