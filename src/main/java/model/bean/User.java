package model.bean;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author skuarch
 */
public class User implements Serializable {

    private static final long serialVersionUID = 5461219682419251807L;
    private static final byte PASSWORD_LENGTH = 32;

    @NotNull
    private String email;
    @NotNull
    private String password;

    private String name;

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getEmail() {
        return email;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param password String
     */
    public void setPassword(String password) {
        if (password == null || password.length() != PASSWORD_LENGTH) {
            throw new IllegalArgumentException("password is wrong");
        }
        this.password = password;
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

}
