# SDET Live Interview Automation

A minimal Java + Maven automation project created for an SDET technical interview.

## Technology Stack

- Java 17
- Maven
- Selenium WebDriver
- JUnit 6
- REST Assured
- Google Chrome
- JSONPlaceholder API

## Project Structure

live-interview-automation
│
├── pom.xml
├── README.md
├── .gitignore
│
└── src
    └── test
        └── java
            ├── ui
            │   └── GoogleSearchTest.java
            │
            └── api
                └── JsonPlaceholderTest.java

## UI Automation

Website:

https://www.google.com

Test:

`GoogleSearchTest`

The test:

1. Opens Google
2. Validates the page title
3. Finds the Google search box
4. Enters "Selenium Java"
5. Submits the search
6. Validates the search result page

## API Automation

API:

https://jsonplaceholder.typicode.com

Test:

`JsonPlaceholderTest`

### GET Test

Endpoint:

`GET /posts/1`

Validations:

- HTTP status code = 200
- Content type = JSON
- Response id
- Response userId
- Title
- Body

### POST Test

Endpoint:

`POST /posts`

Validations:

- HTTP status code = 201
- Response title
- Response body
- Response userId
- Generated response id

## How to Run

Clone the repository and open it in IntelliJ IDEA or VS Code.

Run all tests:

```bash
mvn clean test