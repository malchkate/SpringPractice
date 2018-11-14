package com.example.restLibrary;

import com.example.restLibrary.controller.BookRestController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@Component
public class BookResourceAssembler implements ResourceAssembler<Book, Resource<Book>> {

    @Override
    public Resource<Book> toResource(Book book){
        return new Resource<>(book,
                linkTo(methodOn(BookRestController.class).getById(book.getId())).withSelfRel(),
                linkTo(methodOn(BookRestController.class).getAllBooks()).withRel("books"));
    }
}
