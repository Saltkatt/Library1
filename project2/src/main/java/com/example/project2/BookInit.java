package com.example.project2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class BookInit {

    @Bean
    public CommandLineRunner initDatabase(BookRepository repository) {
        return args -> init(repository);
    }

    public void init(BookRepository repository) {

        LocalDateTime dateTime = LocalDateTime.now();
        repository.save(new Book("Harry Potter", "Magic School", dateTime));
        repository.save(new Book("Matilda", "A little girl with a powerful mind", dateTime));
        repository.save(new Book("Miss Marple", "Old lady solving mystries", dateTime));


    }


}
