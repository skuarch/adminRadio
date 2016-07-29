package model.persistence;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * bean.
 *
 * @author skuarch
 */
public class Genre implements Serializable {

    private static final long serialVersionUID = 940879717204195007L;
    private long id;
    @NotNull    
    private String nameEnglish = null;
    @NotNull
    private String nameSpanish = null;

    //==========================================================================
    /**
     * constructor.
     */
    public Genre() {
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param id long
     */
    public void setId(long id) {
        this.id = id;
    }

    //==========================================================================
    public String getNameEnglish() {
        return nameEnglish;
    }

    //==========================================================================
    public void setNameEnglish(String nameEnglish) {
        if (nameEnglish == null || nameEnglish.length() < 1) {
            throw new IllegalArgumentException("nameEnglish is null or empty");
        }
        this.nameEnglish = nameEnglish;
    }

    //==========================================================================
    public String getNameSpanish() {
        if (nameSpanish == null || nameSpanish.length() < 1) {
            throw new IllegalArgumentException("nameSpanish is null or empty");
        }
        return nameSpanish;
    }

    //==========================================================================
    public void setNameSpanish(String nameSpanish) {
        this.nameSpanish = nameSpanish;
    }

    //==========================================================================
    /**
     * to string.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "id=" + id + " nameEnglish=" + nameEnglish + " nameSpanish=" + nameSpanish;
    }

} // end class
