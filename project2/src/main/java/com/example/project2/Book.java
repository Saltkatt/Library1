package com.example.project2;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Book {

    private @Id @GeneratedValue Long bookId;
    private @NonNull String bookName;
    private @NonNull String description;
    private java.time.LocalDateTime dateTime;


}
