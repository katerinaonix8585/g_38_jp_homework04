package app.service;

import app.domain.Book;
import app.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

private String ISBN;
private BookRepository repository;

    public BookServiceImpl(String ISBN, BookRepository repository) {
        this.ISBN = ISBN;
        this.repository = repository;
    }

    @Override
    public Book getById(Long id) {
        return null;
    }

    @Override
    public void assingISBN(Book book) {

    }
}
