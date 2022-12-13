package com.example.online_bookshelf.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "rating")
    private StarRating starRating;

    @Column(name = "descriptive_review")
    private String descriptiveReview;

    @ManyToOne
    @JsonIgnoreProperties({"reviews"})
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @ManyToOne
    @JsonIgnoreProperties({"reviews"})
    @JoinColumn(name = "book_id")
    private Book book;


    public Review(StarRating starRating, String descriptiveReview, Reader reader, Book book) {
        this.starRating = starRating;
        this.descriptiveReview = descriptiveReview;
        this.reader = reader;
        this.book = book;
    }

    public Review(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
