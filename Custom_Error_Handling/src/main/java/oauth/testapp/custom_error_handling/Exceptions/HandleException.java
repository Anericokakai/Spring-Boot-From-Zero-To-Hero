package oauth.testapp.custom_error_handling.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//@RestControllerAdvice
public class HandleException {
    @ExceptionHandler(CustomUserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,Object> handleUserNotFound(CustomUserNotFoundException e){
        Map<String ,Object> errorResponse= new HashMap<>();
        errorResponse.put("error",e.getMessage());
        errorResponse.put("message","Try providing a valid user id");
        return  errorResponse;
    }
}
