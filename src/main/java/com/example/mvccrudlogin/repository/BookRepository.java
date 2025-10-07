package com.example.mvccrudlogin.repository;

import com.example.mvccrudlogin.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { }
