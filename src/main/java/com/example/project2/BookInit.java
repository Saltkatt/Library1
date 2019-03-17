package com.example.project2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * List of books and descriptions
 */
@Configuration
public class BookInit {

    @Bean
    public CommandLineRunner initDatabase(BookRepository repository) {
        return args -> init(repository);
    }

    public void init(BookRepository repository) {


        repository.save(new Book("Harry Potter", "Magic School"));
        repository.save(new Book("Matilda", "A little girl with a powerful mind"));
        repository.save(new Book("Miss Marple", "Old lady solving mystries"));


    }


}
