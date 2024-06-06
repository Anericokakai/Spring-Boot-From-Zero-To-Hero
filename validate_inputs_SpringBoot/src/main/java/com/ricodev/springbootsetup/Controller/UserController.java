package com.ricodev.springbootsetup.Controller;

import com.ricodev.springbootsetup.Dto.UserLoginDto;
import jakarta.validation.Valid;
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

/*use the @Valid annotation for the validation to work*/
public ResponseEntity<?> getUserInfo( @Valid @RequestBody UserLoginDto user){
//hash map for the response
    Map<String,Object> resBody=new HashMap<>();
    resBody.put("message","User registration was a success");
    resBody.put("responseStatus","200");
    resBody.put("user",user);
    return  new ResponseEntity<>(resBody, HttpStatus.valueOf(200));

}

}
