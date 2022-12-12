import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

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


    private List<Book> books;

    public Book(String name, String emailAddress, LocalDate dateOfBirth) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.books = new ArrayList<>();
    }

    public Book(){}

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
