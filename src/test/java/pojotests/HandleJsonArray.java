package pojotests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class HandleJsonArray {
    @Test
    public void verifyResponseBody() {
        RestAssured.baseURI = "https://api.trello.com";

        Response response = given().param("key", "287e1af5fd9cb3d695de29147f1fbc57")
                .param("token",
                        "986346b9495fa5f736cd911d3825e753fa95c929a7825ce5f62a9ba48bd8b202").
                when().get("/1/boards/rUFSAT7v").then().assertThat().statusCode(200).and().log().all().
                contentType(ContentType.JSON).and().extract().response();
        String jsonResponse = response.asString();
        JsonPath responseBody = new JsonPath(jsonResponse);

        System.out.println("" + responseBody.get("name"));
        System.out.println("background ID : " + responseBody.get("prefs.background"));
        System.out.println("Background URL : " + responseBody.get("prefs.backgroundImage"));
        System.out.println("Background Image Width : " + responseBody.get("prefs.backgroundImageScaled[4].width"));

    }

    @Test
    public void verifyArraysElements(){
        RestAssured.baseURI = "https://api.trello.com";

        Response response = given().param("key", "287e1af5fd9cb3d695de29147f1fbc57")
                .param("token",
                        "986346b9495fa5f736cd911d3825e753fa95c929a7825ce5f62a9ba48bd8b202").
                when().get("/1/boards/rUFSAT7v").then().assertThat().statusCode(200).and().log().all().
                contentType(ContentType.JSON).and().extract().response();
        String jsonResponse = response.asString();
        JsonPath responseBody = new JsonPath(jsonResponse);

        int backGroundSize = responseBody.getInt("prefs.backgroundImageScaled.size()");

        for(int i = 0; i < backGroundSize; i++){
            int width = responseBody.get("prefs.backgroundImageScaled["+i+"].width");
            int height = responseBody.get("prefs.backgroundImageScaled["+i+"].height");

            System.out.println("Background width at "+i+" is : " + width +" and height is :" + height);
        }


    }
}
