package com.curso.workshopmongo.services.exception;

public class ObjectNOtFoundExcecption extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public ObjectNOtFoundExcecption(String msg){
        super(msg);
    }
}
