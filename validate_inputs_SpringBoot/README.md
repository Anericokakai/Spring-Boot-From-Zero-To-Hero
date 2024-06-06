# Validation of Inputs in Spring boot
The controller should not be responsible for handling errors or validating inputs, this breaks the Single Responsibility Principle
[SOLID principles](https://blogs.oracle.com/javamagazine/post/curly-braces-java-solid-design) by Eric J. Bruno. A class should have single responsibility only .The cotroller 
should only be a handler for the request and response .

To validate inputs in springboot we will use a dependency called ``Spring--boot-stater-validation``, this dependency has most of the checks performed internally
we only need to annotate our inputs with the in-built validators

### Adding the Validation Dependency
Navigate to the ``pom.xml`` and inside the dependencies add this dependency
```xml

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>

```
reload the maven for the changes to apply , 
When you go to your ``Dto`` folder you need to add annotations just above the fields you want to validate


# custom Exception Handlers
## @RestControllerAdvice
Spring handle all ``RestController``  errors using the ``@RestControllerAdvice`` including the validation error ``MethodArgumentNotValidException``
by default spring returns a 400 status when validation fails but with nothing useful. 

#### Example
![bad example of a response](/images/resError.png)
Nothing Shows in our response that we had a weak password and the front end developers have no idea what has happened,to handle this we need a class to handle this time of exception
If you don't have an idea of the type of exception you need to handle checkout the console after making request
![console image](/images/console.png)
the exception that we need to handle is the ``MehtodArgumentNotValidException`` .To handle this exception we have to create an exception package where all our exceptions will be, your folder structure should be similar to this
![folder structure](/images/folder.png)
inside our Exception package we have a class called ``InvalidInputsException`` which we are going to use in handling  exceptions thrown while validating inputs

## How to create a custom Exception Handler
For this to happen we annotate the ``InvalidInputException`` with ``@RestControllerAdvice`` annotation, this tells spring boot that when an exception is thrown Spring will check inside this class is the exception is being handled.
inside the class you can define as many exceptions as you want as long as they are being thrown by the application. Example
```java
package com.ricodev.springbootsetup.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/* annotate with  restController advice*/
@RestControllerAdvice
public class InvalidInputsException {
    /* @ExceptionHandler with the exception class we want to handle as params
     * the  method returns a response Entity takes in MethodArgumentNotValidException as a parameter
     * the hashmap allows us to return a json response to the front end
     * 
     * The error thrown by the MethodArgumentNotValidException we access the BindingResults 
     * and the FieldErrors which is an arrayList of Objects we access the field names to be our key and default message 
     * to be our value in our json
     * 
     * */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> invalidRegistrationInputsHandler(MethodArgumentNotValidException error){
        Map<String ,Object> errorResponse=new HashMap<>();
        error.getBindingResult().getFieldErrors().forEach(e->errorResponse.put(e.getField(),e.getDefaultMessage()));
        return new ResponseEntity<>(errorResponse,HttpStatus.valueOf(400));
    }
}
```
If you dont know anything about response Entity checkout [handling httpResponse in Spring Boot](https://anericokakai.tech/blogs/spring-boots/handling-http-response-in-spring-boot)

# how to validate the Inputs
To validate the inputs we only use annotations above our **Dto ** entries. Some of the available annotations are:-
1. @Email -> Used to validate email adress;
2. @Size(min=itn,max=int) used to validate the size of a string .You can use either min or max or combine both
3. @Pattern(regExp="your regular Expression ") used to validate  strong password or inputs that should follow a certain order e.g phoneNumber
4. @Min(int) and @Max(int) used to validate integers eg age 
5. @NotEmpty validate that the input is not empty
There are many more annotation that you can use but these are the major ones.
### setting Default message
by default the error message thrown by these validations are not that understandable to people. We can pass the default message that we want the exception to display when a validation fails
.We just need to pass message as an argument in the annotation
```java
  @Email(message = "Invalid email address, please provide a valid email")
    private String  email;

@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$"
        ,message = "Weak password,password should be  at least 8 characters and " +
        "contain at least a digit,an uppercase special character ")
private String  password;
```
For This  validations to work in the controller where we are using the Dto we need to pass the 
``@Valid`` as our first argument in the method .and that's it. 
## Dto Code example
```java
package com.ricodev.springbootsetup.Dto;

import jakarta.validation.constraints.*;

public class UserLoginDto {
//    add validations to our dto

    @NotBlank (message = "Name field is required")
    private String name;
    @Email(message = "Invalid email address, please provide a valid email")
    private String  email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$"
            ,message = "Weak password,password should be  at least 8 characters and " +
            "contain at least a digit,an uppercase special character ")
    private String  password;

//    Constructors
    public UserLoginDto() {
    }
//    Getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

```
## Controller code Example
```java
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

```
Congratulations ! You have already handled exceptions and validated inputs at the same time. Now when we make a request with invalid input we are going to have  an error message explaining what happened and how we can resole it.


![correct error response](/images/ErrorCorrect.png)





