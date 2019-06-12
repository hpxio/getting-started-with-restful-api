
package com.app.rc.GettingStartedWithRestfulAPI.app.ws.ui.model.response;

/**
 * Model that will be used to display the outgoing Data
 * Model. Contains all the fields which will be sent to the
 * front-end application. We are doing this to send the
 * outgoing payload in form of JSON/XML object. This object
 * will be used directly by the JPA/ORM layer to persist it
 * into the DB
 * 
 * @author iHSPA
 */
public class UserRest {

    private String name;

    private String username;

    private String email;

    /**
     * @return the email
     */
    public String getEmail ( ) {
        return email;
    }


    /**
     * @return the name
     */
    public String getName ( ) {
        return name;
    }


    /**
     * @return the username
     */
    public String getUsername ( ) {
        return username;
    }


    /**
     * @param email
     *            the email to set
     */
    public void setEmail ( String email ) {
        this.email = email;
    }


    /**
     * @param name
     *            the name to set
     */
    public void setName ( String name ) {
        this.name = name;
    }


    /**
     * @param username
     *            the username to set
     */
    public void setUsername ( String username ) {
        this.username = username;
    }


    @Override
    public String toString ( ) {
        return "UserRest [name=" + name + ", username="
                + username + ", email=" + email + "]";
    }


}
