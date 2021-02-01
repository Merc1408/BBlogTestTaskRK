package pagemanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pagemanager.locatorfactory.DisplayedElementLocatorFactory;
import pagemanager.locators.ArticlePageLocators;
import pagemanager.locators.EditorPageLocators;
import pagemanager.locators.HomePageLocators;
import pagemanager.locators.SignInPageLocators;
import pagemanager.pages.ArticlePage;
import pagemanager.pages.EditorPage;
import pagemanager.pages.HomePage;
import pagemanager.pages.SignInPage;

public class PageManager {


    private final WebDriver driver;
    private final HomePage homePage;
    private final SignInPage signInPage;
    private final EditorPage editorPage;
    private final ArticlePage articlePage;
    private final HomePageLocators homePageLocators;
    private final SignInPageLocators signInPageLocators;
    private final EditorPageLocators editorPageLocators;
    private final ArticlePageLocators articlePageLocators;

    public HomePage getHomePage() {
        return homePage;
    }

    public SignInPage getSignInPage() {
        return signInPage;
    }

    public EditorPage getEditorPage() {
        return editorPage;
    }

    public ArticlePage getArticlePage() {
        return articlePage;
    }

    public HomePageLocators getHomePageLocators() {
        return homePageLocators;
    }

    public SignInPageLocators getSignInPageLocators() {
        return signInPageLocators;
    }

    public EditorPageLocators getEditorPageLocators() {
        return editorPageLocators;
    }

    public ArticlePageLocators getArticlePageLocators() {
        return articlePageLocators;
    }

    public PageManager(WebDriver driver) {
        this.driver = driver;
        homePage = initElements(new HomePage(this));
        signInPage = initElements(new SignInPage(this));
        editorPage = initElements(new EditorPage(this));
        articlePage = initElements(new ArticlePage(this));
        homePageLocators = initElements(new HomePageLocators(this));
        signInPageLocators = initElements(new SignInPageLocators(this));
        editorPageLocators = initElements(new EditorPageLocators(this));
        articlePageLocators = initElements(new ArticlePageLocators(this));
    }

    private <T> T initElements(T page) {
        PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 5), page);
        return page;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
