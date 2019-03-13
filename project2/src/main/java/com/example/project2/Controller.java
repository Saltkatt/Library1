package com.example.project2;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/library")
public class Controller {

//    @Autowired
//    private RestTemplate restTemplate;

    private BookRepository repository;

    List<Book> bookList = Arrays.asList(
            new Book("Harry Potter", "Wizards, Witches and Kneezles"),
            new Book("The Lion, the Witch and the Wardrobe", "Aslan"),
            new Book("Matilda", "Little girl with a big brain")
    );

    public Controller (BookRepository repository) {
        this.repository = repository;

    }
//    @GetMapping("/books")
//    public List<Book> getBookList(){
//        return bookList;
//    }

    @GetMapping("/books")
    public List<Book> getAll() {
        return repository.findAll();
    }

    @GetMapping("/book/{bookId}")
    public Book getOne(@PathVariable Long bookId){
        return repository.findById(bookId)
                .orElseThrow( () -> new BooksException("No books with id:" + bookId));
    }

    @PostMapping("/makebook")
    public Book create(@RequestBody Book book) {
        return repository.save(book);
    }

    @DeleteMapping("/removebook{bookId}")
    public void delete(@PathVariable Long bookId){
        repository.deleteById(bookId);
    }

    @PutMapping("/updatebook{bookId}")
    public Book change(@RequestBody Book book, @PathVariable Long bookId){
        return repository.findById(bookId).map(storedBook -> {
            storedBook.setBookName(book.getBookName());
            storedBook.setDescription(book.getDescription());
            return repository.save(storedBook);
        }).orElseThrow( () -> new BooksException("No book with id: " + bookId));
    }

}
