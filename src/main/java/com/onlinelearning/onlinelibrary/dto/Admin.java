package com.onlinelearning.onlinelibrary.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity(name = "Admin")
@Component
@Getter
@Setter
@RequiredArgsConstructor

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    @Column
    private String adminName;

    @Column
    private String adminPassword;

}
