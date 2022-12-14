package com.example.online_bookshelf.services;

import com.example.online_bookshelf.models.Book;
import com.example.online_bookshelf.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public List<Book> displayAllBooks(){
        return bookRepository.findAll();
    }

    public void updateBookInfo(Long id, Book bookParameter){
        Book book = bookRepository.findById(id).get();
        book.setTitle(bookParameter.getTitle());
        book.setAuthor(bookParameter.getAuthor());
        book.setAgeRating(bookParameter.getAgeRating());
        book.setGenre(bookParameter.getGenre());
        bookRepository.save(book);
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findSpecificGenre(String genre){
        return bookRepository.findByGenre(genre);
    }





}
