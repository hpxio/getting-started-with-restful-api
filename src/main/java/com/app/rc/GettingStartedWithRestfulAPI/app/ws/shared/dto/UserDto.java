
package com.app.rc.GettingStartedWithRestfulAPI.app.ws.shared.dto;


import java.io.Serializable;


/**
 * Data Transfer Objects - Used for simply passing the
 * objects information from one state to another. It may
 * contain fields from the requesting services and some
 * additional data which will be used by other layers before
 * responding. This will be used by the DAO layer to persist
 * the data.
 * 
 * @author iHSPA
 */
public class UserDto implements Serializable {

    private static final long serialVersionUID = -2342381313817838759L;

    private int id;

    private String userId;

    private String name;

    private String email;

    private String username;

    private String password;

    private String encryptedPassword;

    private String emailToken;

    private boolean emailStatus;


    /**
     * @return the id
     */
    public int getId ( ) {
        return id;
    }


    /**
     * @param id
     *            the id to set
     */
    public void setId ( int id ) {
        this.id = id;
    }


    /**
     * @return the userId
     */
    public String getUserId ( ) {
        return userId;
    }


    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId ( String userId ) {
        this.userId = userId;
    }


    /**
     * @return the name
     */
    public String getName ( ) {
        return name;
    }


    /**
     * @param name
     *            the name to set
     */
    public void setName ( String name ) {
        this.name = name;
    }


    /**
     * @return the username
     */
    public String getUsername ( ) {
        return username;
    }


    /**
     * @param username
     *            the username to set
     */
    public void setUsername ( String username ) {
        this.username = username;
    }


    /**
     * @return the password
     */
    public String getPassword ( ) {
        return password;
    }


    /**
     * @param password
     *            the password to set
     */
    public void setPassword ( String password ) {
        this.password = password;
    }


    /**
     * @return the encryptedPassword
     */
    public String getEncryptedPassword ( ) {
        return encryptedPassword;
    }


    /**
     * @param encryptedPassword
     *            the encryptedPassword to set
     */
    public void setEncryptedPassword (
            String encryptedPassword ) {
        this.encryptedPassword = encryptedPassword;
    }


    /**
     * @return the emailToken
     */
    public String getEmailToken ( ) {
        return emailToken;
    }


    /**
     * @param emailToken
     *            the emailToken to set
     */
    public void setEmailToken ( String emailToken ) {
        this.emailToken = emailToken;
    }


    /**
     * @return the emailStatus
     */
    public boolean isEmailStatus ( ) {
        return emailStatus;
    }


    /**
     * @param emailStatus
     *            the emailStatus to set
     */
    public void setEmailStatus ( boolean emailStatus ) {
        this.emailStatus = emailStatus;
    }


    /**
     * @return the email
     */
    public String getEmail ( ) {
        return email;
    }


    /**
     * @param email
     *            the email to set
     */
    public void setEmail ( String email ) {
        this.email = email;
    }


    @Override
    public String toString ( ) {
        return "UserDto [id=" + id + ", userId=" + userId
                + ", name=" + name + ", email=" + email
                + ", username=" + username + ", password="
                + password + ", encryptedPassword="
                + encryptedPassword + ", emailToken="
                + emailToken + ", emailStatus="
                + emailStatus + "]";
    }


}
