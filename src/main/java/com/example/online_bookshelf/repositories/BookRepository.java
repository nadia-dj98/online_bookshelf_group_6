package com.example.online_bookshelf.repositories;

import com.example.online_bookshelf.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
