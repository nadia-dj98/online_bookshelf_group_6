package com.example.online_bookshelf.controllers;

import com.example.online_bookshelf.models.Book;
import com.example.online_bookshelf.models.BookDTO;
import com.example.online_bookshelf.repositories.BookRepository;
import com.example.online_bookshelf.services.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<Book> addNewBook(@RequestBody BookDTO bookDTO){
        Book newBook = bookService.addBook(bookDTO);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Book>> getSpecificGenreOrAllBooks (
            @RequestParam (required = false, value = "genre") String genre){
        if(genre != null) {
            return new ResponseEntity<>(bookService.findSpecificGenre(genre), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookService.displayAllBooks(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Book>> getBookById (@PathVariable long id){
        Optional<Book> book = bookService.findBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> updateBookInformation(@PathVariable long id, @RequestBody BookDTO bookDTO){
        bookService.updateBookInfo(id, bookDTO);
        return new ResponseEntity<>(bookRepository.findById(id).get(), HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



}
