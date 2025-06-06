package com.trainibit.labs.spring_boot_jpa.service.impl;

import com.trainibit.labs.spring_boot_jpa.model.Book;
import com.trainibit.labs.spring_boot_jpa.repository.BookRepository;
import com.trainibit.labs.spring_boot_jpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public ResponseEntity<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public ResponseEntity<Book> updateBook(Long id, Book bookDetails) {
       Book book=bookRepository.findById(id).orElseThrow();
       book.setTitle(bookDetails.getTitle());
       book.setAuthor(bookDetails.getAuthor());
       book.setPrice(bookDetails.getPrice());
       return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
