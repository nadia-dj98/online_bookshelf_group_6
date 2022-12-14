package com.example.online_bookshelf.services;

import com.example.online_bookshelf.models.Book;
import com.example.online_bookshelf.models.Reader;
import com.example.online_bookshelf.models.Review;
import com.example.online_bookshelf.repositories.BookRepository;
import com.example.online_bookshelf.repositories.ReaderRepository;
import com.example.online_bookshelf.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    BookRepository bookRepository;
    
    @Autowired
    ReviewRepository reviewRepository;

    public List<Reader> displayAllReaders() {
        return readerRepository.findAll();
    }
    
    public Optional<Reader> findReaderById(long id) {
        return readerRepository.findById(id);
    }

    public Reader addNewReader(Reader reader) {
        readerRepository.save(reader);
        return reader;
    }

    public void deleteReader(long id) {
        
        List<Review> reviewsToDelete = reviewRepository.findByReader(readerRepository.findById(id).get());
        for (Review review : reviewsToDelete) {
            reviewRepository.deleteById(review.getId());
        }
        readerRepository.deleteById(id);
    }

    public void updateReaderDetails (long id, Reader readerParameter){
        Reader reader = readerRepository.findById(id).get();
        reader.setName(readerParameter.getName());
        reader.setEmailAddress(readerParameter.getEmailAddress());
        reader.setDateOfBirth(readerParameter.getDateOfBirth());
        readerRepository.save(reader);
    }

    public int calculateAgeInYears(long id){
        Reader reader = readerRepository.findById(id).get();
        LocalDate birthDate = reader.getDateOfBirth();
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }


    public List <Book> getAgeAppropriateBooks(long id) {
        Integer readerAge = calculateAgeInYears(id);
        return bookRepository.findByAgeRatingLessThanEqual(readerAge);
    }

}
