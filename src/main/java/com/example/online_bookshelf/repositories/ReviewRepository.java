package com.example.online_bookshelf.repositories;

import com.example.online_bookshelf.models.Book;
import com.example.online_bookshelf.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByBook(Book book);

}
