package com.example.demo;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class Exception11 {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFound() {
        System.out.println("heeeey");
        return "Route inexistant";
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handler2(){
        return "erreur";
    }



    @ExceptionHandler(Exception.class)
    public String handle(Exception e) {

        System.out.println(e.getMessage());
        return "en generale erreur";

    }
}
