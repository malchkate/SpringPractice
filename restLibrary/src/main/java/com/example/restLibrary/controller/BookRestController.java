package com.example.restLibrary.controller;

import com.example.restLibrary.Book;
import com.example.restLibrary.BookRepository;
import com.example.restLibrary.error.BookIdMismatchException;
import com.example.restLibrary.error.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List<Book> getByTitle(@PathVariable String bookTitle){  //todo: The result is unique, isn't it?
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id){
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id){
        if (book.getId() != id){
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }
}
