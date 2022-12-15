package com.example.online_bookshelf.repositories;

import com.example.online_bookshelf.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
        List<Author> findByNameContainingIgnoreCase(String likeString);



}
