package com.example.restLibrary.controller;

import com.example.restLibrary.Book;
import com.example.restLibrary.BookRepository;
import com.example.restLibrary.BookResourceAssembler;
import com.example.restLibrary.error.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
public class BookRestController {
    private final BookRepository bookRepository;
    private final BookResourceAssembler bookResourceAssembler;

    @GetMapping("/books")
    public Resources<Resource<Book>> getAllBooks(){
        List<Resource<Book>> books = bookRepository.findAll().stream()
                .map(bookResourceAssembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(books,
                linkTo(methodOn(BookRestController.class).getAllBooks()).withSelfRel());
    }

    @GetMapping("/books/title/{bookTitle}")
    public List<Book> getByTitle(@PathVariable String bookTitle){  //todo: The result is unique, isn't it?
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/books/{id}")
    public Resource<Book> getById(@PathVariable Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return bookResourceAssembler.toResource(book);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book newBook){
        return bookRepository.save(newBook);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book newBook, @PathVariable Long id){
        return bookRepository.findById(id)
                .map(book -> {
                    book.setAuthor(newBook.getAuthor());
                    book.setTitle(newBook.getTitle());
                    return bookRepository.save(book);
                })
                .orElseGet(() ->{
                    newBook.setId(id);
                    return bookRepository.save(newBook);
                });
    }
}
