package com.example.online_bookshelf.services;

import com.example.online_bookshelf.models.Book;
import com.example.online_bookshelf.models.Reader;
import com.example.online_bookshelf.models.Review;
import com.example.online_bookshelf.models.StarRating;
import com.example.online_bookshelf.repositories.ReviewRepository;
import com.example.online_bookshelf.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ReaderService readerService;

    @Autowired
    BookService bookService;

    // Need to add input for bookId and readerId
    public void addReview(Review review){
        //Review review = new Review(rating, descriptiveReview, reader, book);
        reviewRepository.save(review);
    }

    public void updateReview(long id, StarRating rating, String descriptiveReview){
        Review review = reviewRepository.findById(id).get();

        review.setStarRating(rating);
        review.setDescriptiveReview(descriptiveReview);

        reviewRepository.save(review);
    }

    // Overloaded
    public void updateReview(long id, StarRating rating){
        Review review = reviewRepository.findById(id).get();

        review.setStarRating(rating);

        reviewRepository.save(review);
    }

    // Overloaded
    public void updateReview(long id, String descriptiveReview){
        Review review = reviewRepository.findById(id).get();

        review.setDescriptiveReview(descriptiveReview);

        reviewRepository.save(review);
    }

    public void deleteReview(long id){
        reviewRepository.deleteById(id);
    }




}
