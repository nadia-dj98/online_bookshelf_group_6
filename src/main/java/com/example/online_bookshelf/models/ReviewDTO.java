package com.example.online_bookshelf.models;

public class ReviewDTO {

    private StarRating starRating;
    private String descriptiveReview;
    private long readerId;
    private long bookId;

    public ReviewDTO(StarRating starRating, String descriptiveReview, long readerId, long bookId) {
        this.starRating = starRating;
        this.descriptiveReview = descriptiveReview;
        this.readerId = readerId;
        this.bookId = bookId;
    }

    public ReviewDTO(){}

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

    public long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
