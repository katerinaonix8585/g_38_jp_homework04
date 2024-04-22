package app.controller;

import app.domain.Book;
import app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookController {
    @Autowired
    private BookService service;


    public Book getById(Long id) {
        return service.getById(id);
    }
}
