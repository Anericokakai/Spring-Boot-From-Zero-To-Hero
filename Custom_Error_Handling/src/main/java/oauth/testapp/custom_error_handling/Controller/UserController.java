package oauth.testapp.custom_error_handling.Controller;

import oauth.testapp.custom_error_handling.Exceptions.CustomUserNotFoundException;
import oauth.testapp.custom_error_handling.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    /* Dependency Injection of the service Class
    * No idea check my SpringBoot Dependency Injection
    * * */
   private  final   UserService userService;
//     Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /* We can use @PathVariable annotation to access the id of the user from the path
     * then inside the function pass the name of the path we want to access
     * the path should be inside braces e.g get_user/{id} ,
     * NOTE:
     * use the same name inside the function parameter
     */
    @GetMapping("/get_user/{id}")
    public ResponseEntity<?> findUser(@PathVariable String id)  {

        Object user= userService.checkIfUserExist(id);

        return  new ResponseEntity<>(user, HttpStatus.OK);
    }
}
