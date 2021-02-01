package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static webdriver.WebDriverFactory.getUserDir;

public class SetUpFireFox {

    public static WebDriver setUpFireFox() {
        System.setProperty("webdriver.gecko.driver", getUserDir() + "/driver/geckodriver.exe");
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        boolean headlessFire = Boolean.parseBoolean(System.getProperty("headless.mode", "false"));
        optionsFirefox.setHeadless(headlessFire);
        return new FirefoxDriver(optionsFirefox);
    }
}
