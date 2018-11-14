package com.example.restLibrary.error;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(Long id){
        super("Couldn't find book with id " + id);
    }
}
