import com.example.online_bookshelf.models.Book;
import com.example.online_bookshelf.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ReaderService readerService;

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public List<Book> displayAllBooks(){
        return bookRepository.findAll();
    }

    public void updateBookInfo(long id, String title, String author, int ageRating, String genre){
        Book book = bookRepository.findById(id).get();
        book.setTitle(title);
        book.setAuthor(author);
        book.setAgeRating(ageRating);
        book.setGenre(genre);

        bookRepository.save(book);

    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

//    public Book addReaderToList(long bookId, long readerId){
//
//    }

    //filterByGenre method to add



}
