package com.example.online_bookshelf;

import javax.persistence.*;

@Entity(name = "reviews")
public class Review {

    @Column(name = "rating")
    private StarRating starRating;

    @Column(name = "descriptive review")
    private String descriptiveReview;

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
