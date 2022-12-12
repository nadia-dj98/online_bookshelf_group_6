package com.example.online_bookshelf.repositories;

import com.example.online_bookshelf.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
