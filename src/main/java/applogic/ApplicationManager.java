package applogic;

import pagemanager.PageManager;

public interface ApplicationManager {

    void openWindowMax();

    void stop();

    void openBaseUrl();

    GeneralActions getGeneralActions();

    PageManager getPageManager();
}
