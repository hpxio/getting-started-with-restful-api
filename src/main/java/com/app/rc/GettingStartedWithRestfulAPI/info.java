
package com.app.rc.GettingStartedWithRestfulAPI;

/**
 * <p>
 * *.app.ws.ui -> Corresponds to the classes which are
 * dealing with the Front-End request/responses. <br/>
 * *.app.ws.shared -> Corresponds to the classes which are
 * dealing within the WS and are only used for DTO/DAO
 * purposes.
 * </p>
 * <p>
 * <ol>
 * <li>Controller</li>
 * <li>Model</li>
 * <li>RestModel</li>
 * <li>Service</li>
 * <li>ServiceImplementation</li>
 * <li>Repository</li>
 * <li>Entity</li>
 * <li>Security</li>
 * <li>Configuration</li>
 * </ol>
 * </p>
 * <p>
 * Controller - Receives Request model and sends out
 * response model<br/>
 * Service - Actual implementation of business logic.
 * Receives DTO. <br/>
 * Repository - Data persistence module. Receives Entity and
 * may send out DTO.<br/>
 * Entity - Data table representation in terms of Java POJO.
 * </p>
 * <p>
 * <b>Flow</b><br/>
 * Front Controller(sends ui.UserModel) -> Controller ->
 * Service (uses shared.UserDto) -> Repository(needs
 * UserEntity, sends UserDto) -> Service (fills UserDto) ->
 * Controller (sends UserRest)
 * </p>
 * 
 * @author iHSPA
 */
public class info {

}
