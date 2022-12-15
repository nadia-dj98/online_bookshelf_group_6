# Online Bookshelf API


### Welcome to merge no-conflict's first back-end project!
![image] (online_bookshelf /logo.png)
---
## Project Summary
For our back-end project we have created an API that allows book lovers to review their favourite books. To build this we used Java, SpringBoot, and Postgres SQL.

## Project Aims
We determined the highest priority features that we wanted to implement with our API, summarised as our **MVP**.

- CRUD operations on book entities
- CRUD operations on reader entities
- CRUD operations on review entities




## Installation instructions:

1. Clone this repository : `git clone git@github.com:nadia-dj98/online_bookshelf_group_6.git `
2. Create a database called bookshelf_api: createdb bookshelf_api

## Postman requests
| HTTP Request      | Reader |  Review    |  Book  |  Author  | 
| :---        |    :----   |          :---- |        :---|        :---|
| `POST`      | `localhost:8080/readers/`   | `localhost:8080/reviews/` | `localhost:8080/books/` |`localhost:8080/authors/` |
| `GET` | `localhost:8080/readers/`       | `localhost:8080/reviews/`   | `localhost:8080/books/` |`localhost:8080/authors/` |
| `PUT`  | `localhost:8081/trainers/{command name}/{id}/{what you need to change}`       | `localhost:8081/gyms/{command name}/{id}/{what you want to change}`   | `localhost:8081/gymLeaders/{command name}/{id}/{what you want to change}` |`localhost:8081/gymLeaders/` |
| `DELETE`  | `localhost:8080/readers/{id}`        | `localhost:8080/reviews/{id}`   | `localhost:8080/books/{id}` |`localhost:8080/authors/` |
