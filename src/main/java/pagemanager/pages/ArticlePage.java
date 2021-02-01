package pagemanager.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pagemanager.PageManager;
import pagemanager.locators.ArticlePageLocators;

public class ArticlePage {

    private WebDriver driver;
    private PageManager pageManager;

    public ArticlePage(PageManager pageManager) {
        this.pageManager = pageManager;
        this.driver = pageManager.getDriver();
    }

    @Step("Verify Article Title field on Article Page")
    public String getArticleTitle() {
        return ArticlePageLocators.getArticleTitleFieldArticlePage().getText();
    }

    @Step("Verify Article Text field on Article Page")
    public String getArticleText() {
        return ArticlePageLocators.getWriteYourArticleFieldArticlePage().getText();
    }

    @Step("Delete Article")
    public void deleteArticleBannerArea() {
        ArticlePageLocators.getDeleteArticleBannerArea().click();
    }

    @Step("Open Article for editing")
    public void clickEditArticleButtonBannerArea() {
        ArticlePageLocators.getEditArticleBannerArea().click();
    }

    @Step("Edit Button is Displayed")
    public Boolean articlePageIsDisplayed() {
        return ArticlePageLocators.getEditArticleBannerArea().isDisplayed();
    }
}
