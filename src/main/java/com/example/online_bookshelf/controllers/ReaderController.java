package com.example.online_bookshelf.controllers;

import com.example.online_bookshelf.models.Book;
import com.example.online_bookshelf.models.Reader;
import com.example.online_bookshelf.repositories.ReaderRepository;
import com.example.online_bookshelf.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/readers")
public class ReaderController {
    @Autowired
    ReaderService readerService;

    @Autowired
    ReaderRepository readerRepository;

    @PostMapping
    public ResponseEntity<Reader> addNewReader(@RequestBody Reader reader) {
        Reader newReader = readerService.addNewReader(reader);
        return new ResponseEntity<>(newReader, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<Reader>> getAllReaders(){
//        List<Reader> readers = readerService.displayAllReaders();
//        return new ResponseEntity<>(readers, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<Reader>> getReaderById(@RequestParam (required = false, value = "readerId") Long id){
        if (id != null) {
            List<Reader> readerById = new ArrayList<>();
            readerById.add(readerService.findReaderById(id).get());
            return new ResponseEntity<>(readerById, HttpStatus.OK);
        }

        return new ResponseEntity<>(readerService.displayAllReaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Book>> getAgeAppropriateBooks(@PathVariable long id) {
        return new ResponseEntity<>(readerService.getAgeAppropriateBooks(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Reader> updateReader(@PathVariable long id, @RequestBody Reader reader){
        readerService.updateReaderDetails(id, reader);
        return new ResponseEntity<>(readerRepository.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteReader(@PathVariable Long id){
        readerService.deleteReader(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
