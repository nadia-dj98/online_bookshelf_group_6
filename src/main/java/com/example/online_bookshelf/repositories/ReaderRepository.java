package com.example.online_bookshelf.repositories;

import com.example.online_bookshelf.models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
