package app.service;

import app.domain.Book;
import app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

private String ISBNPrefix = "978";
private int ISBNidGroup = 3;
private BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book getById(Long id) {
        return null;
    }

    @Override
    public void assingISBN(Book book) {
        String ISBN = String.format("%s-%d-%s", ISBNPrefix, ISBNidGroup, book.getCodePublication());
        book.setIsbn(ISBN);

    }
}
