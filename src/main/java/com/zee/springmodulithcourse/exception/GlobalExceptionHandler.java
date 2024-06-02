package com.zee.springmodulithcourse.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 02 Jun, 2024
 */

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Map<String, List<String>>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        return new ResponseEntity<>(getErrorMap(fieldErrors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ModulithException.class)
    public ResponseEntity<Response> handleModulithException(ModulithException ex){
        return new ResponseEntity<>(new Response(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> handleModulithException(RuntimeException ex){
        return new ResponseEntity<>(new Response(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }


    private Map<String, List<String>> getErrorMap(List<String> fieldErrors){
        Map<String, List<String>> errorMap = new HashMap<>();
        errorMap.put("errors", fieldErrors);
        return errorMap;
    }
}
