package pagemanager.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagemanager.PageManager;

public class EditorPageLocators {

    private WebDriver driver;
    private PageManager pageManager;

    public EditorPageLocators(PageManager pageManager) {
        this.pageManager = pageManager;
        this.driver = pageManager.getDriver();
    }

    @FindBy(xpath = "/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-input[1]/fieldset/input")
    private static WebElement articleTitleField;

    @FindBy(xpath = "/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-input[2]/fieldset/input")
    private static WebElement articleAboutField;

    @FindBy(xpath = "/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-textarea/fieldset/textarea")
    private static WebElement writeYourArticleField;

    @FindBy(xpath = "/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-input[3]/fieldset/input")
    private static WebElement articleTagField;

    @FindBy(xpath = "/html/body/app-root/app-article-editor/div/div/div/div/button")
    private static WebElement publishArticleButton;

    public static WebElement getArticleTitleField() {
        return articleTitleField;
    }

    public static WebElement getArticleAboutField() {
        return articleAboutField;
    }

    public static WebElement getWriteYourArticleField() {
        return writeYourArticleField;
    }

    public static WebElement getArticleTagField() {
        return articleTagField;
    }

    public static WebElement getPublishArticleButton() {
        return publishArticleButton;
    }

    public static By getXpathForEditButton() {
        return By.xpath("/html/body/app-root/app-article/div/div[1]/div/app-article-meta/div/span[1]/a");
    }
}
