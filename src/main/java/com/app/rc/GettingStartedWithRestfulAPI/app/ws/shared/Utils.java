
package com.app.rc.GettingStartedWithRestfulAPI.app.ws.shared;


import java.security.SecureRandom;
import java.util.Random;


import org.springframework.stereotype.Component;


/**
 * Generate a User Public Identity. This ID will be used
 * publicly in the HTTP request/responses after login just
 * to authenticate the communication.
 * 
 * @author iHSPA
 */
@Component
public class Utils {

    private final Random RANDOM = new SecureRandom ( );

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    // To be used later //
    private final Integer ITERATION = 10000;

    // To be used later //
    private final Integer KEYLEN = 256;

    /**
     * @param length
     * @return
     */
    public String generateUserId ( int length ) {
        return generateRandomPublicUserId ( length );
    }

    /**
     * @param length
     * @return
     */
    private String generateRandomPublicUserId (
            int length ) {
        StringBuilder id = new StringBuilder ( length );
        for ( int i = 0; i < length; i++ ) {
            id.append ( ALPHABET.charAt ( RANDOM
                    .nextInt ( ALPHABET.length ( ) ) ) );
        }
        return id.toString ( );
    }
}
