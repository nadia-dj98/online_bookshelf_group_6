package com.example.online_bookshelf.controllers;

import com.example.online_bookshelf.models.Reader;
import com.example.online_bookshelf.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {
    @Autowired
    ReaderService readerService;

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
    @GetMapping
    public ResponseEntity<List<Reader>> getAllReaders(){
        List<Reader> readers = readerService.displayAllReaders();
        return new ResponseEntity<>(readers, HttpStatus.OK);
    }

//    @PutMapping
//    public ResponseEntity<Reader> updateReader(@RequestBody Reader reader, @PathVariable long id){
//        readerService.updateReaderDetails(id, name, email, dateOfBirth);
//        return new ResponseEntity<>(reader, HttpStatus.OK);
//    }

    @DeleteMapping
    public ResponseEntity<Long> deleteReader(@PathVariable Long id){
        readerService.deleteReader(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



    //create- post, read-get, update-put/patch?, delete- delete

}
