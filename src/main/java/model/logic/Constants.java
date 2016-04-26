package model.logic;

/**
 *
 * @author skuarch
 */
public final class Constants {

    public static final String API_RADIO_URL = "http://skuarch.com:8000/";
    public static final int MAX_FILE_SIZE_UPLOAD = 1048576; // 1 mb
    public static final int INCREASE_COUNTER = 60;
    public static final int INTERVAL_SESSION_CHECK = 60000;
    public static final byte PASSWORD_LENGTH = 32;
    public static final int TIME_SLEEP_LOGIN = 1500;

    public static final String CREDENTIALS = "skuarch@yahoo.com.mx:59119d7e886176032c2f0306e4101a7f";

    public static final String DEFAULT_I18N_TEXT_ERROR = "text19";

    public static final int HTTP_OK = 200;

    //==========================================================================
    /**
     * this class doesn't need a constructor.
     */
    public Constants() {
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return int
     */
    public static int getIntervalSessionCheck() {
        return INTERVAL_SESSION_CHECK;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return int
     */
    public static int getIncreaseCounter() {
        return INCREASE_COUNTER;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return int
     */
    public static int getMaxFileSizeUpload() {
        return MAX_FILE_SIZE_UPLOAD;
    }

}
