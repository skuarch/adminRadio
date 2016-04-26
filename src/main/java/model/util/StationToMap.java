package model.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.bean.Genre;
import model.bean.Keyword;
import model.bean.Language;
import model.bean.Station;

/**
 * helper for convert Station bean to Map.
 *
 * @author skuarch
 */
public final class StationToMap {

    //==========================================================================
    /**
     * this class doesn't need a constructor.
     */
    private StationToMap() {

    }

    //==========================================================================
    /**
     * this class convert an Station bean to Map.
     *
     * @param station Station
     * @return Map
     */
    public static Map<String, Object> convertStationToMap(Station station) {

        Map<String, Object> map = new HashMap<>();
        map.put("name", station.getName());
        map.put("urlStreaming", station.getUrlStreaming());
        map.put("description", station.getDescription());
        map.put("website", station.getWebsite());

        List<Keyword> keywords = station.getKeyword();
        for (int i = 0; i < keywords.size(); i++) {
            map.put("keyword[" + i + "].id", keywords.get(i).getId());
        }

        List<Genre> genre = station.getGenre();
        for (int i = 0; i < genre.size(); i++) {
            map.put("genre[" + i + "].id", genre.get(i).getId());
        }

        map.put("modulating", station.getModulating());
        map.put("active", station.getActive());
        map.put("clicks", station.getClicks());
        map.put("country.id", station.getCountry().getId());
        map.put("frecuency", station.getFrecuency());

        List<Language> languages = station.getLanguage();
        for (int i = 0; i < languages.size(); i++) {
            map.put("language[" + i + "].id", languages.get(i).getId());
        }

        map.put("stationType.id", station.getStationType().getId());

        return map;

    }

}
