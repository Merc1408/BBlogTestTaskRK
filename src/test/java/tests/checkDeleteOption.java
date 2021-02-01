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
public class checkDeleteOption extends TestBase {

    @Test(priority = 1, dataProvider = "allValidFields", dataProviderClass = DataProviderFactory.class, description = "Delete Article from Feed")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Delete Article")
    public void checkDeleteArticleOption(String articleTitle, String articleAbout, String articleText, String articleTag) throws InterruptedException {
        app.getGeneralActions().createAndPublishArticleWithValidData(articleTitle, articleAbout, articleText, articleTag);
        Assert.assertEquals(app.getPageManager().getArticlePage().getArticleTitle(), articleTitle);
        app.getPageManager().getArticlePage().deleteArticleBannerArea();
        app.getPageManager().getHomePage().openGlobalFeed();
        Assert.assertTrue(app.getPageManager().getHomePage().motivationTextIsDisplayed());
    }
}
