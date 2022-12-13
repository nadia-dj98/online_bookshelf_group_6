package com.example.online_bookshelf.components;


import com.example.online_bookshelf.models.Book;
import com.example.online_bookshelf.models.Reader;
import com.example.online_bookshelf.models.Review;
import com.example.online_bookshelf.models.StarRating;
import com.example.online_bookshelf.services.BookService;
import com.example.online_bookshelf.services.ReaderService;
import com.example.online_bookshelf.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ReaderService readerService;

    @Autowired
    BookService bookService;

    @Autowired
    ReviewService reviewService;

    @Override

    public void run(ApplicationArguments args) throws Exception {

        //books
        Book frankenstein = new Book("Frankenstein", "Mary Shelly", 12, "Horror");
        bookService.addBook(frankenstein);

        Book lordOfTheFlies = new Book("Lord of the Flies", "William Golding", 15, "Contemporary");
        bookService.addBook(lordOfTheFlies);

        Book dominicana = new Book("Dominicana", "Angie Cruz", 15, "Contemporary");
        bookService.addBook(dominicana);
        //readers
        Reader nadia = new Reader("Nadia", "nadia.dj@hotmail.com", LocalDate.of(1998, 9, 12));
        readerService.addNewReader(nadia);
        Reader yasmine = new Reader("Yasmine", "yasmine.dj@hotmail.com", LocalDate.of(1996, 12, 1));
        readerService.addNewReader(yasmine);
        Reader sarah = new Reader("Sarah", "sarah.dj@hotmail.com", LocalDate.of(2011, 06, 7));
        readerService.addNewReader(sarah);
        Reader noorah = new Reader("Noorah", "noorah.dj@hotmail.com", LocalDate.of(2001, 01, 1));
        readerService.addNewReader(noorah);





        // amy
      Book callMeByYourName = new Book("Call Me By Your Name", "Andre Aciman", 15, "Romance" );
      bookService.addBook(callMeByYourName);

      Book harryPotter = new Book("Harry Potter and the Philosopher's Stone", "J.K Rowling", 11, "Fantasy");
      bookService.addBook(harryPotter);

      Book mysteriousBenedictSociety = new Book("Mysterious Benedict Society", "Trenton Lee Stewart", 11, "Adventure");
      bookService.addBook(mysteriousBenedictSociety);
      Reader amy = new Reader("Amy", "amy@hotmail.com", LocalDate.of(1999, 4, 3));
      readerService.addNewReader(amy);

      /// bav
        Book boyInStripedPyjamas = new Book("The Boy in the Striped Pyjamas", "John Boyne", 12, "Historical");
        bookService.addBook(boyInStripedPyjamas);
        Book ofMiceAndMen = new Book("Of Mice and Men", "John Steinbeck", 15, "Tragedy");
        bookService.addBook(ofMiceAndMen);
        Book toKillAMockingbird = new Book("To Kill a Mockingbird", "Harper Lee", 12, "Southern Gothic");
        bookService.addBook(toKillAMockingbird);
        Reader bav = new Reader("Bav", "bav.@hotmail.com", LocalDate.of(2000, 01, 25));
        readerService.addNewReader(bav);

        Review ofMiceAndMenReview = new Review(StarRating.FOUR_STAR, "Why did George kill Lenny?", bav, ofMiceAndMen);
        reviewService.addReview(ofMiceAndMenReview);

    }




}
