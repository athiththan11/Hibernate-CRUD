# Hibernate CRUD

A simple student CRUD Application with Hibernate and PostgreSQL (hosted on [ElephantSQL](https://www.elephantsql.com/))

## Usage

Clone or download the application and replace the configuration and connection properties.

Build the application using the following command

```bash
mvn clean install package
```

and deploy it in your favourite application server.

## API Endpoints

-   GET [/api/students](http://localhost:8080/hibernate/api/students) : to read all students
-   GET [/api/students/{id}](http://localhost:8080/hibernate/api/students/4) : to read a particular student object
-   POST [/api/students](http://localhost:8080/hibernate/api/students) : to save a student object

    The request should send a body in `application/json` format as follows

    ```json
    {
        "name": "Github",
        "username": "github",
        "email": "hub@git.com"
    }
    ```

-   PUT [/api/students/{id}](http://localhost:8080/hibernate/api/students/4) : to update a student object

    The request should send a body in `application/json` format as follows

    ```json
    {
        "name": "Github Microsoft",
        "username": "github",
        "email": "hub@git.com"
    }
    ```

-   DELETE [/api/students/{id}](http://localhost:8080/hibernate/api/students/5) : to delete a student object
