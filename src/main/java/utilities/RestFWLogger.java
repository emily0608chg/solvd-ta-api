package utilities;

import java.util.logging.Logger;

public class RestFWLogger {

    //Initialize Log4j logs
    private static Logger Log = Logger.getLogger(RestFWLogger.class.getName());

    // This is to print log for the beginning of the test case
    public static void startTestCase(String sTestCaseName) {

        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
        Log.info("$$$$$$$$$$$$$$$$$$$$$            " + sTestCaseName + "         $$$$$$$$$$$$$$$$$$$$$$$$$");
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");

    }

    public static void endTestCase() {

        Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
        Log.info("XXXXXXXXXXXXXXXXXXXXXXX***********************************************XXXXXXXXXXXXXXXXXXXXXX");
        Log.info("XXXXXXXXXXXXXXXXXXXXXXX***********************************************XXXXXXXXXXXXXXXXXXXXXX");
        Log.info("X");
        Log.info("X");
        Log.info("X");
        Log.info("X");
        Log.info("X");

    }

    // Need to create these methods, so that they can be called
    public static void info(String message) {
        Log.info(message);
    }

    public static void warning(String message) {
        Log.warning(message);
    }



}
