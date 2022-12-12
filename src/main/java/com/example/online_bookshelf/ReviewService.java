package com.example.online_bookshelf;

import com.example.online_bookshelf.models.Reader;
import com.example.online_bookshelf.models.Review;
import com.example.online_bookshelf.models.StarRating;
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
    public void addReview(StarRating rating, String descriptiveReview){
        Review review = new Review(rating, descriptiveReview);
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
