package com.app.rc.GettingStartedWithRestfulAPI.app.ws.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.rc.GettingStartedWithRestfulAPI.app.logging.Logging;
import com.app.rc.GettingStartedWithRestfulAPI.app.ws.service.UserService;
import com.app.rc.GettingStartedWithRestfulAPI.app.ws.ui.model.request.UserSignInRequestModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Harsh
 */
public class AuthenticationFilter
        extends UsernamePasswordAuthenticationFilter {

    private final UserService userService;

    private final AuthenticationManager auth;

    /**
     * @param auth
     * @param userService
     */
    public AuthenticationFilter (
            AuthenticationManager auth,
            UserService userService ) {
        this.auth = auth;
        this.userService = userService;
    }

    /**
     * 
     */
    @Override
    public Authentication attemptAuthentication (
            HttpServletRequest request,
            HttpServletResponse response )
            throws AuthenticationException
    {
        Logging.LOG.info (
                "Security AuthenticationFilter - Custom Implementation..." );
        try {
            UserSignInRequestModel userSignInRequestModel = new ObjectMapper ( )
                    .readValue (
                            request.getInputStream ( ),
                            UserSignInRequestModel.class );
            Logging.LOG.info (
                    "Security AuthenticationFilter - attempt complete..." );
            return auth.authenticate (
                    new UsernamePasswordAuthenticationToken (
                            userSignInRequestModel
                                    .getEmail ( ),
                            userSignInRequestModel
                                    .getPassword ( ),
                            new ArrayList<> ( ) ) );
        } catch ( Exception e ) {
            throw new RuntimeException ( e.getMessage ( ) );
        }
    }

    @Override
    /**
     * 
     */
    protected void successfulAuthentication (
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication auth )
            throws IOException,
            ServletException
    {
        Logging.LOG.info (
                "On Successful Authentication..." );
        String userName = ( ( User ) auth.getPrincipal ( ) )
                .getUsername ( );
        String token = Jwts.builder ( ).setSubject (
                userName ).setExpiration (
                        new Date ( System
                                .currentTimeMillis ( )
                                + SecurityConstants.EXPIRATION_TIME ) )
                .signWith (
                        SignatureAlgorithm.HS512,
                        SecurityConstants.TOKEN_SECRET )
                .compact ( );
        Logging.LOG.info (
                "Successful Auth Done - Filling Headers..." );
        response.addHeader (
                SecurityConstants.HEADER_STRING,
                SecurityConstants.TOKEN_PREFIX + token );
        Logging.LOG.info (
                "Security Authentication - All Complete..." );
    }
}
