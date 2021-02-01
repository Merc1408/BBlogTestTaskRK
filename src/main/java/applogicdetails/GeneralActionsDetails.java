package applogicdetails;

import applogic.GeneralActions;
import pagemanager.PageManager;

public class GeneralActionsDetails extends PageManager implements GeneralActions {

    public GeneralActionsDetails(ApplicationManagerDetails applicationManagerDetails) {
        super(applicationManagerDetails.getWebDriver());
    }

    @Override
    public void createAndPublishArticleWithValidData(String articleTitle, String articleAbout, String articleText, String articleTag) throws InterruptedException {
        getHomePage().homePageIsLoaded();
        getHomePage().clickOnNewPostButton();
        getEditorPage().fillAllFields(articleTitle, articleAbout, articleText, articleTag);
        getEditorPage().publishArticle();
    }

    @Override
    public void deleteArticle() {
        getHomePage().findUserAndOpenArticle();
        getArticlePage().deleteArticleBannerArea();
    }
}
