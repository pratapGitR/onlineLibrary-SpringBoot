package com.onlinelearning.onlinelibrary.service;

import com.onlinelearning.onlinelibrary.dto.Book;
import com.onlinelearning.onlinelibrary.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public Book addBook(Book book){
        return bookRepo.save(book);
    }
    public List<Book>findAllBooks(){
        return bookRepo.findAll();
    }
    public List<Book>findByBookTitle(String bookTitle){
        return bookRepo.findByBookTitleContainingIgnoreCase(bookTitle);
    }
    public List<Book>rentedBooks(){
        return bookRepo.findByRentedIsTrue();
    }
    public List<Book>availableBooks(){
        return bookRepo.findByRentedIsFalse();
    }
}
