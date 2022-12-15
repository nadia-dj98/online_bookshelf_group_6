package com.example.online_bookshelf.controllers;

import com.example.online_bookshelf.models.*;
import com.example.online_bookshelf.repositories.ReviewRepository;
import com.example.online_bookshelf.services.ReviewService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    ReviewRepository reviewRepository;

    @PostMapping
    public ResponseEntity<Review> addNewReview(@RequestBody ReviewDTO reviewDTO){
        Review newReview = reviewService.addReview(reviewDTO);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews = reviewService.displayAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Review>> getReviewById(@PathVariable long id){
        return new ResponseEntity<>(reviewService.findReviewById(id), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable long id, @RequestBody ReviewDTO reviewDTO){
        reviewService.updateReview(id, reviewDTO.getStarRating(), reviewDTO.getDescriptiveReview());
        return new ResponseEntity<>(reviewRepository.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteReview(@PathVariable long id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }
}
