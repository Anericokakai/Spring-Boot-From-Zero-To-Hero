package com.ricodev.springbootsetup.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
//  !GET REQUEST EXAMPLE
@GetMapping("/get_info")
public  String getUserInfo(){
    return  "Hello im the user";
}

//    ! POST REQUEST EXAMPLE
    @PostMapping("/login")
    public String logInUser(@RequestBody String name){
        System.out.println("<---------Example of a post request----------> ".toUpperCase());
        System.out.println("\n Name :\t "+name);
        return  "user received ";
    }

}
