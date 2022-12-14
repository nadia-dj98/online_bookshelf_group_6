package com.example.online_bookshelf.controllers;

import com.example.online_bookshelf.models.Book;
import com.example.online_bookshelf.repositories.BookRepository;
import com.example.online_bookshelf.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<Book> addNewBook(@RequestBody Book book){
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<Book>> getAllBooks(){
//        List<Book> books = bookService.displayAllBooks();
//        return new ResponseEntity<>(books, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<Book>> getSpecificGenre (
            @RequestParam (required = false, value = "genre") String genre){
        if(genre != null) {
            return new ResponseEntity<>(bookService.findSpecificGenre(genre), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookService.displayAllBooks(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> updateBookInformation(@PathVariable long id, @RequestBody Book book){
        bookService.updateBookInfo(id, book);
        return new ResponseEntity<>(bookRepository.findById(id).get(), HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }



}
