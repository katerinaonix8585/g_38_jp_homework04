package app.service;

import app.domain.Book;

public interface BookService {

    Book getById(Long id);

   void assingISBN(Book book);
}
