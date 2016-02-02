package model.bean;

import java.io.Serializable;

/**
 * bean.
 *
 * @author skuarch
 */
public class Genre implements Serializable {

    private static final long serialVersionUID = 940879717204195007L;
    private long id;    
    private String name = null;

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
    /**
     * getter.
     *
     * @return name
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
     * to string.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "id=" + id + " name=" + name;
    }

} // end class
