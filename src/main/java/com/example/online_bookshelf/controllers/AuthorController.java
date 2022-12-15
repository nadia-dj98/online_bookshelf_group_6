package com.example.online_bookshelf.controllers;

import com.example.online_bookshelf.models.Author;
import com.example.online_bookshelf.repositories.AuthorRepository;
import com.example.online_bookshelf.services.AuthorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorService.displayAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable long id){
        Optional<Author> author = authorService.findAuthorById(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> addNewAuthor(@RequestBody Author author) {
        Author newAuthor = authorService.addNewAuthor(author);
        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable long id, @RequestBody Author author){
        authorService.updateAuthorDetails(id, author);
        return new ResponseEntity<>(authorRepository.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteAuthor(@PathVariable Long id){
        if (authorService.deleteAuthor(id)) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(id, HttpStatus.METHOD_NOT_ALLOWED);
    }

}
