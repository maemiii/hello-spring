package hello.hellospring.book.controller;

import hello.hellospring.book.Book;
import hello.hellospring.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/new")
    public String createForm() {
        return "books/createBookForm";
    }

    @PostMapping("/books/new")
    public String create(BookForm form) {
        Book book = new Book();
        book.setAuthor(form.getAuthor());
        book.setTitle(form.getTitle());

        bookService.register(book);

        return "redirect:/";
    }

    @GetMapping("/books")
    public String list(Model model) {
        List<Book> books = bookService.findBooks();
        model.addAttribute("books", books);
        return "books/bookList";
    }
}
