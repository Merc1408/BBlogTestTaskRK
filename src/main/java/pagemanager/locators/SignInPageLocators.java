package pagemanager.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagemanager.PageManager;

public class SignInPageLocators {

    private WebDriver driver;
    private PageManager pageManager;

    public SignInPageLocators(PageManager pageManager) {
        this.pageManager = pageManager;
        this.driver = pageManager.getDriver();
    }

    @FindBy(xpath = "/html/body/app-root/app-login/div/div/div/div/app-dynamic-form/form/app-input[1]/fieldset/input")
    private static WebElement userNameField;

    @FindBy(xpath = "/html/body/app-root/app-login/div/div/div/div/app-dynamic-form/form/app-input[2]/fieldset/input")
    private static WebElement passwordField;

    @FindBy(xpath = "/html/body/app-root/app-login/div/div/div/div/button")
    private static WebElement signInButtonSignInPage;

    @FindBy(xpath = "/html/body/app-root/app-login/div/div/div/div/app-list-errors/ul/li")
    private static WebElement emailBlankError;

    public static WebElement getUserNameField() {
        return userNameField;
    }

    public static WebElement getPasswordField() {
        return passwordField;
    }

    public static WebElement getSignInButtonSignInPage() {
        return signInButtonSignInPage;
    }

    public static WebElement getEmailBlankError() {
        return emailBlankError;
    }

    public static Boolean allertAppeared(){
        return getEmailBlankError().isDisplayed();
    }
}
