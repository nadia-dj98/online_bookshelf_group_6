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
import java.util.List;

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
//add .findById method in service?
//    @GetMapping
//    public ResponseEntity<Reader> getReaderById(@PathVariable long id){
//        Reader reader = readerService.getReaderById(id);
//    }
//    @GetMapping
//    public ResponseEntity<List<Reader>> getAllReaders(){
//        List<Reader> readers = readerService.displayAllReaders();
//        return new ResponseEntity<>(readers, HttpStatus.OK);
//    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Book>> getAgeAppropriateBooks(@PathVariable long id) {
        return new ResponseEntity<>(readerService.getAgeAppropriateBooks(id), HttpStatus.OK);
    }
//    @GetMapping(value = "/{id}")
//        public ResponseEntity <Integer> getReaderAge(@PathVariable long id) {
//                int readerAge = readerService.calculateAgeInYears(id);
//
//            return new ResponseEntity<>(readerAge, HttpStatus.OK);
//        }
//    @GetMapping
//    public ResponseEntity<List<Book>> getAgeAppropriateBooksForReader()


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
