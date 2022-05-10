package apigithub;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest {

    public String baseUri= "https://api.github.com";
    public String bearerToken= "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";
    public String repoName;

    @Test
    public void CreateRepo(){
        RestAssured.baseURI = baseUri;

        String requestBody = "{\n"
                +"     \"name\": \"Api-testing-restcall\",\n"
                +"     \"description\": \"Repository created Rest Assured Call\"\n"
                + "}";

        Response response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body(requestBody).
                when()
                .post("/user/repos").
                then().assertThat().statusCode(201).and().
                contentType(ContentType.JSON).
                extract().response();

        String jsonResponse = response.asString();
        io.restassured.path.json.JsonPath responseBody = new JsonPath(jsonResponse);
        System.out.println("Node Id : " + responseBody.get("node_id"));
        System.out.println("Name : " + responseBody.get("name"));

        repoName = responseBody.get("full_name");

    }

    @Test
    public void deleteRepo(){
        RestAssured.baseURI = baseUri;

        given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + bearerToken).
                when()
                .delete("/repos/" + repoName).
                then().assertThat().statusCode(204);

        System.out.println( "Repository Delete" + repoName);
    }
}
