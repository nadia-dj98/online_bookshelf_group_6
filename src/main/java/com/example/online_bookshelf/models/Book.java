package com.example.online_bookshelf.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;

    @ManyToOne
    @JsonIgnoreProperties({"books"})
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "age_rating")
    private int ageRating;
    @Column(name = "genre")
    private String genre;

    //join table insert here
    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties({"book"})
    private List<Review> reviews;


    public Book(String title, Author author, int ageRating, String genre) {
        this.title = title;
        this.author = author;
        this.ageRating = ageRating;
        this.genre = genre;
        this.reviews = new ArrayList<>();
    }

    public Book(String title, int ageRating, String genre) {
        this.title = title;
        this.ageRating = ageRating;
        this.genre = genre;
        this.reviews = new ArrayList<>();
    }

    public Book(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
