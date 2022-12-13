package com.example.online_bookshelf.controllers;

import com.example.online_bookshelf.models.Reader;
import com.example.online_bookshelf.models.Review;
import com.example.online_bookshelf.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> addNewReview(@RequestBody Review review){
        Review newReview = reviewService.addReview(review);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Review> getReview(@RequestBody long reviewId){

    }

}
