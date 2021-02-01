package pagemanager.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagemanager.PageManager;
import pagemanager.locators.HomePageLocators;

import java.util.List;

public class HomePage {

    private final WebDriver driver;
    private final PageManager pageManager;
    private WebDriverWait wait;

    public HomePage(PageManager pageManager) {
        this.pageManager = pageManager;
        this.driver = pageManager.getDriver();
    }

    @Step("Home Page is Loaded")
    public void homePageIsLoaded() {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(HomePageLocators.getXpathForLogoBanner()));
    }

    @Step("[Sign In] button is clicked on Home Page")
    public void clickOnSignInButton() {
        HomePageLocators.getSignInButton().click();
    }

    @Step("Profile name is Displayed")
    public void profileNameIsDisplayed() {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElement(HomePageLocators.getProfileName(), pageManager.getSignInPage().getProfileName()));
    }

    @Step("Click on New Post button")
    public void clickOnNewPostButton() {
        HomePageLocators.getNewPostButton().click();
    }

    @Step("Go Back on Home Page")
    public void goBackOnHomePage() {
        HomePageLocators.getLogo().click();
    }

    @Step("Verify Article About field on Home Page")
    public String getArticleAboutField() {
        return HomePageLocators.getArticleAboutFieldHomePage().getText();
    }

    @Step("Verify Article Tag field on Home Page")
    public String getArticleTag() {
        return HomePageLocators.getArticleTagFieldHomePage().getText();
    }

    @Step("Open Global Feed")
    public void openGlobalFeed() throws InterruptedException {
        HomePageLocators.getGlobalFeedEle().click();
        Thread.sleep(1000);
    }

    @Step("Motivation Text is Displayed")
    public boolean motivationTextIsDisplayed() {
        return HomePageLocators.getMotivationText().isDisplayed();
    }

    @Step("Click Settings button")
    public void logOut() throws InterruptedException {
        Thread.sleep(1000);
        HomePageLocators.getSettingsButton().click();
        HomePageLocators.getLogOutButton().click();
    }

    //Idea was to open Article according to ProfileName. For that I made List<Webelement> of profile names and made Selector for ReadMore
    //according to i of Article but got Stale Exception. So it really bad implementation as for me.
    //To avoid Stale Element Reference Exception I had to initialize List 2 times, bcz if we refresh/get page elements will be deleted/no longer attached.
    //Im sure that you know better solution, it would be good if you share it with me.
    @Step("Find author and Open Article")
    public void findUserAndOpenArticle() {
        List<WebElement> eles = driver.findElements(By.xpath("/html/body/app-root/app-home/div/div[2]/div/div[1]/app-article-list/app-article-list-item[1]/div/a/span"));
        for (int i = 0; i < eles.size(); i++) {
            List<WebElement> eleNew = driver.findElements(By.xpath("/html/body/app-root/app-home/div/div[2]/div/div[1]/app-article-list/app-article-list-item[1]/div/a/span"));
            eleNew.get(i).click();
        }
    }
}

