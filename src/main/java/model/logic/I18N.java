package model.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * static ArrayList.
 *
 * @author skuarch
 */
public final class I18N {

    private static final List<String> ARRAY_LIST = new ArrayList<>();

    //==========================================================================
    static {
        ARRAY_LIST.clear();
        ARRAY_LIST.add("text11");
        ARRAY_LIST.add("text13");
        ARRAY_LIST.add("text15");
        ARRAY_LIST.add("text16");
        ARRAY_LIST.add("text44");
        ARRAY_LIST.add("text45");
        ARRAY_LIST.add("text46");
        ARRAY_LIST.add("text47");
        ARRAY_LIST.add("text48");
        ARRAY_LIST.add("text49");
    }

    //==========================================================================
    /**
     * this class doesn't need a constructor.
     */
    private I18N() {
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return ArrayList
     */
    public static List<String> getArrayList() {

        return ARRAY_LIST;
    }

}
