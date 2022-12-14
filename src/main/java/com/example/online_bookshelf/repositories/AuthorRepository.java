package com.example.online_bookshelf.repositories;

import com.example.online_bookshelf.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
