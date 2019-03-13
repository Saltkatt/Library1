package com.example.project2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class BookInit {

    @Bean
    public CommandLineRunner initDatabase(BookRepository repository) {
        return args -> init(repository);
    }

    public void init(BookRepository repository) {

        LocalDate date = LocalDate.now();
        repository.save(new Book("Harry Potter", "Magic School", date));
        repository.save(new Book("Matilda", "A little girl with a powerful mind", date));
        repository.save(new Book("Miss Marple", "Old lady solving mystries", date));


    }


}
