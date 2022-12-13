package com.example.online_bookshelf.services;

import com.example.online_bookshelf.models.Book;
import com.example.online_bookshelf.models.Reader;
import com.example.online_bookshelf.models.Review;
import com.example.online_bookshelf.models.StarRating;
import com.example.online_bookshelf.repositories.BookRepository;
import com.example.online_bookshelf.repositories.ReaderRepository;
import com.example.online_bookshelf.repositories.ReviewRepository;
import com.example.online_bookshelf.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    BookRepository bookRepository;

    // Need to add input for bookId and readerId
    public Review addReview(StarRating starRating, String descriptiveReview, long readerId, long bookId){
        Review review = new Review(starRating, descriptiveReview, readerRepository.findById(readerId).get(), bookRepository.findById(bookId).get());
        reviewRepository.save(review);
        return review;
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

    public List<Review> displayAllReviews() {
        return reviewRepository.findAll();
    }


}
