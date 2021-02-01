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

@Listeners({TestListener.class})
public class checkCreateOption extends TestBase {

    @Test(priority = 1, dataProvider = "allValidFields", dataProviderClass = DataProviderFactory.class, description = "Create Article with valid test data in all fields")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create Article")
    public void checkCreateArticleOption(String articleTitle, String articleAbout, String articleText, String articleTag) throws InterruptedException {
        app.getGeneralActions().createAndPublishArticleWithValidData(articleTitle, articleAbout, articleText, articleTag);
        Assert.assertEquals(app.getPageManager().getArticlePage().getArticleTitle(), articleTitle);
        Assert.assertEquals(app.getPageManager().getArticlePage().getArticleText(), articleText);
        app.getPageManager().getHomePage().goBackOnHomePage();
        app.getPageManager().getHomePage().openGlobalFeed();
        Assert.assertEquals(app.getPageManager().getHomePage().getArticleAboutField(), articleAbout);
        Assert.assertEquals(app.getPageManager().getHomePage().getArticleTag(), articleTag);
        app.getGeneralActions().deleteArticle();
    }

    //TEST WILL BE FAILED
    @Test(priority = 1, dataProvider = "Empty fields", dataProviderClass = DataProviderFactory.class, description = "Create Article with empty fields")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create with Empty fields Article")
    public void checkCreateArticleWithEmptyFieldsOption(String articleTitle, String articleAbout, String articleText, String articleTag) throws InterruptedException {
        app.getGeneralActions().createAndPublishArticleWithValidData(articleTitle, articleAbout, articleText, articleTag);
        if(app.getPageManager().getArticlePage().articlePageIsDisplayed()){
            Assert.fail("Article shouldn't be created");
            app.getPageManager().getArticlePage().deleteArticleBannerArea();

        }
        /*You can remove comment symbols and get Success Test if it is necessary. And comment code above.
        app.getGeneralActions().createAndPublishArticleWithValidData(articleTitle, articleAbout, articleText, articleTag);
        Assert.assertTrue(app.getPageManager().getArticlePage().articlePageIsDisplayed());
        app.getPageManager().getArticlePage().deleteArticleBannerArea();
        */
    }
}
