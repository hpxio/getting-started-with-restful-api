
package com.app.rc.GettingStartedWithRestfulAPI.app.ws.ui.model.request;

public class UserSignInRequestModel {

    private String email;

    private String password;


    public UserSignInRequestModel ( ) {
    }


    public UserSignInRequestModel ( String email,
            String password ) {
        super ( );
        this.email = email;
        this.password = password;
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
        return "UserSignInRequestModel [email=" + email
                + ", password=" + password + "]";
    }


}
