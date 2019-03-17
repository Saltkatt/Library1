package com.example.project2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BooksNotFoundAdvice {

    @ExceptionHandler(BooksException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String booksNotFound(BooksException exception) {
        return exception.s;
    }

}
