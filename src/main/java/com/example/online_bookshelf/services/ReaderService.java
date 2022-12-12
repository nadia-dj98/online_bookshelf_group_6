package com.example.online_bookshelf.services;

import com.example.online_bookshelf.models.Book;
import com.example.online_bookshelf.models.Reader;
import com.example.online_bookshelf.repositories.BookRepository;
import com.example.online_bookshelf.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReaderService {

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    BookRepository bookRepository;

    public List<Reader> displayAllReaders() {
        return readerRepository.findAll();
    }

    public Reader addNewReader(Reader reader) {
        readerRepository.save(reader);
        return reader;
    }

    public void deleteReader(long id) {

        readerRepository.deleteById(id);
    }

    public void updateReaderDetails (long id, String name, String email, LocalDate dateOfBirth){
        Reader reader = readerRepository.findById(id).get();

        reader.setName(name);
        reader.setEmailAddress(email);
        reader.setDateOfBirth(dateOfBirth);

        readerRepository.save(reader);
    }

}
