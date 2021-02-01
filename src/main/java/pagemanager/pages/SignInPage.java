package pagemanager.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagemanager.PageManager;
import pagemanager.locators.SignInPageLocators;


public class SignInPage {

    private final WebDriver driver;
    private final PageManager pageManager;
    private final String userName = "rk@gmail.com"; //The same situation as with creds for TestSite.
    private final String password = "qwerty";
    private final String profileName = "rk";
    private WebDriverWait wait;


    public String getProfileName() {
        return profileName;
    }

    public SignInPage(PageManager pageManager) {
        this.pageManager = pageManager;
        this.driver = pageManager.getDriver();
    }

    @Step("User is Logged in Bblog with his/her creds")
    public void loginInApp() {
        SignInPageLocators.getUserNameField().sendKeys(userName);
        SignInPageLocators.getPasswordField().sendKeys(password);
        SignInPageLocators.getSignInButtonSignInPage().click();
        if (SignInPageLocators.allertAppeared()) {
            SignInPageLocators.getSignInButtonSignInPage().click();
        }
    }

    /* Tried to use wait, in console I see values and it's ok. But Login clicks even with that waits, So login though the allert message.
    @Step("User is Logged in Bblog with his/her creds")
    public void loginInApp(){
        wait = new WebDriverWait(driver, 5);
        SignInPageLocators.getUserNameField().sendKeys(userName);
        SignInPageLocators.getPasswordField().sendKeys(password);
        WebElement ele = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div/app-dynamic-form/form/app-input[1]/fieldset/input"));
        WebElement ele2 = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div/app-dynamic-form/form/app-input[2]/fieldset/input"));
        System.out.println(ele.getAttribute("value"));
        System.out.println(ele2.getAttribute("value"));
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("/html/body/app-root/app-login/div/div/div/div/app-dynamic-form/form/app-input[1]/fieldset/input"), "rk@gmail.com"));
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("/html/body/app-root/app-login/div/div/div/div/app-dynamic-form/form/app-input[2]/fieldset/input"), "qwerty"));
        SignInPageLocators.getSignInButtonSignInPage().click();*/


}
