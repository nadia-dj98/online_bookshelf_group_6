# Online Bookshelf API


### Welcome to ``` merge no-conflict```'s first back-end project!

---
## Project Summary
For our back-end project we have created an API that allows book lovers to review their favourite books. To build this we used Java, SpringBoot, and Postgres SQL.

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

## ERD and UML Diagrams
### Below we created an ERD and UML diagram to define the relationships between our different classes.
![Diagram](./Diagrams%20/UML_ERD_Diagrams.jpeg)








## Installation instructions:

1. Clone this repository : `git clone git@github.com:nadia-dj98/online_bookshelf_group_6.git `
2. Create a database called bookshelf_api: `createdb bookshelf_api`

## Postman requests
| HTTP Request      | Reader |  Review    |  Book  |  Author  | 
| :---        |    :----   |          :---- |        :---|        :---|
| `POST` /add new    | `localhost:8080/readers/`   | `localhost:8080/reviews/` | `localhost:8080/books/` |`localhost:8080/authors/` |
| `GET` /all | `localhost:8080/readers/`       | `localhost:8080/reviews/`   | `localhost:8080/books/` |`localhost:8080/authors/` |
| `GET` /by Id | `localhost:8080/readers/{id}`       | `localhost:8080/reviews/{id}`   | `localhost:8080/books/{id}` |`localhost:8080/authors/{id}` |
| `GET` /specifc objects| `localhost:8080/readers/{id}`   (get books appropriate for a specifc reader's age)    |    | `localhost:8080/books/books?genre={what genre of books you want}` |`localhost:8080/authors?author={name of author}` |
| `PUT` /update | `localhost:8080/readers/{id}`       | `localhost:8080/reviews/{id}`   | `localhost:8080/books/{id}` |`localhost:8080/authors/{id}` |
| `DELETE`  | `localhost:8080/readers/{id}`        | `localhost:8080/reviews/{id}`   | `localhost:8080/books/{id}` |`localhost:8080/authors/` |
| `PATCH` /update review |    | `localhost:8080/reviews/{id}`   | | |

## POST
When adding a new reader/review/book/author use the path shown above. 
For example, when adding a new book use `localhost:8080/books` and input the body in JSON format as seen in this example for books: 

```
{
    "title" : "A Little Life",
    "author" : "Hanya Yanagihara",
    "ageRating" : 18,
    "genre" : "Traumatic"
}
```

## PUT
To update a specific book/author/readers's information, include it's id in the pathname.
For example, to update the reader with id 1 use the PUT request `localhost:8080/reader/1` and use following body:

```
{
        "name": "Nadia2",
        "emailAddress": "nadia2@hotmail.com",
        "dateOfBirth": "1998-09-12"
}
```

## PATCH
To update a review, include it's id in the PATCH request `localhost:8080/reviews/1` and use for following format:

```
{
    "starRating" : "FIVE_STAR",
    "descriptiveReview" : "EDIT: now I understand why George killed Lenny"
}
```

## Future Extensions

There are features that we would have liked to implemented, but were not possible within the timeframe of the project.

- Creating **genre** as its own entity
    - This would enable filtered searches based on book genres.
- Individual tests
    - Tests were done via Postman to ensure the requests returned the expected outputs; however, individual testing may have also been beneficial.



### 

