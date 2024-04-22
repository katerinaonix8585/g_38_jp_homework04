package app.domain;

import java.util.Objects;

public class Book {
    private Long id;
    private String isbn;
    private String author;
    private String title;
    private int yearPublication;
    private String codePublication;

    public Book(Long id, String author, String title, int yearPublication, String codePublication) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.yearPublication = yearPublication;
        this.codePublication = codePublication;
    }

    public String getCodePublication() {
        return codePublication;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearPublication == book.yearPublication && Objects.equals(id, book.id) && Objects.equals(isbn, book.isbn) && Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, author, title, yearPublication);
    }

    @Override
    public String toString() {
        return String.format("Книга: ISBN - %s, автор - %s, название - %s, год выпуска - %d", isbn, author, title, yearPublication );
    }
}
