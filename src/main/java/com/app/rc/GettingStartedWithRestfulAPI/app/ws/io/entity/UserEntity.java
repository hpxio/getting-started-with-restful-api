
package com.app.rc.GettingStartedWithRestfulAPI.app.ws.io.entity;


import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table ( name = "users" )
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -8076567085913145189L;

    @Id
    @GeneratedValue
    private int id;

    @Column ( nullable = false )
    private String userId;

    @Column ( nullable = false )
    private String name;

    @Column ( nullable = false, unique = true )
    private String email;

    @Column ( nullable = false )
    private String username;

    @Column ( nullable = false )
    private String password;

    @Column ( nullable = false )
    private String encryptedPassword;


    private String emailToken;

    @Column ( nullable = false, columnDefinition = "boolean default false" )
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
        return "UserEntity [id=" + id + ", userId=" + userId
                + ", name=" + name + ", email=" + email
                + ", username=" + username + ", password="
                + password + ", encryptedPassword="
                + encryptedPassword + ", emailToken="
                + emailToken + ", emailStatus="
                + emailStatus + "]";
    }
}
