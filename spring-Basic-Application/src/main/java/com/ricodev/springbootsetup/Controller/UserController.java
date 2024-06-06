package com.ricodev.springbootsetup.Controller;

import com.ricodev.springbootsetup.Dto.UserLoginDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
//  <------!GET REQUEST EXAMPLE----->
@GetMapping("/get_info")
public  String getUserInfo(){
    return  "Hello im the user";
}

//    <--! POST REQUEST EXAMPLE---->
@PostMapping("/login")
public String logInUser(@RequestBody UserLoginDto userInfo){
    System.out.println("<-----Example of a post request------> ".toUpperCase());
//Acccess the values  and print them
        System.out.println("\n Name :\t "+userInfo.getName()+"\n Email :\t "+userInfo.getEmail()+"\n Password :\t "+userInfo.getPassword());
        return  "user received ";
    }

}
