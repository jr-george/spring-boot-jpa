package com.trainibit.labs.spring_boot_jpa.service;

import com.trainibit.labs.spring_boot_jpa.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBooks();
    ResponseEntity<Book> getBookById(Long id);
    ResponseEntity<Book> updateBook(Long id, Book bookDetails);
    void deleteBook(Long id);
}
