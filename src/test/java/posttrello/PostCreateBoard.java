package posttrello;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostCreateBoard {

    @Test
    public void createBoard(){
        RestAssured.baseURI="https://api.trello.com";
        String board_name = "My Board from API " + (int)Math.random()*100;
        System.out.println("board name = " + board_name);

        given().queryParam("key", "287e1af5fd9cb3d695de29147f1fbc57")
                .queryParam("token", "986346b9495fa5f736cd911d3825e753fa95c929a7825ce5f62a9ba48bd8b202")
                .queryParam("name", board_name)
                .header("Content-Type", "application/json").
                when()
                .post("/1/boards").
                then()
                .assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("name", equalTo(board_name));

    }
    }


