package com.example.online_bookshelf.models;

public class BookDTO {

    private String title;
    private int ageRating;
    private String genre;
    private long authorId;

    public BookDTO(String title, int ageRating, String genre, long authorId) {
        this.title = title;
        this.ageRating = ageRating;
        this.genre = genre;
        this.authorId = authorId;
    }

    public BookDTO(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    }git p

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }
}
