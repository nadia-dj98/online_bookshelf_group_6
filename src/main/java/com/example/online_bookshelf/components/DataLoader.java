package com.example.online_bookshelf.components;


import com.example.online_bookshelf.models.*;
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

        //authors
        Author maryShelly = new Author("Mary Shelly", LocalDate.of(1797, 8, 30), "United Kingdom", false);
        Author williamGolding = new Author("William Golding", LocalDate.of(1911, 9, 19), "United Kingdom", true);
        Author angieCruz = new Author("Angie Cruz", LocalDate.of(1972,2, 24), "United States of America", false);

        //books
        Book frankenstein = new Book("Frankenstein", maryShelly, 12, "Horror");
        bookService.addBook(frankenstein);

        Book lordOfTheFlies = new Book("Lord of the Flies", williamGolding, 15, "Contemporary");
        bookService.addBook(lordOfTheFlies);

        Book dominicana = new Book("Dominicana", angieCruz, 15, "Contemporary");
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
      Author andreAciman = new Author("Andre Aciman", LocalDate.of(1951,1,2), "Egypt", true);
      Author jKRowling = new Author("J.K Rowling", LocalDate.of(1965,7,31), "England", true);
      Author trentonLeeStewart = new Author("Trenton Lee Stewart", LocalDate.of(1970,5,27), "United States", true);

      Book callMeByYourName = new Book("Call Me By Your Name", andreAciman, 15, "Romance" );
      bookService.addBook(callMeByYourName);

      Book harryPotter = new Book("Harry Potter and the Philosopher's Stone", jKRowling, 11, "Fantasy");
      bookService.addBook(harryPotter);

      Book mysteriousBenedictSociety = new Book("Mysterious Benedict Society", trentonLeeStewart, 11, "Adventure");
      bookService.addBook(mysteriousBenedictSociety);

      Reader amy = new Reader("Amy", "amy@hotmail.com", LocalDate.of(1999, 4, 3));
      readerService.addNewReader(amy);


      /// bav
        Author johnBoyne = new Author("John Boyne", LocalDate.of(1971,4,30), "Ireland", true);
        Author johnSteinbeck = new Author("John Steinbeck", LocalDate.of(1902,2,27), "United States of America", true);
        Author harperLee = new Author("Harper Lee", LocalDate.of(1926,4,28), "United States of America", true);

        Book boyInStripedPyjamas = new Book("The Boy in the Striped Pyjamas", johnBoyne, 12, "Historical");
        bookService.addBook(boyInStripedPyjamas);
        Book ofMiceAndMen = new Book("Of Mice and Men", johnSteinbeck, 15, "Tragedy");
        bookService.addBook(ofMiceAndMen);
        Book toKillAMockingbird = new Book("To Kill a Mockingbird", harperLee, 12, "Southern Gothic");
        bookService.addBook(toKillAMockingbird);
        Reader bav = new Reader("Bav", "bav.@hotmail.com", LocalDate.of(2000, 01, 25));
        readerService.addNewReader(bav);

        //Review ofMiceAndMenReview = new Review(, "Why did George kill Lenny?", bav, ofMiceAndMen);
        reviewService.addReview(StarRating.FOUR_STAR,"Why did George kill Lenny?", bav.getId(), ofMiceAndMen.getId());

    }




}
