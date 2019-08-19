package com.app.rc.GettingStartedWithRestfulAPI.app.ws.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.rc.GettingStartedWithRestfulAPI.app.logging.Logging;
import com.app.rc.GettingStartedWithRestfulAPI.app.ws.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurity
        extends WebSecurityConfigurerAdapter {

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
    protected void configure (
            HttpSecurity http )
            throws Exception
    {
        Logging.LOG.info (
                "Security Authentication started..." );

        // For Database Access //
        http.authorizeRequests ( ).antMatchers (
                HttpMethod.GET,
                "/console" ).permitAll ( );

        // For Signing-in with the user data //
        http.csrf ( ).and ( ).cors ( ).disable ( );

        // Login Authentication
        http.authorizeRequests ( ).antMatchers (
                HttpMethod.POST,
                SecurityConstants.SIGN_UP_URL )
                .permitAll ( ).anyRequest ( )
                .authenticated ( ).and ( ).addFilter (
                        getAuthenticationFilter ( ) );

        Logging.LOG.info (
                "Security Authentication done..." );
    }

    /**
     * // Attempt // authentication // using //
     * UserDetailsService// And // use // the // provided //
     * Password
     */
    @Override
    protected void configure (
            AuthenticationManagerBuilder auth )
            throws Exception
    {
        Logging.LOG.info (
                "Security AuthenticationManager Validation..." );
        auth.userDetailsService (
                userDetailsService ).passwordEncoder (
                        bCryptPasswordEncoder );
    }

    private AuthenticationFilter getAuthenticationFilter ( )
            throws Exception
    {
        final AuthenticationFilter filter = new AuthenticationFilter (
                authenticationManager ( ),
                userDetailsService );
        Logging.LOG.info (
                "Security AuthenticationFilter Validation..." );
        return filter;
    }
}
