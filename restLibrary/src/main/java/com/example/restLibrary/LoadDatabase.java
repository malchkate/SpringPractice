package com.example.restLibrary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository){
        return args -> {
            log.info("Preloading: " + bookRepository.save(new Book("Kill the mocking bird", "Harper Lee")));
            log.info("Preloading: " + bookRepository.save(new Book("Billy", "Anna Gavalda")));
        };
    }
}
