package com.example.online_bookshelf.services;

import com.example.online_bookshelf.models.Book;
import com.example.online_bookshelf.models.BookDTO;
import com.example.online_bookshelf.models.Review;
import com.example.online_bookshelf.repositories.AuthorRepository;
import com.example.online_bookshelf.repositories.BookRepository;
import com.example.online_bookshelf.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public Book addBook(BookDTO bookDTO) {
        Book book = new Book(bookDTO.getTitle(), authorRepository.findById(bookDTO.getAuthorId()).get(), bookDTO.getAgeRating(), bookDTO.getGenre());
        bookRepository.save(book);
        return book;
    }

    public List<Book> displayAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(long id) {
        return bookRepository.findById(id);
    }

    public void updateBookInfo(Long id, BookDTO bookParameter){
        Book book = bookRepository.findById(id).get();
        book.setTitle(bookParameter.getTitle());
        book.setAgeRating(bookParameter.getAgeRating());
        book.setGenre(bookParameter.getGenre());
        book.setAuthor(authorRepository.findById(bookParameter.getAuthorId()).get());
        bookRepository.save(book);
    }

    public void deleteBook(long id) {
        List<Review> reviewsToDelete = reviewRepository.findByBook(bookRepository.findById(id).get());
        for (Review review : reviewsToDelete) {
            reviewRepository.deleteById(review.getId());
        }
        bookRepository.deleteById(id);
    }

    public List<Book> findSpecificGenre(String genre){
        return bookRepository.findByGenre(genre);
    }





}
