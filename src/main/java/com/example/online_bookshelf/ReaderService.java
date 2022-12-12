package com.example.online_bookshelf;

import com.example.online_bookshelf.models.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReaderService {

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    BookService bookService;

    @Autowired
    ReaderService readerService;

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

    public Reader addBookToCollection(long readerId, long readerId){
        Reader reader = readerRepository.findById(readerId).get();
        Book book = bookService.getReaderById(readerId);
        List<Book> books = reader.getReaders();
        readers.add(reader);
        reader.setReaders(books);
        readerRepository.save(reader);
        return reader;
    }

    public void updateReaderDetails (long id, String name, String email, LocalDate dateOfBirth){
        Reader reader = readerRepository.findById(id).get();

        reader.set
    }

}
