
package com.app.rc.GettingStartedWithRestfulAPI.app.ws.respository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.app.rc.GettingStartedWithRestfulAPI.app.ws.io.entity.UserEntity;


@Repository
public interface UserRepository
        extends
            CrudRepository< UserEntity, Long > {

    /**
     * Find the record by EMAIL. FIXME: Description missing.
     * 
     * @param email
     * @return
     */
    UserEntity findByEmail ( String email );

}
