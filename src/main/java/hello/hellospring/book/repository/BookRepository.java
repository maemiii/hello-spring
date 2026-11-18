package hello.hellospring.book.repository;

import hello.hellospring.book.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);

    Optional<Book> findByTitle(String title);

    List<Book> findAll();
}
