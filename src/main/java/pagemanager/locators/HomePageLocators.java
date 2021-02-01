package pagemanager.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagemanager.PageManager;

import java.util.List;

public class HomePageLocators {

    private WebDriver driver;
    private PageManager pageManager;

    public HomePageLocators(PageManager pageManager) {
        this.pageManager = pageManager;
        this.driver = pageManager.getDriver();
    }


    @FindBy(xpath = "/html/body/app-root/app-navbar/nav/div/ul/li[2]/a")
    private static WebElement signInButtonHomePage;

    @FindBy(xpath = "/html/body/app-root/app-navbar/nav/div/a")
    private static WebElement logo;

    @FindBy(xpath = "/html/body/app-root/app-navbar/nav/div/ul/li[2]/a")
    private static WebElement profileName;

    @FindBy(xpath = "/html/body/app-root/app-navbar/nav/div/ul/li[3]/a")
    private static WebElement newPostButton;

    @FindBy(xpath = "/html/body/app-root/app-home/div/div[2]/div/div[1]/app-article-list/app-article-list-item[1]/div/a/p")
    private static WebElement articleAboutFieldHomePage;

    @FindBy(xpath = "/html/body/app-root/app-home/div/div[2]/div/div[1]/app-article-list/app-article-list-item[1]/div/a/ul/li")
    private static WebElement articleTagFieldHomePage;

    @FindBy(xpath = "/html/body/app-root/app-home/div/div[2]/div/div[1]/div/ul/li[2]/a")
    private static WebElement globalFeedEle;

    @FindBy(xpath = "/html/body/app-root/app-home/div/div[1]/div/p")
    private static WebElement motivationText;

    @FindBy(xpath = "/html/body/app-root/app-navbar/nav/div/ul/li[4]/a")
    private static WebElement settingsButton;

    @FindBy(xpath = "/html/body/app-root/app-settings/div/div/div/div/button")
    private static WebElement logOutButton;

    @FindBy(xpath = "/html/body/app-root/app-home/div/div[1]/div/h1")
    private static WebElement logoOnBanner;

    @FindBy(className = "author")
    private static List<WebElement> authorOfArticle;

    @FindBy(xpath = "/html/body/app-root/app-home/div/div[2]/div/div[1]/app-article-list/app-article-list-item[1]/div/a/span")
    private static WebElement readMore;


    public static WebElement getGlobalFeedEle() {
        return globalFeedEle;
    }

    public static WebElement getLogo() {
        return logo;
    }

    public static WebElement getSignInButton() {
        return signInButtonHomePage;
    }

    public static WebElement getProfileName() {
        return profileName;
    }

    public static WebElement getNewPostButton() {
        return newPostButton;
    }

    public static WebElement getArticleAboutFieldHomePage() {
        return articleAboutFieldHomePage;
    }

    public static WebElement getArticleTagFieldHomePage() {
        return articleTagFieldHomePage;
    }

    public static WebElement getMotivationText() {
        return motivationText;
    }

    public static WebElement getSettingsButton() {
        return settingsButton;
    }

    public static WebElement getLogOutButton() {
        return logOutButton;
    }

    public static WebElement getLogoOnBanner() {
        return logoOnBanner;
    }

    public static List<WebElement> getAuthorOfArticle() {
        return authorOfArticle;
    }

    public static WebElement getReadMore() {
        return readMore;
    }

    public static By getChildReadMore(int numberOfChild) {
        return By.cssSelector("body > app-root > app-home > div > div.container.page > div > div.col-md-9 > app-article-list > app-article-list-item:nth-child(" + numberOfChild + ") > div > a > span");
    }

    public static By getXpathForLogoBanner() {
        return By.xpath("/html/body/app-root/app-home/div/div[1]/div/h1");
    }

    public static By getXpathForTheFirstArticle() {
        return By.xpath("/html/body/app-root/app-home/div/div[2]/div/div[1]/app-article-list/app-article-list-item[1]/div");
    }
}
