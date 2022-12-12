package com.example.online_bookshelf.models;

import com.example.online_bookshelf.models.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

<<<<<<< HEAD
    @OneToMany(mappedBy = "reader")
    @JsonIgnoreProperties({"reader"})
    private List<Review> reviews;
=======
    @OneToMany(mappedBy = "readers")
    @JsonIgnoreProperties({"readers"})
    private List<Review> review;
>>>>>>> b17d387 (added services)

    public Reader(String name, String emailAddress, LocalDate dateOfBirth) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
<<<<<<< HEAD
        this.reviews = new ArrayList<>();
=======
        this.review = new ArrayList<>();
>>>>>>> b17d387 (added services)
    }

    public Reader(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

<<<<<<< HEAD
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
=======
    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
>>>>>>> b17d387 (added services)
    }
}
