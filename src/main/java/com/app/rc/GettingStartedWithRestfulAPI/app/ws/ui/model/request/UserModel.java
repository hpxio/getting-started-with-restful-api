
package com.app.rc.GettingStartedWithRestfulAPI.app.ws.ui.model.request;

/**
 * Model that will be used to store the incoming Data Model.
 * Contains all the fields which will be sent by the
 * front-end application. We are doing this to get the
 * incoming payload in form of Java class object. This
 * object will be used directly by the JPA/ORM layer to
 * persist it into the DB
 * 
 * @author iHSPA
 */
public class UserModel {


    private String name;

    private String username;

    private String email;

    private String password;


    public UserModel ( ) {
    }


    /**
     * @param id
     * @param name
     * @param username
     * @param email
     * @param password
     */
    public UserModel ( String name, String username,
            String email, String password ) {
        super ( );
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
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


    @Override
    public String toString ( ) {
        return "UserEntity [ name=" + name + ", username="
                + username + ", email=" + email
                + ", password=" + password + "]";
    }
}
