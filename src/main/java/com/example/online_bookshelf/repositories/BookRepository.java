package com.example.online_bookshelf.repositories;

import com.example.online_bookshelf.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByGenre(String genre);

    List<Book> findByAgeRatingLessThanEqual(int readerAge);
}
