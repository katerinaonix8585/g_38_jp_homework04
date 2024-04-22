package app.repository;

import app.domain.Book;
import app.service.BookServiceImpl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepositoryMap implements BookRepository{

    private Map<Long, Book> database = new HashMap<>();

    public BookRepositoryMap() {
        database.put(1L, new Book(1L, "А.С. Пушкин", "Евгений Онегин", 2000));
        database.put(2L, new Book(2L, "М.Ю. Лермонтов", "Мцыри", 2001));
        database.put(3L, new Book(3L, "Н.В. Гоголь", "Мертвые души", 2002));
    }
    @Override
    public Book getById(Long id) {
        return database.get(id);
    }
}
