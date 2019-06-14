package com.app.rc.GettingStartedWithRestfulAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.rc.GettingStartedWithRestfulAPI.app.logging.Logging;

@SpringBootApplication
public class GettingStartedWithRestfulApiApplication {

    public static void main (
            String[] args )
    {
        Logging.LOG.info (
                "Application Started..." );
        SpringApplication.run (
                GettingStartedWithRestfulApiApplication.class,
                args );
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder ( )
    {
        return ( new BCryptPasswordEncoder ( ) );
    }
}
