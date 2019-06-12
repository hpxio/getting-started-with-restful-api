
package com.app.rc.GettingStartedWithRestfulAPI.app.ws.ui.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.rc.GettingStartedWithRestfulAPI.app.logging.InitLogging;
import com.app.rc.GettingStartedWithRestfulAPI.app.ws.service.UserService;
import com.app.rc.GettingStartedWithRestfulAPI.app.ws.shared.dto.UserDto;
import com.app.rc.GettingStartedWithRestfulAPI.app.ws.ui.model.request.UserModel;
import com.app.rc.GettingStartedWithRestfulAPI.app.ws.ui.model.response.UserRest;


/**
 * DispatcherServlet will lookup to the listeners/URI
 * mapping in these classes. Controller simply takes a input
 * object coming in form of JSON/XML and convert it into a
 * Java object. Then using a DTO object the persistence
 * module will simply save the state of the resource to DB.
 * The result of which can be returned using either object
 * in form of JSON/XML or in a plain text.
 * 
 * @author iHSPA
 */
@RestController
@RequestMapping ( "/user" )
public class UserController {

    @Autowired
    UserService userService;

    InitLogging logger = new InitLogging ( );

    /**
     * Steps
     * <ol>
     * <li>Create an object to hold the results</li>
     * <li>Create another object for DTO and copy the
     * incoming request payload</li>
     * <li>Call the service and store the result of the
     * service to another object placeholder</li>
     * <li>Copy the data from the placeholder to the result
     * object</li>
     * </ol>
     * 
     * @URL
     * 
     *      <pre>
               POST /user
                Content-Type: application/json
                User-Agent: PostmanRuntime/7.13.0
                Cache-Control: no-cache
                Postman-Token: 130b5bdb-935e-4419-9186-5658264dfd55
                Host: localhost:8089
                accept-encoding: gzip, deflate
                content-length: 117
                Connection: keep-alive
                { "name": "sam", "username": "sam1998", "email": "sam.gosling@gmail.com", "password": "837ydviv893" }
     *      </pre>
     * 
     * @param userBean
     * @return
     */
    @PostMapping
    public UserRest create (
            @RequestBody UserModel userBean ) {


        logger.LOG
                .info ( "Controller - Create User Hit..." );

        // Step-1 - Define result and shared object
        UserRest res = new UserRest ( ); // Result Object
        UserDto dto = new UserDto ( ); // Shared Object

        logger.LOG.info (
                "Controller - Create User - Step-2..." );
        // Step-2 - Prepare shared object
        BeanUtils.copyProperties ( userBean, dto );

        logger.LOG.info (
                "Controller - Create User - Step-3..." );
        // Step-3 - Call service logic
        UserDto createdData = userService
                .createUser ( dto );

        logger.LOG.info (
                "Controller - Create User - Step-4..." );
        // Step-4 - Prepare result object
        BeanUtils.copyProperties ( createdData, res );

        logger.LOG.info (
                "Controller - Create User Done..." );
        return res;
    }

    public void remove ( ) {

    }

    public void update ( ) {

    }

    public void display ( ) {

    }
}
