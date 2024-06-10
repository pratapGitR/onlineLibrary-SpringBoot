package com.onlinelearning.onlinelibrary.repo;

import com.onlinelearning.onlinelibrary.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    List<Book> findByBookTitleContainingIgnoreCase(String bookTitle);
//    List<Book> findByRentedIsTrue();
//    List<Book> findByRentedIsFalse();

    List<Book>findByIsRentedTrue();
    List<Book>findByIsRentedFalse();

}