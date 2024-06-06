package com.ricodev.springbootsetup.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class InvalidInputsException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> invalidRegistrationInputsHandler(MethodArgumentNotValidException error){
        Map<String ,Object> errorResponse=new HashMap<>();
        error.getBindingResult().getFieldErrors().forEach(e->errorResponse.put(e.getField(),e.getDefaultMessage()));
        return new ResponseEntity<>(errorResponse,HttpStatus.valueOf(400));
    }
}
