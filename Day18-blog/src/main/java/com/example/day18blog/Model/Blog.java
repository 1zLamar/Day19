package com.example.day18blog.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title shouldn't be null")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @NotEmpty(message = "category shouldn't be null")
    @Column(columnDefinition = "varchar(15) not null check(category='health' or category= 'education' or category= 'programming')")
    private String category;

    @NotNull(message = "body shouldn't be null")
    @Column(columnDefinition = "varchar(300) not null")
    @Size(min=3,max = 300,message = "size must be between 3-300")
    private String body;

    @NotNull(message = "body shouldn't be null")
    @Column(columnDefinition = "boolean default false")
    private boolean isPublished;



}
