
package com.app.rc.GettingStartedWithRestfulAPI.app.ws.security;


import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.app.rc.GettingStartedWithRestfulAPI.app.ws.service.UserService;


@EnableWebSecurity
public class WebSecurity
        extends
            WebSecurityConfigurerAdapter {

    private final UserService userDetailsService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * @param userDetailsService
     * @param bCryptPasswordEncoder
     */
    public WebSecurity ( UserService userDetailsService,
            BCryptPasswordEncoder bCryptPasswordEncoder ) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userDetailsService = userDetailsService;
    }

    /**
     * // Request // authentication // on // REST //
     * End-Points // in which // /user // HTTP // POST// Is
     * // permitted // (since it // is used for // creating
     * // users// Else // any // other // request needs to
     * be // authenticated via // Login
     */
    @Override
    protected void configure ( HttpSecurity http )
            throws Exception {

        // The pages does not require login
        http.authorizeRequests ( )
                .antMatchers ( "/", "/login", "/logout" )
                .permitAll ( );

        http.csrf ( ).disable ( ).authorizeRequests ( )
                .antMatchers ( HttpMethod.POST,
                        SecurityConstants.SIGN_UP_URL )
                .permitAll ( ).anyRequest ( )
                .authenticated ( ).and ( )
                .addFilter ( new AuthenticationFilter (
                        authenticationManager ( ) ) );
    }

    /**
     * // Attempt // authentication // using //
     * UserDetailsService// And // use // the // provided //
     * Password
     */
    @Override
    protected void configure (
            AuthenticationManagerBuilder auth )
            throws Exception {
        auth.userDetailsService ( userDetailsService )
                .passwordEncoder ( bCryptPasswordEncoder );
    }
}
