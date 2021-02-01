package pagemanager.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagemanager.PageManager;

public class ArticlePageLocators {

    private final WebDriver driver;
    private final PageManager pageManager;

    public ArticlePageLocators(PageManager pageManager) {
        this.pageManager = pageManager;
        this.driver = pageManager.getDriver();
    }

    @FindBy(xpath = "/html/body/app-root/app-article/div/div[1]/div/h1")
    private static WebElement articleTitleFieldArticlePage;

    @FindBy(xpath = "/html/body/app-root/app-article/div/div[2]/div[1]/div/div/p")
    private static WebElement writeYourArticleFieldArticlePage;

    @FindBy(xpath = "/html/body/app-root/app-article/div/div[1]/div/app-article-meta/div/span[1]/button")
    private static WebElement deleteArticleBannerArea;

    @FindBy(xpath = "/html/body/app-root/app-article/div/div[1]/div/app-article-meta/div/span[1]/a")
    private static WebElement editArticleBannerArea;

    public static WebElement getArticleTitleFieldArticlePage() {
        return articleTitleFieldArticlePage;
    }

    public static WebElement getWriteYourArticleFieldArticlePage() {
        return writeYourArticleFieldArticlePage;
    }

    public static WebElement getDeleteArticleBannerArea() {
        return deleteArticleBannerArea;
    }

    public static WebElement getEditArticleBannerArea() {
        return editArticleBannerArea;
    }

}
