package com.onlinelearning.onlinelibrary.controller;

import com.onlinelearning.onlinelibrary.dto.Book;
import com.onlinelearning.onlinelibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(Book book){
        return ResponseEntity.ok(bookService.addBook(book));
    }
    @GetMapping("/findAllBooks")
    public ResponseEntity<List<Book>> findAllBooks(){
        return ResponseEntity.ok(bookService.findAllBooks());
    }
    @GetMapping("/availableBooks")
    public ResponseEntity<List<Book>> availableBooks(){
        return ResponseEntity.ok(bookService.availableBooks());
    }
    @GetMapping("/rentedBooks")
    public ResponseEntity<List<Book>> rentedBooks(){
        return ResponseEntity.ok(bookService.rentedBooks());
    }
}
