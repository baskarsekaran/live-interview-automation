package api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonPlaceholderTest {

    @Test
    void getPostTest() {

        given()
                .baseUri("https://jsonplaceholder.typicode.com")

        .when()
                .get("/posts/1")

        .then()
                .statusCode(200)
                .contentType("application/json")
                .body("id", equalTo(1))
                .body("userId", equalTo(1))
                .body("title", not(emptyString()))
                .body("body", not(emptyString()));
    }

    @Test
    void createPostTest() {

        String requestBody = """
                {
                  "title": "SDET Interview",
                  "body": "API automation test",
                  "userId": 1
                }
                """;

        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .contentType("application/json")
                .body(requestBody)

        .when()
                .post("/posts")

        .then()
                .statusCode(201)
                .body("title", equalTo("SDET Interview"))
                .body("body", equalTo("API automation test"))
                .body("userId", equalTo(1))
                .body("id", notNullValue());
    }
}