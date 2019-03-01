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
-   POST [/api/students](http://localhost:8080/hibernate/api/students) : to save a student object.

    The request should sent the body in `application/json` format as follows

    ```json
    {
        "name": "Github",
        "username": "github",
        "email": "hub@git.com"
    }
    ```

[:construction: WIP] other CRUD operations and relevant API endpoints will be updated soon.
