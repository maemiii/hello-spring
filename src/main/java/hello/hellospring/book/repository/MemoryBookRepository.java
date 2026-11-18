package hello.hellospring.book.repository;

import hello.hellospring.book.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryBookRepository implements BookRepository {
    private static Map<Long, Book> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Book save(Book book) {
            book.setId(++sequence);
            store.put(book.getId(), book);
        return book;
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return store.values().stream()
                .filter(b -> b.getTitle().equals(title))
                .findAny();
    }

    @Override
    public List<Book> findAll() {
        return store.values().stream()
                .sorted(Comparator.comparingLong(Book::getId))
                .toList();
    }
}
