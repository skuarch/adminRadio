package model.logic;

import java.io.IOException;
import java.util.Map;
import model.bean.Station;
import model.net.rest.RestClientPost;
import model.util.StationToMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * wrapper for RestClientPost.
 *
 * @author skuarch
 */
public final class RestClientPostAdapter {

    //==========================================================================
    /**
     * constructor.
     */
    private RestClientPostAdapter() {
    }

    //==========================================================================
    /**
     * send and receive data in JSON format.
     *
     * @param url String
     * @param parameters Map
     * @return JSONObject JSONObject
     * @throws Exception if something happens
     */
    public static JSONObject sendReceive(String url, Map<String, Object> parameters) throws Exception {

        if (parameters == null || parameters.size() < 1) {
            throw new IllegalArgumentException("parameters is null or empty");
        }

        if (url == null || url.length() < 1) {
            throw new IllegalArgumentException("url is null or empty");
        }

        RestClientPost restClientPost = new RestClientPost(url);
        JSONObject jSONObject = null;

        try {

            restClientPost.openConnection();
            restClientPost.setAuth(Constants.CREDENTIALS);
            restClientPost.sendText(restClientPost.getQueryParameters(parameters));
            String result = restClientPost.receiveText();
            jSONObject = new JSONObject(result);

        } catch (IOException | JSONException e) {
            throw e;
        } finally {
            closeRestClientPost(restClientPost);
        }

        return jSONObject;

    }

    //==========================================================================
    /**
     * receive data from remote host.
     *
     * @param url String
     * @return JSONArray
     * @throws Exception if something is wrong
     */
    public static JSONArray receive(String url) throws Exception {

        if (url == null || url.length() < 1) {
            throw new IllegalArgumentException("url is null or empty");
        }

        RestClientPost restClientPost = new RestClientPost(url);
        JSONArray jsonArray = null;

        try {

            restClientPost.openConnection();
            restClientPost.setAuth(Constants.CREDENTIALS);
            String result = restClientPost.receiveText();
            jsonArray = new JSONArray(result);

        } catch (IOException | JSONException e) {
            throw e;
        } finally {
            closeRestClientPost(restClientPost);
        }

        return jsonArray;

    }

    //==========================================================================
    /**
     * send and receive data in JSON format.
     *
     * @param url String
     * @param station Station
     * @return JSONObject JSONObject
     * @throws Exception if something happens
     */
    public static JSONObject sendReceive(String url, Station station) throws Exception {

        if (station == null) {
            throw new IllegalArgumentException("object is null or empty");
        }

        if (url == null || url.length() < 1) {
            throw new IllegalArgumentException("url is null or empty");
        }

        RestClientPost restClientPost = new RestClientPost(url);
        JSONObject jSONObject = null;
        Map<String, Object> parameters;

        try {

            restClientPost.openConnection();
            restClientPost.setAuth(Constants.CREDENTIALS);
            parameters = StationToMap.convertStationToMap(station);

            System.out.println("parameters " + restClientPost.getQueryParameters(parameters));

            restClientPost.sendText(restClientPost.getQueryParameters(parameters));
            String result = restClientPost.receiveText();
            jSONObject = new JSONObject(result);

        } catch (IOException | JSONException e) {
            throw e;
        } finally {
            closeRestClientPost(restClientPost);
        }

        return jSONObject;

    }

    //==========================================================================
    /**
     * secure close connection.
     * @param restClientPost RestClientPost
     * @throws Exception if something is wrong
     */
    private static void closeRestClientPost(RestClientPost restClientPost) throws Exception {

        if (restClientPost != null) {

            try {
                restClientPost.closeConnection();
            } catch (Exception e) {
                throw e;
            }

        }

    }

}
