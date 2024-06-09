package oauth.testapp.custom_error_handling.Service;

import oauth.testapp.custom_error_handling.Exceptions.CustomUserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    Map<String ,String> users= new HashMap<>();

    public  Object  checkIfUserExist(String  id) {
        users.put("1","Anerico kakai");
        users.put("2","John Doe");
        users.put("3","eddy");
        users.put("4","mesh");

//        access the user by id


        if(users.get(id)==null) {
            System.out.println("empty user".toUpperCase());
//         throw exception
         throw  new CustomUserNotFoundException("user not found");

        }
        return  users.get(id);

    }
}
