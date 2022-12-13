package com.example.online_bookshelf.controllers;

import com.example.online_bookshelf.models.*;
import com.example.online_bookshelf.repositories.ReviewRepository;
import com.example.online_bookshelf.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    ReviewRepository reviewRepository;

    @PostMapping
    public ResponseEntity<Review> addNewReview(@RequestBody ReviewDTO reviewDTO){
        Review newReview = reviewService.addReview(reviewDTO.getStarRating(), reviewDTO.getDescriptiveReview(), reviewDTO.getReaderId(),reviewDTO.getBookId());
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews = reviewService.displayAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

//    @PatchMapping(value = "/{id}")
//    public ResponseEntity<Review> updateReview(@PathVariable long id, @RequestBody String descriptiveReview){
//        reviewService.updateReview(id, descriptiveReview);
//        return new ResponseEntity<>(reviewRepository.findById(id).get(), HttpStatus.OK);
//    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable long id, @RequestBody StarRating starRating, @RequestBody String descriptiveReview){
        reviewService.updateReview(id, starRating, descriptiveReview);
        return new ResponseEntity<>(reviewRepository.findById(id).get(), HttpStatus.OK);
    }

}
