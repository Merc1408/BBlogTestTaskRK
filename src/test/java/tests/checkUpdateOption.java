package tests;

import dataprovider.DataProviderFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testsettings.TestBase;
import utils.TestListener;

@Listeners(TestListener.class)
public class checkUpdateOption extends TestBase {

    @Test(priority = 1, dataProvider = "allValidFields for check edit option", dataProviderClass = DataProviderFactory.class, description = "Update Existing Article")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Update Article")
    public void checkUpdateArticleOption(String articleTitle, String articleAbout, String articleText, String articleTag, String articleTitleU, String articleAboutU, String articleTextU, String articleTagU) throws InterruptedException {
        app.getGeneralActions().createAndPublishArticleWithValidData(articleTitle, articleAbout, articleText, articleTag);
        app.getPageManager().getHomePage().goBackOnHomePage();  //Open Home Page and then Click on Global Feed are repeated actions so it possible to combine them
        app.getPageManager().getHomePage().openGlobalFeed();
        app.getPageManager().getHomePage().findUserAndOpenArticle();
        app.getPageManager().getEditorPage().editorPageIsLoaded();
        app.getPageManager().getArticlePage().clickEditArticleButtonBannerArea();
        app.getPageManager().getEditorPage().fillAllFields(articleTitleU, articleAboutU, articleTextU, articleTagU);
        app.getPageManager().getEditorPage().publishArticle();
        Assert.assertEquals(app.getPageManager().getArticlePage().getArticleTitle(), articleTitleU);
        Assert.assertEquals(app.getPageManager().getArticlePage().getArticleText(), articleTextU);
        app.getPageManager().getHomePage().goBackOnHomePage();
        app.getPageManager().getHomePage().openGlobalFeed();
        Assert.assertEquals(app.getPageManager().getHomePage().getArticleAboutField(), articleAboutU);
        Assert.assertEquals(app.getPageManager().getHomePage().getArticleTag(), articleTagU);
        app.getGeneralActions().deleteArticle();
    }
}
