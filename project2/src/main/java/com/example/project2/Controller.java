package com.example.project2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class Controller {

//    @Autowired
//    private RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(Controller.class);

    private BookRepository repository;

    public Controller (BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getBooks")
    public Iterable<Book> getAllBooks() {
        logger.info("Get all books in repository.");
        return repository.findAll();
    }

    @GetMapping("/getBook/{bookId}")
    public Book getBookById(@PathVariable Long bookId){
        logger.info("Get book by ID.");
        return repository.findById(bookId)
                .orElseThrow( () -> new BooksException("No books with id:" + bookId));
    }

    @GetMapping("/getBookTitle/{bookName}")
    public Book getBookByTitle(@PathVariable String bookName) {
        logger.info("Get book by title.");
        return repository.findByBookName(bookName).orElseThrow( ()-> new BooksException("No book with title: " + bookName));
    }

    @PostMapping("/addBook")
    public Book create(@RequestBody Book book) {
       logger.info("Book added to repository.");
        //book.setDate(LocalDate.now());
        return repository.save(book);
    }

    @DeleteMapping("/removeBook/{bookId}")
    public void delete(@PathVariable Long bookId){
        logger.info("Book removed from repository.");
        repository.deleteById(bookId);
    }

    @PutMapping("/updateBook/{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long bookId){
        logger.info("Book updated.");
        return repository.findById(bookId).map(storedBook -> {
            storedBook.setBookName(book.getBookName());
            storedBook.setDescription(book.getDescription());
            return repository.save(storedBook);
        }).orElseThrow( () -> new BooksException("No book with following ID: " + bookId));
    }
    

}
