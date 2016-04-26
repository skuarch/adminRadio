package model.logic;

import java.io.IOException;
import model.net.rest.RestClientGet;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Wrapper for RestClientGet.
 *
 * @author skuarch
 */
public final class RestClientGetAdapter {

    //==========================================================================
    /**
     * this class doesn't need a constructor.
     */
    private RestClientGetAdapter() {
    }

    //==========================================================================
    /**
     * receive data from remote host.
     *
     * @param url String
     * @return JSONArray
     * @throws IOException if something is wrong
     */
    public static JSONArray receive(String url) throws IOException {

        if (url == null || url.length() < 1) {
            throw new IllegalArgumentException("url is null or empty");
        }

        RestClientGet restClientGet = null;
        JSONArray jsonArray;

        try {

            restClientGet = new RestClientGet(url);
            restClientGet.openConnection();
            restClientGet.setAuth(Constants.CREDENTIALS);
            String result = restClientGet.receiveText();
            jsonArray = new JSONArray(result);

        } catch (IOException | JSONException e) {
            throw e;
        } finally {

            if (restClientGet != null) {
                restClientGet.closeConnection();
            }

        }

        return jsonArray;

    }

}
