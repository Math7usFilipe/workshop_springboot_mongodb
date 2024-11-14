package com.curso.workshopmongo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.curso.workshopmongo.services.exception.ObjectNOtFoundExcecption;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResoruceExceptionHandler {

    @ExceptionHandler(ObjectNOtFoundExcecption.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNOtFoundExcecption e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Nao encontrado", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

}
