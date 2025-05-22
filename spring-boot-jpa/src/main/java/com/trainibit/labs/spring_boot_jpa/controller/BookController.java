package com.trainibit.labs.spring_boot_jpa.controller;

import com.trainibit.labs.spring_boot_jpa.model.Book;
import com.trainibit.labs.spring_boot_jpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //Create new book
    @PostMapping("/addBook")
    public ResponseEntity<Book>createBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
    //Get All Books
    @GetMapping("/getBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    //Get book by ID
    @GetMapping("/getBook/{id}")
    public ResponseEntity<Book>getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
    //Update a book
    @PutMapping("/deleteBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return null;
    }

}
