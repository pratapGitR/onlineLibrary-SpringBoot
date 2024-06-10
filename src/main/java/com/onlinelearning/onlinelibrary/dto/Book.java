package com.onlinelearning.onlinelibrary.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity(name = "Book")
@Component
@Getter
@Setter
@RequiredArgsConstructor
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(name = "book_title")
    private String bookTitle;

    @Column
    private boolean isRented;
}
