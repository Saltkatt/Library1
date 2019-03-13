package com.example.project2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/books")
    public List<Book> getAll() {
        logger.info("get all books in repository");
        return repository.findAll();
    }

    @GetMapping("/book/{bookId}")
    public Book getOne(@PathVariable Long bookId){
        logger.info("get one book from repository");
        return repository.findById(bookId)
                .orElseThrow( () -> new BooksException("No books with id:" + bookId));
    }

    @PostMapping("/addbook")
    public Book create(@RequestBody Book book) {
       logger.info("add book to repository");
        return repository.save(book);
    }

    @DeleteMapping("/removebook{bookId}")
    public void delete(@PathVariable Long bookId){
        logger.info("remove a book from repository");
        repository.deleteById(bookId);
    }

    @PutMapping("/updatebook{bookId}")
    public Book change(@RequestBody Book book, @PathVariable Long bookId){
        logger.info("update book in repository");
        return repository.findById(bookId).map(storedBook -> {
            storedBook.setBookName(book.getBookName());
            storedBook.setDescription(book.getDescription());
            return repository.save(storedBook);
        }).orElseThrow( () -> new BooksException("No book with id: " + bookId));
    }

}
