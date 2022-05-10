package gettrello;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetCall {

    @Test
    public void verifyResponseBody() {
        RestAssured.baseURI = "https://api.trello.com";

        given().param("key", "287e1af5fd9cb3d695de29147f1fbc57")
                .param("token",
                        "986346b9495fa5f736cd911d3825e753fa95c929a7825ce5f62a9ba48bd8b202").
                when().get("/1/boards/rUFSAT7v").then().assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("name", equalTo("Mi first board")).and().body("desc", equalTo("Testing description "));
    }

    @Test
    public void verifyResponseHeader() {
        RestAssured.baseURI = "https://api.trello.com";

        given().param("key", "287e1af5fd9cb3d695de29147f1fbc57")
                .param("token", "986346b9495fa5f736cd911d3825e753fa95c929a7825ce5f62a9ba48bd8b202").
                when().get("/1/boards/rUFSAT7v").then().assertThat().statusCode(200).and().log().all().
                contentType(ContentType.JSON).and().
                header("Referrer-Policy", "strict-origin-when-cross-origin").and().
                header("X-Trello-Environment", "Production");
    }
}


