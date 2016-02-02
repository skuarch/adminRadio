package model.bean;

import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * bean.
 *
 * @author skuarch
 */
public class Station {

    private static final byte MIN_LENGTH_URL_STREAMING = 10;

    @NotNull
    @Min(2)
    private String name = null;
    @NotNull
    @Min(MIN_LENGTH_URL_STREAMING)
    private String urlStreaming = null;
    private String website = null;
    @NotNull
    private List<Keyword> keyword = null;
    @NotNull
    private List<Genre> genre;
    private String description = null;
    @NotNull
    private List<Language> language = null;
    private String frecuency = null;
    private byte active = 1;
    private Country country = null;
    @NotNull
    private StationType stationType = null;
    private int clicks = 0;
    private String modulating = null;

    //==========================================================================
    /**
     * create a instance.
     */
    public Station() {
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getUrlStreaming() {
        return urlStreaming;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param urlStreaming String
     */
    public void setUrlStreaming(String urlStreaming) {
        this.urlStreaming = urlStreaming;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getWebsite() {
        return website;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param website String
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return List
     */
    public List<Keyword> getKeyword() {
        return keyword;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param keyword List
     */
    public void setKeyword(List<Keyword> keyword) {
        this.keyword = keyword;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return List
     */
    public List<Genre> getGenre() {
        return genre;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param genre List
     */
    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return language List
     */
    public List<Language> getLanguage() {
        return language;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param language List
     */
    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getFrecuency() {
        return frecuency;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param frecuency String
     */
    public void setFrecuency(String frecuency) {
        this.frecuency = frecuency;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return byte
     */
    public byte getActive() {
        return active;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param active byte
     */
    public void setActive(byte active) {
        this.active = active;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return Country
     */
    public Country getCountry() {
        return country;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param country Country.
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return StationType
     */
    public StationType getStationType() {
        return stationType;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param stationType StationType
     */
    public void setStationType(StationType stationType) {
        this.stationType = stationType;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return int
     */
    public int getClicks() {
        return clicks;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param clicks int
     */
    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getModulating() {
        return modulating;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param modulating String
     */
    public void setModulating(String modulating) {
        this.modulating = modulating;
    }

    //==========================================================================
    @Override
    public String toString() {
        return " name=" + name + " urlStreaming=" + urlStreaming + " description= " + description + " keyword=" + keyword + " website=" + website + " frecuency=" + frecuency + " modulating=" + modulating + " active=" + active + " clicks=" + clicks + " country=" + country + " genre=" + genre;
    }
} // end class
