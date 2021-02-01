package testsettings;

import applogic.ApplicationManager;
import applogicdetails.ApplicationManagerDetails;
import org.testng.Assert;
import org.testng.annotations.*;
import pagemanager.locators.HomePageLocators;

public class TestBase {

    protected ApplicationManager app;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        app = ApplicationManagerDetails.getInstance();
        app.openWindowMax();
        app.openBaseUrl();
    }

    @BeforeMethod
    public void beforeMethod() {
        app.getPageManager().getHomePage().clickOnSignInButton();
        app.getPageManager().getSignInPage().loginInApp();
        app.getPageManager().getHomePage().profileNameIsDisplayed();
        Assert.assertEquals(HomePageLocators.getProfileName().getText(), app.getPageManager().getSignInPage().getProfileName());
        app.getPageManager().getHomePage().homePageIsLoaded();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        app.getPageManager().getHomePage().logOut();
        app.getPageManager().getHomePage().goBackOnHomePage();
    }

    @AfterSuite
    public void stop() {
        app.stop();
    }
}
