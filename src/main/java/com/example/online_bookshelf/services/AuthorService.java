package com.example.online_bookshelf.services;

import com.example.online_bookshelf.models.Author;
import com.example.online_bookshelf.repositories.AuthorRepository;
import com.example.online_bookshelf.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public List<Author> displayAllAuthors() {
        return authorRepository.findAll();
    }

    public Author addNewAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }

    public void deleteAuthor(long id) {
        authorRepository.deleteById(id);
    }

    public void updateAuthorDetails(long id, Author authorParameter) {
        Author author = authorRepository.findById(id).get();
        author.setName(authorParameter.getName());
        author.setDateOfBirth(authorParameter.getDateOfBirth());
        author.setCountry(authorParameter.getCountry());
        author.setBestseller(authorParameter.isBestseller());
        authorRepository.save(author);
    }

}
