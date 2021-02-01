package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {

    private static TestLogger instance;
    private Logger logger;

    public TestLogger() {
        logger = LogManager.getLogger();
    }

    public static TestLogger getInstance() {
        if (instance == null) {
            instance = new TestLogger();
        }
        return instance;
    }

    public Logger getLogger() {
        return logger;
    }
}
