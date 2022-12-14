package com.example.online_bookshelf.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "country_of_origin")
    private String country;
    @Column(name = "english_translation_available")
    private boolean englishTranslationAvailable;

    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties({"author"})
    private List<Book> books;

    public Author(String name, LocalDate dateOfBirth, String country, boolean englishTranslationAvailable) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.englishTranslationAvailable = englishTranslationAvailable;
        this.books = new ArrayList<>();
    }

    public Author(){}

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isEnglishTranslationAvailable() {
        return englishTranslationAvailable;
    }

    public void setEnglishTranslationAvailable(boolean englishTranslationAvailable) {
        this.englishTranslationAvailable = englishTranslationAvailable;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
