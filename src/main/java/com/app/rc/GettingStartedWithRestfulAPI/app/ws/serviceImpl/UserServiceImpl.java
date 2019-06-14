package com.app.rc.GettingStartedWithRestfulAPI.app.ws.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.rc.GettingStartedWithRestfulAPI.app.ws.io.entity.UserEntity;
import com.app.rc.GettingStartedWithRestfulAPI.app.ws.respository.UserRepository;
import com.app.rc.GettingStartedWithRestfulAPI.app.ws.service.UserService;
import com.app.rc.GettingStartedWithRestfulAPI.app.ws.shared.Utils;
import com.app.rc.GettingStartedWithRestfulAPI.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptEncoder;

    @Autowired
    Utils util;

    /**
     * @param userRepository
     * @param bCryptEncoder
     */
    @Autowired
    public UserServiceImpl ( UserRepository userRepository,
            BCryptPasswordEncoder bCryptEncoder ) {
        super ( );
        this.userRepository = userRepository;
        this.bCryptEncoder = bCryptEncoder;
    }

    /**
     * FIXME: Data validation missing. Exception handling
     * missing.
     */
    @Override
    public UserDto createUser (
            UserDto user )
    {
        // Response result object //
        UserDto res = new UserDto ( );
        // Define data to be stored to DB //
        UserEntity entity = new UserEntity ( );
        // Prepare data to store and pass as entity //
        BeanUtils.copyProperties (
                user,
                entity );
        /*
         * Additional fields to be added which are not
         * passed by the user but may be used in later for
         * some business logic.
         */
        entity.setEmailStatus (
                true );
        entity.setEmailToken (
                util.generateUserId (
                        32 ) );
        entity.setEncryptedPassword (
                bCryptEncoder.encode (
                        user.getPassword ( ) ) );
        entity.setUserId (
                util.generateUserId (
                        32 ) );
        // Call persistence method to store data //
        UserEntity saved = userRepository.save (
                entity );
        // Prepare resultant object //
        BeanUtils.copyProperties (
                saved,
                res );
        return res;
    }

    @Override
    public UserDto getUserByEmail (
            String email )
    {
        UserDto dto = new UserDto ( );
        UserEntity userEntity = userRepository.findByEmail (
                email );
        if ( userEntity == null ) {
            throw new UsernameNotFoundException ( email );
        }
        BeanUtils.copyProperties (
                userEntity,
                dto );
        return dto;
    }

    /**
     * Used during User Sign-In
     */
    @Override
    public UserDetails loadUserByUsername (
            String email )
            throws UsernameNotFoundException
    {
        UserEntity bean = userRepository.findByEmail (
                email );
        if ( bean == null ) {
            throw new UsernameNotFoundException ( email );
        }
        return new User ( bean.getEmail ( ),
                bean.getEncryptedPassword ( ), true, true,
                true, true, new ArrayList<> ( ) );
    }
}
