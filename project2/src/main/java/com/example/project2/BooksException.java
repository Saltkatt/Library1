package com.example.project2;

public class BooksException extends RuntimeException {

    String s;

    public BooksException(String s){
        this.s = s;
    }
}