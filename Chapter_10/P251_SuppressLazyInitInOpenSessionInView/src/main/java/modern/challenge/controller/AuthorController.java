package modern.challenge.controller;

import modern.challenge.service.BookstoreService;
import java.util.Collections;
import modern.challenge.entity.Author;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private final BookstoreService bookstoreService;

    public AuthorController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    // Open Session In View will "force" lazy initialization of books
    @RequestMapping("/fetchlazy")
    public Author authorWithBooksLazyInitialized() {

        Author author = bookstoreService.fetchAuthor();

        return author;
    }

    // Open Session In View will NOT "force" lazy initialization of books
    @RequestMapping("/fetchnolazy")
    public Author authorWithoutBooks() {

        Author author = bookstoreService.fetchAuthor();

        // explicitly set Books of the Author
        // in order to avoid fetching them from the database
        author.setBooks(Collections.emptyList());

        return author;
    }
}
