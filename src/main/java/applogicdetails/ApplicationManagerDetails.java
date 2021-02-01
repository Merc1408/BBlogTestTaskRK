package applogicdetails;

import applogic.ApplicationManager;
import applogic.GeneralActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagemanager.PageManager;
import utils.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManagerDetails implements ApplicationManager {

    private final GeneralActions generalActions;
    private final PageManager pageManager;
    private final WebDriver driver;
    private final String baseUrl;
    private static ApplicationManagerDetails instance;

    public ApplicationManagerDetails() {
        String browser = System.getProperty("browser.name", "chrome");
        driver = WebDriverFactory.getInst(browser);
        baseUrl = PropertyLoader.loadProperty("site.url"); //For security I would set credentials as params for maven and made input when mvn test, but I hope that normal to set in URL for test task :)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        generalActions = new GeneralActionsDetails(this);
        pageManager = new PageManager(driver);
    }


    public static ApplicationManagerDetails getInstance() {
        if (instance == null) {
            instance = new ApplicationManagerDetails();
        }
        return instance;
    }

    @Override
    public void openWindowMax() {
        driver.manage().window().maximize();
    }

    @Override
    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Override
    public void openBaseUrl() {
        driver.get(baseUrl);
    }

    @Override
    public GeneralActions getGeneralActions() {
        return generalActions;
    }

    @Override
    public PageManager getPageManager() {
        return pageManager;
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
