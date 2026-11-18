package hello.hellospring.book.service;

import hello.hellospring.book.Book;
import hello.hellospring.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Long register(Book book) {
        validDuplicateBook(book);
        bookRepository.save(book);
        return book.getId();
    }

    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    private void validDuplicateBook(Book book) {
        bookRepository.findByTitle(book.getTitle())
                .ifPresent(b -> {
                    throw new IllegalStateException("이미 존재하는 책입니다.");
                });
    }
}
