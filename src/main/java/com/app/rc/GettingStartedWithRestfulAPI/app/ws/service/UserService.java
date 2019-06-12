
package com.app.rc.GettingStartedWithRestfulAPI.app.ws.service;


import org.springframework.security.core.userdetails.UserDetailsService;


import com.app.rc.GettingStartedWithRestfulAPI.app.ws.shared.dto.UserDto;


public interface UserService extends UserDetailsService {

    UserDto createUser ( UserDto user );
}

