package webdriver;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class WebDriverFactory {

    private static final String USER_DIR = System.getProperty("user.dir");

    public static String getUserDir() {
        return USER_DIR;
    }

    private static WebDriver webDriver = null;

    public static WebDriver getInst(String browser) {

        if (webDriver != null) {
            return webDriver;
        }
        switch (browser) {
            case CHROME: {
                webDriver = SetUpChrome.setUpChrome();
                break;
            }
            case FIREFOX: {
                webDriver = SetUpFireFox.setUpFireFox();
                break;
            }
        }
        return webDriver;
    }
}
