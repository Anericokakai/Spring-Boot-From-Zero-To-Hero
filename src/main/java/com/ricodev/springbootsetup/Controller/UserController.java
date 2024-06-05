package com.ricodev.springbootsetup.Controller;

import com.ricodev.springbootsetup.Dto.UserLoginDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
//  <------!GET REQUEST EXAMPLE----->
@PostMapping("/get_info")

public ResponseEntity<?> getUserInfo(@RequestBody UserLoginDto user){
//hash map for the response
    Map<String,Object> resBody=new HashMap<>();

/*
if the name does not exit we return a different response status code
 */
    String  name =user.getName();

    if(name==null||name.isEmpty()){
        /*`
        return a json response that explains in details
        We use hash map
         */
        resBody.put("error","invalid request,name is a requirement");
        resBody.put("errorStatus","400");
       return  new ResponseEntity<>(resBody,HttpStatus.BAD_REQUEST);
    }
//    else return a different status code
    resBody.put("message","User registration was a success");
    resBody.put("responseStatus","200");
    resBody.put("user",user);

//    headers
    HttpHeaders headers=new HttpHeaders();
    headers.add("Bearer","token23404ry9437401379137edysud");
    return  new ResponseEntity<>(resBody,headers, HttpStatus.valueOf(200));

}




}
