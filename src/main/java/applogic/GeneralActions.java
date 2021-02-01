package applogic;

public interface GeneralActions {

    void createAndPublishArticleWithValidData(String articleTitle, String articleAbout, String articleText, String articleTag) throws InterruptedException;

    void deleteArticle() throws InterruptedException;
}
