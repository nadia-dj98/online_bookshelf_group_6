package com.example.online_bookshelf.models;

import javax.persistence.*;

@Entity(name = "reviews")
public class Review {

    @Column(name = "rating")
    private StarRating starRating;

    @Column(name = "descriptive review")
    private String descriptiveReview;

    // Hi new comment

    public Review(StarRating starRating, String descriptiveReview) {
        this.starRating = starRating;
        this.descriptiveReview = descriptiveReview;
    }

    public Review(){}

    public StarRating getStarRating() {
        return starRating;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }

    public String getDescriptiveReview() {
        return descriptiveReview;
    }

    public void setDescriptiveReview(String descriptiveReview) {
        this.descriptiveReview = descriptiveReview;
    }
}
