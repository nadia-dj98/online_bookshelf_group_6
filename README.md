# Online Bookshelf API


### Welcome to ``` merge no-conflict```'s first back-end project!

---
## Project Summary
For our back-end project we have created an API that allows book lovers to review their favourite books. To build this we used Java, SpringBoot, and Postgres SQL.

Members: Amy, Nadia and Bav

---
## Project Aims
We decided that our API was to include entities for **books**, **readers** and **reviews**, allowing readers to leave reviews on books: this would constitute a **one-to-many** relationship between readers and reviews, as well as between books and reviews.

We determined the highest priority features that we wanted to implement with our API, summarised as our **MVP**.

- CRUD operations on book entities
- CRUD operations on reader entities
- CRUD operations on review entities

Upon completion of the MVP, further features were implemented as **extensions**.

### **Extensions**

- Create an author entity with CRUD operations
- Implement security via an authentication procedure
- Create derived queries to find books and authors filtered by properties
- Created a book and review DTO to allow transfer of information via requests
---
## ERD and UML Diagrams
#### Below we created an ERD and UML diagram to define the relationships between our different classes.
![Diagram](./Diagrams/Presentations/UML_ERD_Diagrams.jpeg)
---
## Installation instructions:

1. Clone this repository : `git clone git@github.com:nadia-dj98/online_bookshelf_group_6.git `
2. Create a database called bookshelf_api: `createdb bookshelf_api`
3. Make sure you've installed [Postman](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwixpaujxP77AhVwQkEAHTHkAzIQFnoECAoQAQ&url=https%3A%2F%2Fwww.postman.com%2F&usg=AOvVaw05sjAjE_hbftSn2Ii8YG6N) and postgres which  can be installed via home brew: `brew install postgresql` or via the [postgres website.](https://www.postgresql.org)
## Postman requests
To interact with the API, use POSTMAN and the following requests, replacing {id} with an id number

|  Request      | Reader |  Review    |  Book  |  Author  | 
| :---        |    :----   |          :---- |        :---|        :---|
| `POST` /add new    | `localhost:8080/readers/`   | `localhost:8080/reviews/` | `localhost:8080/books/` |`localhost:8080/authors/` |
| `GET` /all | `localhost:8080/readers/`       | `localhost:8080/reviews/`   | `localhost:8080/books/` |`localhost:8080/authors/` |
| `GET` /by Id | `localhost:8080/readers/{id}`       | `localhost:8080/reviews/{id}`   | `localhost:8080/books/{id}` |`localhost:8080/authors/{id}` |
| `GET` /specific objects| `localhost:8080/readers/{id}`   (get books appropriate for a specific readers age)    |    | `localhost:8080/books/books?genre={what genre of books you want}` |`localhost:8080/authors?author={name of author you are looking for}` |
| `PUT` /update | `localhost:8080/readers/{id}`       | `localhost:8080/reviews/{id}`   | `localhost:8080/books/{id}` |`localhost:8080/authors/{id}` |
| `DELETE` /delete | `localhost:8080/readers/{id}`        | `localhost:8080/reviews/{id}`   | `localhost:8080/books/{id}` |`localhost:8080/authors/` |
| `PATCH` /update review |    | `localhost:8080/reviews/{id}`   | | |

## Example Routes 

### POST
To add a new reader, review, book or author use the POST request shown above. 
For example, to add a new book use the POST request `localhost:8080/books` and use the following JSON body:

```
{
    "title" : "A Little Life",
    "author" : "Hanya Yanagihara",
    "ageRating" : 18,
    "genre" : "Traumatic"
}
```

### PUT
To update a specific book/author/readers's information, include it's id in the pathname.
For example, to update the reader with id 1 use the PUT request `localhost:8080/reader/1` and use the following JSON body:

```
{
        "name": "Bob",
        "emailAddress": "newbobemail@yahoo.com",
        "dateOfBirth": "1988-03-12"
}
```

### PATCH
To update a book review, include the book id in the pathname.
For example, for the book with id 1, use the PATCH request `localhost:8080/reviews/1` and use the following JSON body:

```
{
    "starRating" : "FIVE_STAR",
    "descriptiveReview" : "EDIT: now I understand why George killed Lenny"
}
```

## Future Extensions

There are features that we would have liked to implement, but were not possible within the timeframe of the project.

- Creating **genre** as its own entity
    - This would enable filtered searches based on book genres.
- Individual tests
    - Tests were done via Postman to ensure the requests returned the expected outputs; however, individual testing may have also been beneficial.


 

