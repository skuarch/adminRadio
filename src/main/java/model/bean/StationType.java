package model.bean;

/**
 * Bean.
 * @author skuarch
 */
public class StationType {

    private long id;
    private String name = null;

    //==========================================================================
    /**
     * constructor.
     */
    public StationType() {
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return id long
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
     * @return name String
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
