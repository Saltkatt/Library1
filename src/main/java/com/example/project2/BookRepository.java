package com.example.project2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository <Book, Long> {

    Optional<Book> findByBookName(String bookName);
}
