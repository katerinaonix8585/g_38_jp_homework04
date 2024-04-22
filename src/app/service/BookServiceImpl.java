package app.service;

import app.domain.Book;
import app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class BookServiceImpl implements BookService{

private String ISBNPrefix;
private String ISBNidGroup;
private BookRepository repository;

    public BookServiceImpl(
            @Value("${ISBN.prefix}") String ISBNPrefix,
            @Value("${ISBN.group}") String ISBNidGroup,
            @Qualifier("bookRepositoryMap") BookRepository repository) {
    this.ISBNPrefix = ISBNPrefix;
    this.ISBNidGroup = ISBNidGroup;
    this.repository = repository;
    }

    @Override
    public Book getById(Long id) {
        Book book = repository.getById(id);
        assingISBN(book);
        return book;
    }

    @Override
    public void assingISBN(Book book) {
        String ISBN = String.format("%s-%s-%s", ISBNPrefix, ISBNidGroup, book.getCodePublication());
        book.setIsbn(ISBN);

    }
}
