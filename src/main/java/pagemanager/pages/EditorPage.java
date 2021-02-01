package pagemanager.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagemanager.PageManager;
import pagemanager.locators.EditorPageLocators;


public class EditorPage {

    private WebDriver driver;
    private PageManager pageManager;
    private WebDriverWait wait;

    public EditorPage(PageManager pageManager) {
        this.pageManager = pageManager;
        this.driver = pageManager.getDriver();
    }

    @Step("Editor Page is Loaded")
    public void editorPageIsLoaded() {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(EditorPageLocators.getXpathForEditButton()));
    }

    @Step("Fill All fields on Editor Page")
    public void fillAllFields(String articleTitle, String articleAbout, String articleText, String articleTag) throws InterruptedException {
        Thread.sleep(1000);
        EditorPageLocators.getArticleTitleField().clear();
        EditorPageLocators.getArticleAboutField().clear();
        EditorPageLocators.getWriteYourArticleField().clear();
        EditorPageLocators.getArticleTagField().clear();
        EditorPageLocators.getArticleTitleField().sendKeys(articleTitle);
        EditorPageLocators.getArticleAboutField().sendKeys(articleAbout);
        EditorPageLocators.getWriteYourArticleField().sendKeys(articleText);
        EditorPageLocators.getArticleTagField().sendKeys(articleTag);
    }

    @Step("Click Publish Article button")
    public void publishArticle() throws InterruptedException {
        wait = new WebDriverWait(driver, 5);
        Thread.sleep(1000);
        EditorPageLocators.getPublishArticleButton().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-article/div/div[2]/div[2]/app-article-meta/div/span[1]/a")));
    }

    /*That solution works here but it doesnt work for Login process. And did leave it bcz it wont work for empty case. Need to create a separate method.
    public void publishArticle() {
        wait = new WebDriverWait(driver, 5);
        WebElement ele = driver.findElement(By.xpath("/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-input[1]/fieldset/input"));
        WebElement ele2 = driver.findElement(By.xpath("/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-input[2]/fieldset/input"));
        WebElement ele3 = driver.findElement(By.xpath("/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-input[3]/fieldset/input"));
        WebElement ele4 = driver.findElement(By.xpath("/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-textarea/fieldset/textarea"));
        System.out.println(ele.getAttribute("value"));
        System.out.println(ele2.getAttribute("value"));
        System.out.println(ele3.getAttribute("value"));
        System.out.println(ele4.getAttribute("value"));
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-input[1]/fieldset/input"), "Article Title field"));
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-input[2]/fieldset/input"), "Article About field"));
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-input[3]/fieldset/input"), "Article Tag field"));
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-textarea/fieldset/textarea"), "Write your Article field"));
        EditorPageLocators.getPublishArticleButton().click();
        }*/


}

