package com.example.online_bookshelf.services;

import com.example.online_bookshelf.models.*;
import com.example.online_bookshelf.repositories.BookRepository;
import com.example.online_bookshelf.repositories.ReaderRepository;
import com.example.online_bookshelf.repositories.ReviewRepository;
import com.example.online_bookshelf.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    BookRepository bookRepository;

    // Need to add input for bookId and readerId
    public Review addReview(ReviewDTO reviewDTO){
        Review review = new Review(reviewDTO.getStarRating(), reviewDTO.getDescriptiveReview(), readerRepository.findById(reviewDTO.getReaderId()).get(), bookRepository.findById(reviewDTO.getBookId()).get());
        reviewRepository.save(review);
        return review;
    }

    public void updateReview(long id, StarRating rating, String descriptiveReview){
        Review review = reviewRepository.findById(id).get();
        review.setStarRating(rating);
        review.setDescriptiveReview(descriptiveReview);
        reviewRepository.save(review);
    }



    public void deleteReview(long id){
        reviewRepository.deleteById(id);
    }

    public List<Review> displayAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> findReviewById(long id) {
        return reviewRepository.findById(id);
    }

}
