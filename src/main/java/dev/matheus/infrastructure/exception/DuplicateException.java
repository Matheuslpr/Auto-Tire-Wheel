package dev.matheus.infrastructure.exception;

public class DuplicateException extends RuntimeException {

    public DuplicateException(String message){
        super(message);
    }
}
